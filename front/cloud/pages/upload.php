
<?php

require "databaseAndFunctions.php";

$allowed = array('jpeg', 'jpg', 'JPG', 'png', 'PNG', 'pdf', 'ppt', 'pptx', 'doc', 'txt');
$note_id = $_POST['note_id'];
$file=$_FILES['file']['name'];
$target_dir = "data/";
$upload = 1;
$user_id = $_SESSION['userId'];
$ext = pathinfo($file, PATHINFO_EXTENSION);
#echo $ext;
switch($ext)
{
    case 'pdf':
        $target_dir = "data/pdf/";
        $target_file = $target_dir . basename($_FILES["file"]["name"]);
        if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
            echo "The file ". basename( $_FILES["file"]["name"]). " has been uploaded.";
        }else{
            echo "not uploaded";
        }break;
    case 'jpeg':
    case 'jpg':
    case 'JPG':
    case 'PNG':
    case 'png';
        $target_dir = "data/jpg/";
        $target_file = $target_dir . basename($_FILES["file"]["name"]);
        if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
            $link = $target_file;
            $filename = $_FILES['file']['name'];
            $sql = "insert into `file_info` (`note_id`, `name`, `file_link`, `user_id`) VALUES ('$note_id','$filename', '$link', '$user_id')";
            $result = mysqli_query($DB, $sql);
            if ($result) {
                echo "File Uploaded";
                header('Location: ' . $_SERVER['HTTP_REFERER']);
            }else{
                echo "not uploaded";
            }
        }break;
	case 'pptx':
    case 'ppt':
        $target_dir = "data/ppt/";
        $target_file = $target_dir . basename($_FILES["file"]["name"]);
        if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
            echo "The file ". basename( $_FILES["file"]["name"]). " has been uploaded.";
	        $link = $target_file;
	        $filename = $_FILES['file']['name'];
	        $sql = "insert into `file_info` (`note_id`, `name`, `file_link`, `user_id`) VALUES ('$note_id','$filename', '$link', '$user_id')";
	        $result = mysqli_query($DB, $sql);
	        if ($result) {
		        echo "File Uploaded";
		        header('Location: ' . $_SERVER['HTTP_REFERER']);
	        }else{
		        echo "not uploaded";
	        }
        }break;
    case 'doc':
    case 'dox':
        $target_dir = "data/doc/";
        $target_file = $target_dir . basename($_FILES["file"]["name"]);
        if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
            echo "The file ". basename( $_FILES["file"]["name"]). " has been uploaded.";
	        $link = $target_file;
	        $filename = $_FILES['file']['name'];
	        $sql = "insert into `file_info` (`note_id`, `name`, `file_link`, `user_id`) VALUES ('$note_id','$filename', '$link', '$user_id')";
	        $result = mysqli_query($DB, $sql);
	        if ($result) {
		        echo "File Uploaded";
		        header('Location: ' . $_SERVER['HTTP_REFERER']);
	        }else{
		        echo "not uploaded";
	        }
        }break;

    case 'txt':
        $target_dir = "data/text/";
        $target_file = $target_dir . basename($_FILES["file"]["name"]);
        if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
            echo "The file ". basename( $_FILES["file"]["name"]). " has been uploaded.";
	        $link = $target_file;
	        $filename = $_FILES['file']['name'];
	        $sql = "insert into `file_info` (`note_id`, `name`, `file_link`, `user_id`) VALUES ('$note_id','$filename', '$link', '$user_id')";
	        $result = mysqli_query($DB, $sql);
	        if ($result) {
		        echo "File Uploaded";
		        header('Location: ' . $_SERVER['HTTP_REFERER']);
	        }else{
		        echo "not uploaded";
	        }
        }
        break;

	default:
		$target_dir = "data/";
		$target_file = $target_dir . basename($_FILES["file"]["name"]);
		if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
			echo "The file ". basename( $_FILES["file"]["name"]). " has been uploaded.";
			$link = $target_file;
			$filename = $_FILES['file']['name'];
			$sql = "insert into `file_info` (`note_id`, `name`, `file_link`, `user_id`) VALUES ('$note_id','$filename', '$link', '$user_id')";
			$result = mysqli_query($DB, $sql);
			if ($result) {
				echo "File Uploaded";
				header('Location: ' . $_SERVER['HTTP_REFERER']);
			}else{
				echo "not uploaded";
			}
		}
		break;


}

if (!in_array($ext, $allowed)) {
    echo "Not Supported formated";
    session_start();
    echo json_encode($_SESSION['last_post']);
//    header('Location: ' . $_SERVER['HTTP_REFERER']);
}
$upload=0;
//header("Location: index.html");


?>