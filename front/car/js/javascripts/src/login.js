$(document).ready(function(){
});
function login(){
	var mobile=$("input[name=mobile]").val().trim();
	var password=$("input[name=password]").val().trim();
	$.ajax({
				type:"POST",
				url:"http://localhost:8080/api/login/"+mobile+"/"+password,
				data:{mobile:mobile,password:password},
				success: function(datas) {
					if(datas.length!=0){
						var data = datas[0];
						//alert(data['flag'])
						if(data['flag']==1){
							window.location.href="/car/adminhome.html";
						}else{
							window.location.href="/car/userhome.html?id="+data['id'];
						}
					}else{
						swal("Required Fields!", "Invalid username or password", "warning");
					}
					
				},
	});
}

function AddUser(){
	var name=$("input[name=username]").val().trim();	
	var lastname=$("input[name=lastname]").val().trim();	
	var mobile=$("input[name=usermobile]").val().trim();
	var email=$("input[name=email]").val().trim();
	var age=$("input[name=age]").val().trim();
	var gender=$("input[name=gender]").val().trim();
	var password=$("input[name=userpass]").val().trim();
	var cnpass=$("input[name=usercnpass]").val().trim();
	var address=$("textarea[name=useraddress]").val().trim();
	
	//alert(name+mobile+password+cnpass+address);
	if(name.length==0 || mobile.length==0 || password.length==0 || cnpass.length==0 || address.length==0){
		swal("Required Fields!", "Should Enter All Required Fields", "warning");
	}else{
		if(password==cnpass){
			$.ajax({
				type:"POST",
				url:"http://localhost:8080/api/addUser/"+name+"/"+lastname+"/"+mobile+"/"+email+"/"+age+"/"+gender+"/"+password+"/"+address,
				data:{name:name,mobile:mobile,password:password,address:address},
				success: function(datas) {
					
					swal("Success!", "User has been Added.", "success");
					$("input[name=username]").val("");
					$("input[name=lastname]").val("");
					$("input[name=email]").val("");
					$("input[name=age]").val("");
					$("input[name=gender]").val("");
					$("input[name=usermobile]").val("");
					$("input[name=userpass]").val("");
					$("input[name=usercnpass]").val("");
					$("textarea[name=useraddress]").val("");
					
					refresh();
				},
			});
		}else{
			swal("Required Fields!", "Password does not match", "warning");
		}
	}
}

