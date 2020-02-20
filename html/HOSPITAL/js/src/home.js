var patient_id;
var final_id;
$(document).ready(function(){
	var url_string = window.location.href;
	var url = new URL(url_string);
	final_id = url.searchParams.get("id");
	
	
	$("#searchmobile").change(function(){
		patient_id='';
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_patient/"+$("#searchmobile").val(),
			success: function(datas) {
				
				patient_id=datas.id;
				$("#firstname").val(datas.firstname);
				$("#lastname").val(datas.lastname);
			},
		});	
	}); 
	
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_doctorlist",
			success: function(datas) {
				
				var html = ``;
				for (var i in datas) {
					var data = datas[i];

					html += `<option id=`+data.id+`>`+data.name+`</option>`;
				}
				$("#doctornameList").html(html)
				//var doctor_id=$("#doctornameList").children(":selected").attr("id");
				
			},
		});	
	
	
});
function search(){
	var date = $("#add_date").val();
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_appointment_details_doctor/"+final_id+"/"+date,
			success: function(datas) {
				var html = ``;
				for (var i in datas) {
					var data = datas[i];

					html += ` <tr>
								<th scope="row">`+(++i)+`</th>
									<td>`+data.firstname+`</td>
									<td>`+data.lastname+`</td>
									<td>`+data.mobile+`</td>
									<td>`+data.appointmentdate+`</td>
									<td>`+data.tokenno+`</td>
									`;
				}
				$("#app_body").html(html)
			},
		});	
}
function patientregister(){
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var attendar = $("#attendarname").val();
	var emergency = $("#emergencyno").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_patient/"+firstname+"/"+lastname+"/"+mobile+"/"+email+"/"+attendar+"/"+emergency,
			success: function(datas) {
				alert(datas);
				$("#firstname").val("");
				$("#lastname").val("");
				$("#mobile").val("");
				$("#email").val("");
				$("#attendarname").val("");
				$("#emergencyno").val("");
				
			},
		});	
	
}

function bookappointment(){
	var doctor_id=$("#doctornameList").children(":selected").attr("id");
	var appointment_date = $("#appointment_date").val();
	var amount = $("#amount").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/book_appointment/"+doctor_id+"/"+patient_id+"/"+amount+"/"+appointment_date,
			success: function(datas) {
				alert(datas);
				$("#searchmobile").val("");
				$("#firstname").val("");
				$("#lastname").val("");
				$("#amount").val("");
				$("#appointment_date").val("");
				
				
			},
		});	
	
}

function adddoctor(){
	var doctorname = $("#doctorname").val();
	var qualification = $("#qualification").val();
	var speciality = $("#speciality").val();
	var username = $("#username").val();
	var password = $("#password").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/adddoctor/"+doctorname+"/"+qualification+"/"+speciality+"/"+username+"/"+password,
			success: function(datas) {
				alert(datas);
				$("#doctorname").val("");
				$("#qualification").val("");
				$("#speciality").val("");
				$("#username").val("");
				$("#password").val("");
				
				
			},
		});	
}



function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/login/"+username+"/"+password,
			success: function(datas) {
				if(datas){
					 window.location="/mobile/customer-registration.html";
				}else{
				alert('Invalid username and password')	
				}
			},
		});	
}

function addCustomer(){

	var name = $("#name").val();
	var mobile = $("#mobile").val();
	var address = $("#address").val();
	var gender = $("#gender").val();
	var email = $("#email").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_customer/"+name+"/"+mobile+"/"+address+"/"+gender+"/"+email,
			success: function(datas) {
				alert(datas);
				$("#name").val("");
				$("#mobile").val("");
				$("#address").val("");
				$("#gender").val("");
				$("#email").val("");
				load();
			},
		});	
}

function getCustomer(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_customer",
			success: function(datas) {
				var html = ``;
				for (var i in datas) {
					var data = datas[i];

					html += ` <tr>
								<th scope="row">`+(++i)+`</th>
									<td>`+data.name+`</td>
									<td>`+data.mobile+`</td>
									<td>`+data.address+`</td>
									<td>`+data.gender+`</td>
									<td>`+data.email+`</td>
									`;
				}
				$("#table_body").html(html)
			},
		});	
}

function addEmployee(){
	
	var name = $("#name").val();
	var mobile = $("#mobile").val();
	var address = $("#address").val();
	var gender = $("#gender").val();
	var salary = $("#salary").val();
	var age = $("#age").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_employee/"+name+"/"+mobile+"/"+address+"/"+gender+"/"+salary+"/"+age,
			success: function(datas) {
				alert(datas);
				$("#name").val("");
				$("#mobile").val("");
				$("#address").val("");
				$("#gender").val("");
				$("#salary").val("");
				$("#age").val("");
				load();
			},
		});	
}

function getEmployee(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_employee",
			success: function(datas) {
				var html = ``;
				for (var i in datas) {
					var data = datas[i];

					html += ` <tr>
								<th scope="row">`+(++i)+`</th>
									<td>`+data.name+`</td>
									<td>`+data.mobile+`</td>
									<td>`+data.gender+`</td>
									<td>`+data.salary+`</td>
									<td>`+data.age+`</td>
									`;
				}
				$("#table_bodye").html(html)
			},
		});	
}

function addProduct(){
	var company = $("#company").val();
	var model = $("#model").val();
	var price = $("#price").val();
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_product/"+company+"/"+model+"/"+price,
			success: function(datas) {
				alert(datas);
				$("#company").val("");
				$("#model").val("");
				$("#price").val("");
				
				load();
			},
		});	
}

function getProduct(){
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_product",
			success: function(datas) {
				var html = ``;
				for (var i in datas) {
					var data = datas[i];
					html+=`<option id=`+data.id+`>`+data.company+` - `+data.model+`</option>`;
					
				}
				$("#purchase_product").html(html)
				$("#sales_product").html(html)
				
			},
		});	
}


function addPurchase(){
	var product_id = $("#purchase_product").find('option:selected').attr('id');
	var quantity = $("#quantity").val();
	
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_purchase/"+product_id+"/"+quantity,
			success: function(datas) {
				alert(datas);
				$("#quantity").val("");
			
				
				load();
			},
		});	
}


function addSales(){
	if(customer_id!=''){
	
	var product_id = $("#sales_product").find('option:selected').attr('id');
	var quantity = $("#quantity").val();
	
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_sales/"+customer_id+"/"+product_id+"/"+quantity,
			success: function(datas) {
				alert(datas);
				$("#quantity").val("");
			
				$("#sal_mobile").val("");
				load();
			},
		});	
	}else{
		alert('invalid customer number')
	}
}


function getStock(){
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_stock",
			success: function(datas) {
				var html = ``;
				for (var i in datas) {
					var data = datas[i];
					html+=`<tr>
							  <th scope="row">`+(++i)+`</th>
							  <td>`+data.company_name+`</td>
							  <td>`+data.quantity+`</td>
							  
							</tr>`;
					
				}
				$("#stockbody").html(html)
				
				
			},
		});	
}

function getBill(){
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_billing",
			success: function(datas) {
				var html = ``;
				for (var i in datas) {
					var data = datas[i];
					html+=`<tr>
					  <th scope="row">`+(++i)+`</th>
					  <td>`+data.customer_name+`</td>
					  <td>`+data.mobile+`</td>
					  <td>`+data.company+`</td>
					  <td>`+data.model+`</td>
					  <td>`+data.quantity+`</td>
					  <td>`+(data.price*data.quantity)+`</td>
					</tr>`;
					
				}
				$("#billbody").html(html)
				
				
			},
		});	
}
