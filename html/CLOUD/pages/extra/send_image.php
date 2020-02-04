<?php

require "databaseAndFunctions.php";

date_default_timezone_set("Asia/Kolkata");
$topic = "myschool";
if (isset($_FILES['image'])) {
    if (isset($_POST['title']))
        $title = $_POST['title'];
    else
        $title = "";
    if (isset($_FILES['image']) && $_FILES['image']['name'] != "") {
        $image = $_FILES['image']['name'];
        $file_name = $image;
        $ext = pathinfo($image, PATHINFO_EXTENSION);
        $allowed = array('jpeg', 'jpg', 'png');
        if (in_array($ext, $allowed)) {
            $file_name_md5 = md5($file_name . date("Y-m-d , h:i:s"));
            $target_file = "image/" . $file_name_md5 . "." . $ext;
            move_uploaded_file($_FILES['image']['tmp_name'], $target_file);
            $file_name = $domain . "pages/" . $target_file;
            echo $file_name;
            work($file_name, $DB, $topic);
        } else {
            echo "File type not allowed";
        }
    }

}


// Doing all the work
function work($file_name, $connect, $topic)
{
    $reg_ids = "";
    $title = $_POST['title'];
    $time = date("Y-m-d , H:i:s");
    $query = "INSERT INTO `images`(`title`, `image`, `time`) VALUES ('$title','$file_name','$time')";
    $result = mysqli_query($connect, $query);
    if ($result) {
        $pid = mysqli_insert_id($connect);
        $selectQuery = "SELECT * FROM `images` WHERE `pid` = '$pid'";
        $selectResult = mysqli_query($connect, $selectQuery);
        if ($selectResult) {
            if ($row = mysqli_fetch_array($selectResult)) {
                $image[] = array("title" => $title, "image" => $file_name, "sno" => $row['sno']);
                $messages = array('image' => $image);
                // TODO uncomment send_push_notification() to send message to devices
                //var_dump($messages);
                //echo "<br>".json_encode($messages);
                send_push_notification($reg_ids, json_encode($messages), $topic);
            }
        }
    } else {
        echo "<br>Error";
    }
}


?>