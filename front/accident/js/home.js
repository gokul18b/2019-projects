var criminal_id;
var caseid;

$(document).ready(function(){
		
	$("#aadhar").change(function (){
		
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_criminal/"+$(this).val(),
			success: function(data) {
				if(data.length!=0){
				var row = data[0];
				$("#firstname").val(row.firstname)
				$("#lastname").val(row.lastname)
				$("#mobile").val(row.mobile)
				criminal_id = row.id;
				}else{
					alert("Invalid user")
				}
				
			}
			});
	})	
	
	load();
});

function load(){
	viewPolice();
	viewCriminal();
	viewCase();
}

function searchHistory(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/allocate_history/"+$("#aadharno").val(),
			success: function(datas) {
				if(datas.length!=0){
					var html =``;
					for(var i=0;i<datas.length;i++){
						
						var data = datas[i];
						html+=`<tr>
								<td>`+data.date+`</td>
								<td>`+data.personname+`</td>
								<td>`+data.mobile+`</td>
								<td>`+data.vehicle+`</td>
								<td>`+data.casename+` Inspector</td>
								<td>`+data.description+` Inspector</td>
							  </tr>`;
						
					}
					$("#history_body").html(html);
					
				}else{
					alert("Invalid user")
				}
				
			}
			});
}

function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/login/"+username+"/"+password,
			success: function(data) {
				if(data==-1){
					window.location.href="/accident/police-registration.html";
				}else if(data==-2){
					alert("Invalid username or pasword")
				}else{
					window.location.href="/accident/criminals-registration.html";
				}
				
			}
			});
}

function savePolice(){
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var department = $("#department").val();
	var profession = $("#profession").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var address = $("#address").val();
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_police/"+firstname+"/"+lastname+"/"+department+"/"+profession+"/"+username+"/"+password+"/"+address,
			success: function(data) {
				alert(data);
				$("#firstname").val("");
				$("#lastname").val("");
				$("#department").val("");
				$("#profession").val("");
				$("#username").val("");
				$("#password").val("");
				$("#address").val("");
				
				load();
				
			}
			});
}

function viewPolice(){
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/view_police",
			success: function(datas) {
				var html =``;
				for(var i=0;i<datas.length;i++){
						
						var data = datas[i];
						
						html+=`<tr>
								<td>`+data.firstname+`</td>
								<td>`+data.lastname+`</td>
								<td>`+data.department+`</td>
								<td>`+data.profession+`</td>
							  </tr>`;
						
					}
					$("#policebody").html(html);
			}
			});
}

function saveCriminal(){
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var mobile = $("#mobile").val();
	var aadhar = $("#aadhars").val();
	var address = $("#address").val();
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_criminal/"+firstname+"/"+lastname+"/"+mobile+"/"+aadhar+"/"+address,
			success: function(data) {
				alert(data);
				$("#firstname").val("");
				$("#lastname").val("");
				$("#mobile").val("");
				$("#aadhars").val("");
				
				$("#address").val("");
				
				load();
				
			}
			});
}

function viewCriminal(){
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/view_criminal",
			success: function(datas) {
				var html =``;
				for(var i=0;i<datas.length;i++){
						
						var data = datas[i];
						html+=`<tr>
								<td>`+data.firstname+`</td>
								<td>`+data.lastname+`</td>
								<td>`+data.mobile+`</td>
								<td>`+data.aadhar+`</td>
							  </tr>`;
						
					}
					$("#criminal_body").html(html);
			}
			});
}

function saveCase(){
	var casename = $("#casename").val();
	var description = $("#description").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_case/"+casename+"/"+description,
			success: function(data) {
				alert(data);
				$("#casename").val("");
				$("#description").val("");
			
				
				load();
				
			}
			});
}


function viewCase(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/view_case",
			success: function(datas) {
				var html =``;
				for(var i=0;i<datas.length;i++){
						
						var data = datas[i];
						html+=`<option id=`+data.id+`>`+data.casename+`</option>`;
						
					}
					$("#casename").html(html);
			}
			});
}


function saveAllocate(){
	
	var aadhar = $("#aadhar").val();
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var mobile = $("#mobile").val();
	var pname = $("#pname").val();
	var vno = $("#vno").val();
	var pmno = $("#pmno").val();
	var address = $("#address").val();
	var description = $("#description").val();
	caseid = $("#casename").children(":selected").attr("id");
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/allocate_case/"+criminal_id+"/"+caseid+"/"+pname+"/"+vno+"/"+mobile+"/"+address+"/"+description,
			success: function(data) {
				alert(data);
				$("#aadhar").val("");
				$("#firstname").val("");
				$("#lastname").val("");
				$("#mobile").val("");
				$("#pname").val("");
				$("#vno").val("");
				$("#pmno").val("");
				$("#address").val("");
				$("#description").val("");
				
				load();
				
			}
			});
}