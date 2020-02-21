var patient_id;
var final_id;

$(document).ready(function(){
	
	
	
});

function login(){
	
	var username = $("#username").val();
	var password = $("#password").val();

	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/login/"+username+"/"+password,
			success: function(datas) {
				if((username=='admin') && (password=='admin')){
					window.location.href="/appointment/patient-registration.html";
				}else{
					if(datas==0){
						alert("Invalid username or password");
					}else{
						window.location.href="/appointment/appointment-details.html?id="+datas;
					}
				}
			},
		});	
	
}

