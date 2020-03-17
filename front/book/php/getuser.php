 <?php
include 'config.php';
if($_SERVER["REQUEST_METHOD"] == "GET") {
	
	  
      
      
      $sql = "select 
				firstname,lastname,mobile,email from user";
		
        $result = mysqli_query($db,$sql);
		$arr = []; 
		$i=0;
		if ($result->num_rows > 0) {
			while($row = $result->fetch_assoc()) {
				$i++;
				$myObj = (object)[]; 
				$myObj->firstname=$row["firstname"];  
				$myObj->lastname=$row["lastname"];  
				$myObj->mobile=$row["mobile"];  
				$myObj->email=$row["email"];  
				
				$myJSON=json_encode($myObj);  
				
				$arr[]=$myObj;
			}
		}   
		
		print_r(json_encode($arr));  
			
   }
?>