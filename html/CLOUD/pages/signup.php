<?php
/**
 * Created by PhpStorm.
 * User: sundareswaran
 * Date: 25/9/15
 * Time: 4:53 PM
 */

require "databaseAndFunctions.php";

$data = array();

$validater = true;
foreach ($_POST as $key => $value) {
    $validater = isset($_POST[$key]) && $value !== "" && $validater;
    $data[$key] = stripcslashes($value);
    $data[$key] = $DB->real_escape_string($data[$key]);
}

foreach ($data as $key => $value) {
    switch ($key) {
        case "name":
            $name = $value;
            break;
        case "password":
            $password = md5($value . $salt);
            //echo $password;
            break;
        case "email":
            $email = $value;
            break;
        case "institution":
            $institution = $value;
            break;
        case "city":
            $city = $value;
            break;
    }
}

if ($validater) {

    $sql = "INSERT INTO `user_info` (`name`, `email`, `phone`,`institution`,`place`, `password`)
                        VALUES ('$name','$email','0','$institution', '$city', '$password')";

    $result = $DB->query($sql);
	
    if ($result) {
        echo json_encode(array('result' => "success"));
        header('Location: ' . $_SERVER['HTTP_REFERER']);
    } else {
        echo json_encode(array('result' => "failure", 'reason' => "Cannot register person"));
    }

} else {
    echo json_encode(array('result' => "failure", 'reason' => "Some data missing"));
}

$DB->close();

?>