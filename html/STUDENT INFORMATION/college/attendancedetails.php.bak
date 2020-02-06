


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

  $id=$_GET['id'];
 $sql="SELECT * FROM attendance WHERE sid =".$id;
$res = $conn->query($sql);

if ($result=mysqli_query($conn,$sql))
  {
  $rowcount=mysqli_num_rows($result);
  mysqli_free_result($result);
	if($rowcount==0){

	}
	else{
		
		while($row = $res->fetch_assoc()) {
			$h='';
		
		$data['date'] =$row['date'];
		$data['day']="";
		$data['dayStatus']="W";
		$h[]=$row['I'];
		$h[]=$row['II'];
		$h[]=$row['III'];
		$h[]=$row['IV'];
		$h[]=$row['V'];
		$h[]=$row['VI'];
		$data['att_report']=$h;
		
		$r['status']=true;
		$r['punchcount']=6;
		$r['Dates'][]=$data;
			
    }
	echo json_encode($r);

		 
		
		
		
		
	}
 }
$conn->close();
?> 