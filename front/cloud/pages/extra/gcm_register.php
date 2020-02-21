<?php
/**
 * User: Sundareswaran
 * Date: 30-07-2015
 * Time: 10:24 AM
 */

require 'databaseAndFunctions.php';

if (isset($_POST['token'])) {
    if (isset($_POST['user_id']))
        $user_id = $_POST['user_id'];
    else
        $user_id = 0;
    $token = $_POST['token'];
    $query = "INSERT INTO `gcm_tokens`(`token`) VALUES ('$token');";
    $result = mysqli_query($DB, $query);
    $selectQuery = "SELECT * FROM `contributors`";
    $resultContributors = mysqli_query($DB, $selectQuery);
    if ($resultContributors) {
        while ($row = mysqli_fetch_array($resultContributors)) {
            $name = $row['name'];
            $fb_url = $row['fb_url'];
            $tweet_url = $row['tweet_url'];
            $file_name = $row['image'];
            $message[] = array("name" => $name, "url_fb" => $fb_url, "url_tweet" => $tweet_url, "image" => $file_name);
            // TODO uncomment send_push_notification() to send message to devices
            //var_dump($messages);
            //echo "<br>".json_encode($messages);
        }
    }
    $sql = "SELECT * FROM `posts` ORDER BY `posts`.`pid` DESC LIMIT 0, 30 ";
    $postResult = mysqli_query($DB, $sql);
    if ($postResult) {
        while ($row = mysqli_fetch_array($postResult)) {
            $posts[] = array("message" => $row['description'], "name" => $row['name'], "title" => $row['title'], "image" => $row['image'], "date" => $row['time'], "url" => $row['url']);
        }
        // TODO uncomment send_push_notification() to send message to devices
        //var_dump($messages);
        //echo "<br>".json_encode($messages);
        //send_push_notification($reg_ids,json_encode($messages));
    }
    $sql = "SELECT * FROM `images` ORDER BY `sno` DESC LIMIT 0,30";
    $imageResult = mysqli_query($DB, $sql);
    if ($imageResult) {
        while ($row = mysqli_fetch_array($imageResult)) {
            $images[] = array('sno' => $row['sno'], 'title' => $row['title'], 'image' => $row['image']);
        }
    }
    $x = array('result' => "success", 'people' => $message, 'post' => $posts, 'image' => $images);
    $contentArr = str_split(json_encode($x), 65536);
    foreach ($contentArr as $part) {
        echo $part;
    }
} else
    echo json_encode(array('result' => "failure"));

?>