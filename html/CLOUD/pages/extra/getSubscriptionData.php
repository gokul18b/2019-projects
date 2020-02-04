<?php
/**
 * Created by PhpStorm.
 * User: sundareswaran
 * Date: 26/9/15
 * Time: 11:51 AM
 */

require_once "databaseAndFunctions.php";

$sql = "select DISTINCT `token`, `uname`, `user_details`.`uid` from `user_details` JOIN `sub_tokens` ON `user_details`.`uid` = `sub_tokens`.`uid` ";

$result = $DB->query($sql);

if ($result) {
    $i = 0;
    while ($row = mysqli_fetch_array($result)) {
        $data[$i]['name'] = $row['uname'];
        $data[$i]['id'] = $row['uid'];
        $i++;
    }
    echo json_encode(array('result' => "success", 'data' => json_encode($data)));
} else {
    echo json_encode(array('result' => "failure", 'reason' => "Cannot get data from table"));
}

$DB->close();

?>