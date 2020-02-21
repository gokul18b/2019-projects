 <?php
include 'config.php';




				
if($_SERVER["REQUEST_METHOD"] == "POST") {
      // username and password sent from form 
      
      $authorid = mysqli_real_escape_string($db,$_GET['authorid']);
      $bookname = mysqli_real_escape_string($db,$_GET['bookname']); 
      $publish = mysqli_real_escape_string($db,$_GET['publish']); 
      $category = mysqli_real_escape_string($db,$_GET['category']); 
      $subject = mysqli_real_escape_string($db,$_GET['subject']); 
      $price = mysqli_real_escape_string($db,$_GET['price']); 
      
	   $path = $_FILES['file']['name'];
		$ext = pathinfo($path, PATHINFO_EXTENSION);
      
      $sql = "INSERT INTO `book` (`id`, `authorid`, `bookname`, `publish`, `category`, `subject`, `price`,`ext`) VALUES (NULL, '$authorid', '$bookname', '$publish', '$category', '$subject', '$price','$ext');";
      
	  if ($db->query($sql) === TRUE) {

			$last_id = $db->insert_id;
			if($_FILES["file"]["name"] != '')
			{
				 //$test = explode('.', $_FILES["file"]["name"]);
				// $ext = end($test);
				 //$name = rand(100, 999) . '.' . $ext;
				 $path = $_FILES['file']['name'];
					$ext = pathinfo($path, PATHINFO_EXTENSION);
				 $location = './upload/' . $last_id.'.'.$ext;  
				 move_uploaded_file($_FILES["file"]["tmp_name"], $location);
				 //echo '<img src="'.$location.'" height="150" width="225" class="img-thumbnail" />';
				 echo "Book created successfully";
				//print_r($_FILES["file"]);
			}
			
			
		} else {
			echo "Error: " . $sql . "<br>" . $db->error;
		}
      
   }
?>