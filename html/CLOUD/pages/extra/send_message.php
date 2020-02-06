<?php

require "databaseAndFunctions.php";

date_default_timezone_set("Asia/Kolkata");

if (isset($_POST['message']) && isset($_POST['title']) && isset($_POST['name'])) {
    //var_dump($_FILES[$image]);
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
            //echo $file_name;
            work($file_name, $DB);

        } else {
            echo json_encode(array('result' => "failure", 'response' => "Some details missing"));
        }
    } else {
        work("", $DB);
    }
} else {
    echo json_encode(array('result' => "failure", 'response' => "Some details missing"));
}

// Doing all the work
function work($file_name, $connect)
{
    $topic = "myschool";
    $reg_ids = "";
    $title = $_POST['title'];
    $name = $_POST['name'];
    $description = $_POST['message'];
    $url = "";
    if (isset($_POST['url']))
        $url = $_POST['url'];
    $time = date("Y-m-d , H:i:s");
    $query = "INSERT INTO `posts`(`title`, `description`, `name`, `image`, `url`, `time`) VALUES ('$title', '$description', '$name', '$file_name', '$url', '$time')";
    $result = mysqli_query($connect, $query);
    if ($result) {
        $pid = mysqli_insert_id($connect);
        $selectQuery = "SELECT * FROM `posts` WHERE `pid` = '$pid'";
        $selectResult = mysqli_query($connect, $selectQuery);
        if ($selectResult) {
            if ($row = mysqli_fetch_array($selectResult)) {
                $message[] = array("message" => $description, "name" => $name, "title" => $title, "image" => $file_name, "date" => $row['time'], "url" => $url);
                $messages = array('post' => $message);
                // TODO uncomment send_push_notification() to send message to devices
                //var_dump($messages);
                //echo "<br>".json_encode($messages);
                echo send_push_notification($reg_ids, json_encode($messages), $topic);
            }
        }
    } else {
        echo json_encode(array('result' => "failure", 'response' => "Something went wrong."));
    }
}

?>