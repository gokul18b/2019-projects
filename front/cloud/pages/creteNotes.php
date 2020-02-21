<?php
/**
 * Created by PhpStorm.
 * User: root
 * Date: 11/18/15
 * Time: 1:21 PM
 */

require "databaseAndFunctions.php";
require_once 'commons.php';

if ( isset( $_POST['topic_id'] ) && isset( $_POST['title'] ) && isset( $_POST['description'] ) ) {

	$title = $_POST['title'];
	$desc  = $_POST['description'];
	$tid   = $_POST['topic_id'];

	$sql    = "INSERT INTO `note_info`(`title`, `description`, `topic`, `user_id`) VALUES ('$title','$desc','$tid', '$user_id')";
	$result = mysqli_query( $DB, $sql );
	if ( $result ) {
		echo 'created successfully';
		header( 'Location: ' . $_SERVER['HTTP_REFERER'] );
	} else {
		echo "error in submission";
		header( 'Location: ' . $_SERVER['HTTP_REFERER'] );
	}
} else {
	echo "not enough values";
}