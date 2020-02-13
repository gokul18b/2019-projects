$(document).ready(function(){
});
function login(){
	var mobile=$("input[name=mobile]").val().trim();
	var password=$("input[name=password]").val().trim();
	$.ajax({
				type:"POST",
				url:"/api/login",
				data:{mobile:mobile,password:password},
				success: function(datas) {
					if(datas.length!=0){
						var data = datas[0];
						if(data['FLAG']==1){
							window.location.href="/admin";
						}else{
							window.location.href="/user?id="+data['id'];
						}
					}else{
						swal("Required Fields!", "Invalid username or password", "warning");
					}
					
				},
	});
}

function AddUser(){
	var firstname=$("input[name=firstname]").val().trim();	
	var lastname=$("input[name=lastname]").val().trim();
	var mobilenumber=$("input[name=mobilenumber]").val().trim();
	var email=$("input[name=email]").val().trim();
	var age=$("input[name=age]").val().trim();
	var gender=$("input[name=gender]").val().trim();
	var pass=$("input[name=pass]").val().trim();
	
	var confirmpassword=$("input[name=confirmpassword]").val().trim();
	
	var address=$("textarea[name=address]").val().trim();
	
	alert("/api/addUser/"+firstname+"/"+lastname+"/"+mobilenumber+"/"+email+"/"+age+"/"+gender+"/"+confirmpassword+"/"+address)
	if(firstname.length==0 || mobilenumber.length==0 || confirmpassword.length==0 || confirmpassword.length==0 || address.length==0){
		swal("Required Fields!", "Should Enter All Required Fields", "warning");
	}else{
		if(pass==confirmpassword){
			$.ajax({
				type:"POST",
				url:"http://localhost:8080/api/addUser/"+firstname+"/"+lastname+"/"+mobilenumber+"/"+email+"/"+age+"/"+gender+"/"+confirmpassword+"/"+address,
				success: function(datas) {
					
					swal("Success!", "User has been Added.", "success");
					$("input[name=firstname]").val("");
					$("input[name=lastname]").val("");
					$("input[name=mobilenumber]").val("");
					$("input[name=email]").val("");
					$("input[name=age]").val("");
					$("input[name=gender]").val("");
					$("input[name=pass]").val("");
					$("input[name=confirmpassword]").val("");
					$("textarea[name=address]").val("");
					
					refresh();
				},
			});
		}else{
			swal("Required Fields!", "Password does not match", "warning");
		}
	}
}

