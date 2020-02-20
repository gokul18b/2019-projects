 <?php
include 'config.php';
if($_SERVER["REQUEST_METHOD"] == "GET") {
	
	  $userid = mysqli_real_escape_string($db,$_GET['userid']);
      
      
      $sql = "select 
				book.id,
				book.bookname,
                author.authorname,
				book.publish,
				book.category,
				book.subject,
				book.price,
				book.ext,
				case when payment.purchasestatus is null then 'Purchase' else 'Download' end as isdownload 
				from book 
				left join payment on(payment.bookid=book.id)
                left join author on(author.id=book.authorid)
				where payment.userid=$userid
				UNION
				select 
				book.id,
				book.bookname,
                author.authorname,
				book.publish,
				book.category,
				book.subject,
				book.price,
				book.ext,
				case when payment.purchasestatus is null then 'Purchase' else 'Download' end as isdownload 
				from book 
				left join payment on(payment.bookid=book.id)
                 left join author on(author.id=book.authorid)
                where payment.userid is null";
		
        $result = mysqli_query($db,$sql);
		$arr = []; 
		$i=0;
		if ($result->num_rows > 0) {
			while($row = $result->fetch_assoc()) {
				$i++;
				$myObj = (object)[]; 
				$myObj->id=$row["id"];  
				$myObj->bookname=$row["bookname"];  
				$myObj->authorname=$row["authorname"];  
				$myObj->publish=$row["publish"];  
				$myObj->category=$row["category"];  
				$myObj->subject=$row["subject"];  
				$myObj->price=$row["price"];  
				$myObj->isdownload=$row["isdownload"];  
				$myObj->ext=$row["ext"];  
				$myJSON=json_encode($myObj);  
				
				$arr[]=$myObj;
			}
		}   
		
		print_r(json_encode($arr));  
			
   }
?>