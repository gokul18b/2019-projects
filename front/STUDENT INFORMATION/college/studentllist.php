


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

  $id=$_POST['id'];
 $sql="select u.id as id,cid,u_type,username,password,name,mobile,age,dob,email,image,c.id as c_id,c.class_name  from user as u left join class as c on (c.id=u.cid) where u.cid=".$id." and u.u_type='S'";
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
		$data['username'] =$row['username'];
		$data['password'] =$row['password'];
		$data['name'] =$row['name'];
		$data['mobile'] =$row['mobile'];
		$data['age'] =$row['age'];		
		$data['dob'] =$row['dob'];		
		$data['email'] =$row['email'];		
		$data['image'] =$row['image'];		
		$data['classname'] =$row['class_name'];	
		$r['data'][]=$data;
			
    }
	echo json_encode($r);

		 
		
		
		
		
	}
 }
$conn->close();
?> 