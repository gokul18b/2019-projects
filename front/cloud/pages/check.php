<?php
/**
 * Created by PhpStorm.
 * User: root
 * Date: 11/14/15
 * Time: 6:23 PM
 */
require_once 'commons.php';
?>

<form action="ftpUpload.php" method="post" enctype="multipart/form-data">
    <input type="file" name="dataFile">
    <input type="submit" value="Upload">
</form>
