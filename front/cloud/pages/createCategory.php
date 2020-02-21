<?php
/**
 * Created by PhpStorm.
 * User: root
 * Date: 11/18/15
 * Time: 11:13 AM
 */

require "databaseAndFunctions.php";
require_once 'commons.php';

if(isset($_POST['name']) && isset($_POST['description']) && isset($_POST['institution'])){

    $title = $_POST['name'];
    $inst = $_POST['institution'];
    $desc = $_POST['description'];

    $sql = "INSERT INTO `category_info`(`category_name`, `institution`, `description`, `user_id`) VALUES ('$title','$inst','$desc', '$user_id')";
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