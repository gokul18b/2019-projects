 <?php
include 'config.php';
if($_SERVER["REQUEST_METHOD"] == "GET") {
      
      $sql = "SELECT `id`,`authorname`,`description`,`qualification` FROM `author`";
      $result = mysqli_query($db,$sql);
		$arr = []; 
		$i=0;
		if ($result->num_rows > 0) {
			while($row = $result->fetch_assoc()) {
				$i++;
				$myObj = (object)[]; 
				$myObj->id=$row["id"];  
				$myObj->authorname=$row["authorname"];  
				$myObj->description=$row["description"];  
				$myJSON=json_encode($myObj);  
				
				$arr[]=$myObj;
			}
		}   
		
		print_r(json_encode($arr));  
			
   }
?>