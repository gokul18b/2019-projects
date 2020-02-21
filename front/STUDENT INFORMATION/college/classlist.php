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


 $sql="SELECT * from class";
$res = $conn->query($sql);

if ($result=mysqli_query($conn,$sql))
  {
  $rowcount=mysqli_num_rows($result);
  mysqli_free_result($result);
	if($rowcount==0){
		echo '{"data":{"status":2,"msg":"Invalid id"}}';
	}
	else{
		
		while($row = $res->fetch_assoc()) {
			
		
		$data['id'] =$row['id'];
		$data['class'] =$row['class_name'];
		
		$r['data'][]=$data;
			
    }
	echo json_encode($r);

		 
		
		
		
		
	}
 }
$conn->close();
?> 