 <?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "college";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

date_default_timezone_set('Asia/Kolkata');

$timestamp = time();
$date_time = date("d-m-Y (D) H:i:s", $timestamp);


$cid=$_POST['cid'];
$sub = $_POST['sub'];
$des = $_POST['des'];
$givenby = $_POST['givenby'];
$sql = "INSERT INTO `college`.`homework` (`id`,`cid`, `sub`, `des`, `given`,`date`) VALUES (NULL,".$cid." ,'".$sub."', '".$des."', ".$givenby.",'".$date_time."');";

if ($conn->query($sql) === TRUE) {
	echo 'sucess';
}
							


								
  $conn->close();
?> 