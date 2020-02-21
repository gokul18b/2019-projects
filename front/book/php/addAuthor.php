 <?php
include 'config.php';
if($_SERVER["REQUEST_METHOD"] == "GET") {
      // username and password sent from form 
      
      $authorname = mysqli_real_escape_string($db,$_GET['authorname']);
      $description = mysqli_real_escape_string($db,$_GET['description']); 
      $qualification = mysqli_real_escape_string($db,$_GET['qualification']); 
      
      
      $sql = "INSERT INTO `author` (`id`, `authorname`, `description`, `qualification`) VALUES (NULL, '$authorname', '$description', '$qualification');";
      
	  if ($db->query($sql) === TRUE) {
			echo "Author created successfully";
		} else {
			echo "Error: " . $sql . "<br>" . $db->error;
		}
      
   }
?>