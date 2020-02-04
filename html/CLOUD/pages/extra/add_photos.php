<form action="add_photos.php" method="POST"
      enctype="multipart/form-data">
    title:<br>
    <input type="text" name="title" value="">
    <br>
    <input type="file" name="image" size="50"/>
    <br/>
    <input type="submit" value="Submit">
</form>
<?php

require "databaseAndFunctions.php";

date_default_timezone_set("Asia/Kolkata");

if (isset($_FILES['image']) && isset($_POST['title']) && $_FILES['image']['name'] != "") {
    $image = $_FILES['image']['name'];
    $file_name = $image;
    $ext = pathinfo($image, PATHINFO_EXTENSION);
    $allowed = array('jpeg', 'jpg', 'png');
    if (in_array($ext, $allowed)) {
        $file_name_md5 = md5($file_name . date("Y-m-d , h:i:s"));
        $target_file = "image/" . $file_name_md5 . "." . $ext;
        move_uploaded_file($_FILES['image']['tmp_name'], $target_file);
        $file_name = $domain . $target_file;
        work($file_name, $DB);
    } else {
        echo "File type not allowed";
    }
} else {
    echo "Some Details are missing";
}

// Doing all the work
function work($file_name, $connect)
{
    $topic = "myschool";
    $reg_ids = "";
    $title = $_POST['title'];
    $time = date("Y-m-d , H:i:s");
    $query = "INSERT INTO `images`(`title`, `image`, `time`) VALUES ('$title', '$file_name', '$time')";
    $result = mysqli_query($connect, $query);
    if ($result) {
        $pid = mysqli_insert_id($connect);
        $selectQuery = "SELECT * FROM `images` WHERE `sno` = '$pid'";
        $selectResult = mysqli_query($connect, $selectQuery);
        if ($selectResult) {
            if ($row = mysqli_fetch_array($selectResult)) {
                $message[] = array("result" => "success", "title" => $title, "image" => $file_name, "date" => $row['time']);
                $messages = array('image' => $message);
                // TODO uncomment send_push_notification() to send message to devices
                //var_dump($messages);
                echo "<br><br>" . json_encode($messages) . "<br><br><br> Add more images if you want.<br>";
                send_push_notification($reg_ids, json_encode($messages), $topic);
            }
        }
    } else {
        echo "<br>Error";
        //echo json_encode(array('result' => "failure", 'reason' => "cannot insert data into table"));
    }
}

$DB->close();

?>