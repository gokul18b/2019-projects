<?php

echo json_encode( $_POST );


if ( ! isset( $_POST['mail_id'] ) || $_POST['mail_id'] === "" || $_POST['password'] === "" || ! isset( $_POST['password'] ) ) {
	echo json_encode( array( 'result' => "failure", 'reason' => "Some inputs are missing" ) );
} else {

	require "databaseAndFunctions.php";

	$email    = stripcslashes( $_POST['mail_id'] );
	$password = stripcslashes( $_POST['password'] );

	$email    = $DB->real_escape_string( $email );
	$password = $DB->real_escape_string( $password );
	//echo $password;
	$password = md5( $password . $salt );
	//echo $password;
	$sql = "Select `name`, `uid`, `email` from `user_info` where `email` = '$email' AND `password` = '$password'";
echo $sql;

	$result = $DB->query( $sql );
	if ( $result ) {
		$row = mysqli_fetch_array( $result );
		if ( $row != null ) {
			if ( $row['email'] === $email ) {
				session_start();
				$_SESSION['userId']    = $row['uid'];
				$_SESSION['userName']  = $row['uname'];
				$_SESSION['sessionID'] = md5( $row['uname'] );
				// echo json_encode(array('result' => "success", 'name' => $row['uname'], 'id' => $row['uid']));
				//$_SESSION['login'] = true;
				header( "Location: categories.php" );
			}
		} else {
			echo json_encode( array( 'result' => "failure", 'reason' => "No user match found" ) );
			/*        echo <<< t
					<script language="javascript">
					window.location.href = "index.html";
						</script>

		t;*/    //header('Location: ' . $_SERVER['HTTP_REFERER']);
		}
	} else {
		echo json_encode( array( 'result' => "failure", 'reason' => "No user match found" ) );
		/*      echo <<< t
			  <script language="javascript">
			  window.location.href = "index.html";
				  </script>
	  t;*/
		//header('Location: ' . $_SERVER['HTTP_REFERER']);
	}

	$DB->close();
}
?>