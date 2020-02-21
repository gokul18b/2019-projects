 <?php
include 'config.php';				
if($_SERVER["REQUEST_METHOD"] == "GET") {
      // username and password sent from form 
      
      $bookid = mysqli_real_escape_string($db,$_GET['bookid']);
      $userid = mysqli_real_escape_string($db,$_GET['userid']); 
     
      $sql = "INSERT INTO `payment` (`id`, `bookid`, `userid`, `purchasestatus`) VALUES (NULL, '$bookid', '$userid', '1');";
      
	  if ($db->query($sql) === TRUE) {
			echo "Payment sucessfully completed";
		} else {
			echo "Error: " . $sql . "<br>" . $db->error;
		}
      
   }
?>