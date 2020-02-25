var passenger_id;
var url_id;
$(document).ready(function(){
	var url_string = window.location.href;
	var url = new URL(url_string);
	url_id = url.searchParams.get("id");

$("#mobile").change(function(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_passenger/"+$(this).val(),
			success: function(datas) {
					
					if(datas.length==0){
						alert("Invalid user")
					}else{
						passenger_id = datas[0].id;
						
						$("#firstname").val(datas[0].firstname)
						$("#lastname").val(datas[0].lastname)
					}
			}
			});
})
	load();
});

function load(){
	getPass();
	getGeneral();
}
function getGeneral(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_general/"+url_id,
			success: function(datas) {
				var html =``;
				for(var i=0;i<datas.length;i++){
						
						var data = datas[i];
						html+=`<tr>
								<td>`+data.fromLocation+`</td>
								<td>`+data.toLocation+`</td>
													
								<td>`+data.amount+`</td>						
												
							  </tr>`;
						
					}
					$("#genbody").html(html);
			}
			});
}

function getPass(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_pass/"+url_id,
			success: function(datas) {
				var html =``;
				for(var i=0;i<datas.length;i++){
						
						var data = datas[i];
						html+=`<tr>
								<td>`+data.fromLocation+`</td>
								<td>`+data.toLocation+`</td>
								<td>`+data.nextRenewal+`</td>						
								<td>`+data.amount+`</td>						
												
							  </tr>`;
						
					}
					$("#passbody").html(html);
			}
			});
}
function login(){
	
	var username = $("#username").val();
	var password = $("#password").val();
	//alert("http://localhost:8080/api/login/"+username+"/"+password)
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/login/"+username+"/"+password,
			success: function(data) {
					
					if(data.flag=='A'){
						window.location.href="/train/passenger-registration.html";
					}else if(data.flag=='P'){
						window.location.href="/train/pass-registration.html?id="+data.id;
					}else{
						alert('Invalid username or password')
					}
			}
			});
}

function addPassenger(){
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var idproof = $("#idproof").val();
	var address = $("#address").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_passenger/"+firstname+"/"+lastname+"/"+mobile+"/"+email+"/"+username+"/"+password+"/"+idproof+"/"+address,
			success: function(data) {
				alert(data);
				$("#firstname").val("");
				$("#lastname").val("");
				$("#mobile").val("");
				$("#email").val("");
				$("#username").val("");
				$("#password").val("");
				$("#idproof").val("");
				$("#address").val("");
				
				load();
			}
			});
}

function savePass(){
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var from = $("#from").val();
	var to = $("#to").val();
	var next = $("#next").val();
	var amount = $("#amount").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_pass/"+passenger_id+"/"+from+"/"+to+"/"+next+"/"+amount,
			success: function(data) {
				alert(data);
				$("#firstname").val("");
				$("#lastname").val("");
				$("#next").val("");
				$("#amount").val("");
				
				
			}
			});
}

function saveGeneral(){
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var from = $("#from").val();
	var to = $("#to").val();
	var amount = $("#amount").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_general/"+passenger_id+"/"+from+"/"+to+"/"+amount,
			success: function(data) {
				alert(data);
				$("#firstname").val("");
				$("#lastname").val("");
				$("#amount").val("");
				
				load();
			}
	});
}

function addTrain(){
	var trainname = $("#trainname").val();
	var trainnumber = $("#trainnumber").val();
	var from = $("#from").val();
	var to = $("#to").val();
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_train/"+trainnumber+"/"+trainname+"/"+from+"/"+to,
			success: function(data) {
				alert(data);
				$("#trainname").val("");
				$("#trainnumber").val("");
				
			}
	});
}

function locationUpdate(){
	
	var trainno = $("#trainno").val();
	var trainname = $("#trainname").val();
	var last = $("#last").val();
	
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/location_update/"+trainno+"/"+last,
			success: function(data) {
				alert(data);
				$("#trainno").val("");
				$("#trainname").val("");
				
			}
	});
}


function searchtrain(){
	var trainno = $("#trainno").val();
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/find_location/"+trainno,
			success: function(datas) {
				
				var html = `Train name : `+datas[0].trainname+` is located at : `+datas[0].lastlocation;
				
				$("#loc").html(html);
				
				
			}
			});
}


function gen(){
	window.location.href="/train/general-ticket.html?id="+url_id;
}

function pass(){
	window.location.href="/train/pass-registration.html?id="+url_id;
}

function track(){
	window.location.href="/train/search-train.html?id="+url_id;
}

