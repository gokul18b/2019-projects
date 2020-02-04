<?php
/**
 * Created by PhpStorm.
 * User: root
 * Date: 11/22/15
 * Time: 10:09 AM
 */
//var_dump($_FILES['dataFile']['name']);
// connect and login to FTP server
    $ftp_username = "sundareswaran25@gmail.com";
    $ftp_userpass = "sundar123";
    $ftp_server = "ftp2.filefactory.com";
    $ftp_conn = ftp_connect($ftp_server) or die("Could not connect to $ftp_server");
    $login = ftp_login($ftp_conn, $ftp_username, $ftp_userpass);

    $file = $_FILES['dataFile']['tmp_name'];

// upload file
    if (ftp_put($ftp_conn, "data/serverfile.png", $file, FTP_ASCII)) {
        echo "Successfully uploaded". $file;
    } else {
        echo "Error uploading $file";
    }

// close connection
    ftp_close($ftp_conn);
?>