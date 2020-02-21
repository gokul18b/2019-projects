 <?php
include 'config.php';
if($_SERVER["REQUEST_METHOD"] == "GET") {
      // username and password sent from form 
      
      $firstname = mysqli_real_escape_string($db,$_GET['firstname']);
      $lastname = mysqli_real_escape_string($db,$_GET['lastname']); 
      $mobile = mysqli_real_escape_string($db,$_GET['mobile']); 
      $email = mysqli_real_escape_string($db,$_GET['email']); 
      $username = mysqli_real_escape_string($db,$_GET['username']); 
      $password = mysqli_real_escape_string($db,$_GET['password']); 
      
      $sql = "INSERT INTO `user` (`id`, `firstname`, `lastname`, `mobile`, `email`, `username`, `password`) VALUES (NULL, '$firstname', '$lastname', '$mobile', '$email', '$username', '$password');";
      
	  if ($db->query($sql) === TRUE) {
			echo "User created successfully";
		} else {
			echo "Error: " . $sql . "<br>" . $db->error;
		}
      
   }
?>