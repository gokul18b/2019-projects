


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

  $id=$_POST['cid'];
 $sql="select * from user join homework on user.id = homework.given where homework.cid =".$id;
$res = $conn->query($sql);

if ($result=mysqli_query($conn,$sql))
  {
  $rowcount=mysqli_num_rows($result);
  mysqli_free_result($result);
	if($rowcount==0){

	}
	else{
		
		while($row = $res->fetch_assoc()) {
			
		
		$data['id'] =$row['id'];
		$data['sub'] =$row['sub'];
		$data['des'] =$row['des'];
		$data['name'] =$row['name'];
		$data['date'] =$row['date'];
		
		$r['data'][]=$data;
			
    }
	echo json_encode($r);

		 
		
		
		
		
	}
 }
$conn->close();
?> 