var customer_id;
$(document).ready(function(){
	load();
});

function load(){
	getUser();
	getAuthors();
	getBookList();
	getPayment();
}

function getUser(){
	$.ajax({
			type:"GET",
			url:"http://localhost/book/php/getuser.php",
			success: function(datas) {
				var res = JSON.parse(datas);
				
				var html =``;
				
				for (var i in res) {
					var data = res[i];

					html += `<tr>
					  <th scope="row">`+(++i)+`</th>
					  <td>`+data.firstname+`</td>
					  <td>`+data.lastname+`</td>
					  <td>`+data.mobile+`</td>
					  <td>`+data.email+`</td>
					</tr>`;
				}
				$("#userbody").html(html)
				
				
			},
		});	
}

function getAuthors(){
	
	$.ajax({
			type:"GET",
			url:"http://localhost/book/php/getAuthor.php",
			success: function(datas) {
				var res = JSON.parse(datas);
				
				var html =``;
				
				for (var i in res) {
					var data = res[i];

					html += `<option id=`+data.id+`>`+data.authorname+`</option>`;
				}
				$("#authornames").html(html)
				
				
			},
		});	
}

function login(){
	
	var username = $("#username").val();
	var password = $("#password").val();
	
	
	$.ajax({
			type:"GET",
			url:"http://localhost/book/php/login.php?username="+username+"&password="+password,
			success: function(datas) {
				var data = JSON.parse(datas);
				
				if(data.status==1){
					 window.location="/book/author-register.html";
				}else if(data.status==2){
					window.location="/book/book-details.html?id="+data.id;
				}else{
					alert('Invalid username and password')	
				}
			},
		});	
}
function addAuthor(){
	var authorname = $("#authorname").val();
	var description = $("#description").val();
	var qualification = $("#qualification").val();
	$.ajax({
			type:"GET",
			url:"http://localhost/book/php/addAuthor.php?authorname="+authorname+"&description="+description+"&qualification="+qualification,
			success: function(datas) {
				alert(datas);
				 $("#authorname").val("");
				 $("#description").val("");
				 $("#qualification").val("");
			},
		});	
}

function addUser(){
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var username = $("#username").val();
	var password = $("#password").val();
	$.ajax({
			type:"GET",
			url:"http://localhost/book/php/addUser.php?firstname="+firstname+"&lastname="+lastname+"&mobile="+mobile+"&email="+email+"&username="+username+"&password="+password,
			success: function(datas) {
				alert(datas);
				 $("#firstname").val("");
				 $("#lastname").val("");
				 $("#mobile").val("");
				 $("#email").val("");
				 $("#username").val("");
				 $("#password").val("");
			},
		});	
}


function addBook(){
	var authorname = $("#authornames").find('option:selected').attr('id');
	var bookname = $("#bookname").val();
	var publish = $("#publish").val();
	var category = $("#category").val();
	var subject = $("#subject").val();
	var price = $("#price").val();
	
	
	var name = document.getElementById("file").files[0].name;
  var form_data = new FormData();
  var ext = name.split('.').pop().toLowerCase();
  if(jQuery.inArray(ext, ['gif','png','jpg','jpeg','pptx','pdf']) == -1) 
  {
   alert("Invalid Image File");
  }
  var oFReader = new FileReader();
  oFReader.readAsDataURL(document.getElementById("file").files[0]);
  var f = document.getElementById("file").files[0];
  var fsize = f.size||f.fileSize;
  if(fsize > 90000000)
  {
   alert("Image File Size is very big");
  }
  else
  {
   form_data.append("file", document.getElementById('file').files[0]);
   $.ajax({
    url:"http://localhost/book/php/addBook.php?authorid="+authorname+"&bookname="+bookname+"&publish="+publish+"&category="+category+"&subject="+subject+"&price="+price,
    method:"POST",
    data: form_data,
    contentType: false,
    cache: false,
    processData: false,
    beforeSend:function(){
     $('#uploaded_image').html("<label class='text-success'>Image Uploading...</label>");
    },   
    success:function(data)
    {
		alert(data)
				$('#uploaded_image').html(data);
				$("#bookname").val("");
				$("#publish").val("");
				$("#category").val("");
				$("#subject").val("");
				$("#price").val("");
    }
   });
  }
	
	
	
	
}


function getBookList(){
		var url_string = window.location.href;
		var url = new URL(url_string);
		var final_id = url.searchParams.get("id");
	
	$.ajax({
			type:"GET",
			url:"http://localhost/book/php/getBook.php?userid="+final_id,
			success: function(datas) {
				
				var res = JSON.parse(datas);
				
				var html =``;
				
				for (var i in res) {
					var data = res[i];

					html += `<div class="card col-md-2" style="width: 18rem;">
							  <center><img class="card-img-top" style="height:75px;width:75px" src="pdf.png" alt="Card image cap"></center>
							  <div class="card-body">
								<h5 class="card-title">`+data.bookname+`</h5>
								<p class="card-text">Written By `+data.authorname+`</p>
								<p class="card-text">Published On `+data.publish+`</p>
								<p class="card-text">Category : `+data.category+`</p>
								<button  onclick="download('`+data.isdownload+`','`+data.id+`','`+data.bookname+`','`+data.authorname+`','`+data.price+`','`+data.ext+`')"  class="btn btn-primary">`+data.isdownload+` - `+data.price+` RS</a>
								</div>
							</div>`;
				}
				$("#bookdetails").html(html)
			},
		});	
}


function download(isdownload,id,bookname,authorname,price,ext){
		
		if(isdownload!='Download'){
		var url_string = window.location.href;
		var url = new URL(url_string);
		var final_id = url.searchParams.get("id");
		
		window.location.href = '/book/payment.html?id='+final_id+"&bookname="+bookname+"&authorname="+authorname+"&price="+price+"&bookid="+id;
		}else{
			window.location.href ="/book/php/upload/gokul."+ext;
		}
}

function getPayment(){
		var url_string = window.location.href;
		var url = new URL(url_string);
		var id = url.searchParams.get("id");
		var authorname = url.searchParams.get("authorname");
		var bookname = url.searchParams.get("bookname");
		var price = url.searchParams.get("price");
		var bookid = url.searchParams.get("bookid");
		
		$("#authorname").val(authorname);
		$("#bookname").val(bookname);
		$("#price").val(price);	
		
}

function pay(){
		var url_string = window.location.href;
		var url = new URL(url_string);
		var id = url.searchParams.get("id");
		var bookid = url.searchParams.get("bookid");
		
	$.ajax({
			type:"GET",
			url:"http://localhost/book/php/addPayment.php?bookid="+bookid+"&userid="+id,
			success: function(datas) {
				alert(datas);
				window.location="/book/book-details.html?id="+id;
			},
		});	
}


