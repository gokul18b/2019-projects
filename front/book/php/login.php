 <?php
include 'config.php';

if($_SERVER["REQUEST_METHOD"] == "GET") {
      // username and password sent from form 
      
      $myusername = mysqli_real_escape_string($db,$_GET['username']);
      $mypassword = mysqli_real_escape_string($db,$_GET['password']); 
      
      $sql = "SELECT id FROM admin WHERE username = '$myusername' and password = '$mypassword'";
      $result = mysqli_query($db,$sql);
      $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
      $id = $row['id'];
      
      $count = mysqli_num_rows($result);
      
      // If result matched $myusername and $mypassword, table row must be 1 row
	  if($count == 1) {
			$myObj = (object)[]; 
			$myObj->id=$id;  
			$myObj->status=1;  
			$myObj->message="Sucess";  
			$myJSON=json_encode($myObj);  
			echo($myJSON);
		  
      }else {
		  
		  $sql = "SELECT id FROM user WHERE username = '$myusername' and password = '$mypassword'";
		  $result = mysqli_query($db,$sql);
		  $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
		  $id = $row['id'];
		  
		  $count = mysqli_num_rows($result);
		  
		   if($count == 1) {
				$myObj = (object)[]; 
				$myObj->id=$id;  
				$myObj->status=2;  
				$myObj->message="Sucess";  
				$myJSON=json_encode($myObj);  
				echo($myJSON);
		 }else{
			  
			  $message = 'Invalid username or password';
			  $myObj = (object)[]; 
			  $myObj->status=0;  
			  $myObj->message=$message;  
			  $myJSON=json_encode($myObj);  
			  echo($myJSON);
		 }
      }
      
   }
?>