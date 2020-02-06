<?php
/**
 * Created by PhpStorm.
 * User: Sanjay
 * Date: 29-10-2015
 * Time: 22:13
 */
session_start();
session_unset();
session_destroy();
//$_SESSION['login'] = false;
header("Location: index.html");
?>