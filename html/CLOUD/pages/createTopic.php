<?php
/**
 * Created by PhpStorm.
 * User: root
 * Date: 11/18/15
 * Time: 1:46 PM
 */

require "databaseAndFunctions.php";
require_once 'commons.php';

if(isset($_POST['cat_id']) && isset($_POST['name']) && isset($_POST['description']) && isset($_POST['institution'])){

    $title = $_POST['name'];
    $inst = $_POST['institution'];
    $desc = $_POST['description'];
    $cid = $_POST['cat_id'];

    $sql = "INSERT INTO `topic_info`( `topic_name`, `institution`, `description`, `category`, `user_id`) VALUES ('$title','$inst','$desc','$cid', '$user_id')";
    $result = mysqli_query($DB,$sql);
    if($result){
        echo 'created successfully';
        header('Location: ' . $_SERVER['HTTP_REFERER']);
    }else{
        echo "error in submission";
        header('Location: ' . $_SERVER['HTTP_REFERER']);
    }
}else{
    echo "not enough values";
    echo json_encode($_POST);
}