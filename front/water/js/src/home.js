var customer_id;
$(document).ready(function(){
	
	getProduct();
	getStock();
	getBill();
	$("#sal_mobile").change(function(){
		customer_id='';
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_customer/"+$("#sal_mobile").val(),
			success: function(datas) {
				
				customer_id=datas[0][0];
			},
		});	
	}); 
	
	$("#searchmobile").change(function(){
		customer_id='';
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_customer/"+$("#searchmobile").val(),
			success: function(datas) {
				customer_id=datas[0][0];
				
				$("#name").val(datas[0][1])
			},
		});	
	}); 
	
});

function load(){
	getCustomer();
	getEmployee();
	getProduct();
	getStock();
	getBill();
}

function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/login/"+username+"/"+password,
			success: function(datas) {
				
				if(datas){
					 window.location="/water/customer-registration.html";
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

function addWaterType(){
	var companyname = $("#companyname").val();
	var type = $("#type").val();
	var liter = $("#liter").val();
	var price = $("#price").val();
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_water_types/"+companyname+"/"+type+"/"+liter+"/"+price,
			success: function(datas) {
				alert(datas);
				$("#companyname").val("");
				$("#type").val("");
				$("#liter").val("");
				$("#price").val("");
			},
		});	
}



function getProduct(){
	
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_water",
			success: function(datas) {
				var html = ``;
				for (var i in datas) {
					var data = datas[i];
					html+=`<option id=`+data.id+`>`+data.company+` - `+data.watertype+` - `+data.liter+`</option>`;
					
				}
				$("#watertype").html(html)
				$("#saleswater").html(html)
				
			},
		});	
}


function addPurchase(){
	var product_id = $("#watertype").find('option:selected').attr('id');
	var quantity = $("#quantity").val();
	var price = $("#price").val();
	
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_purchase/"+product_id+"/"+quantity+"/"+price,
			success: function(datas) {
				alert(datas);
				$("#quantity").val("");
				$("#price").val("");
				
				
			},
		});	
}




function addSales(){
	
	if(customer_id!=''){
	
	var product_id = $("#saleswater").find('option:selected').attr('id');
	var quantity = $("#quantity").val();
	var price = $("#price").val();
	
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_sales/"+customer_id+"/"+product_id+"/"+quantity+"/"+price,
			success: function(datas) {
				alert(datas);
				$("#searchmobile").val("");
				$("#name").val("");
				$("#quantity").val("");
				$("#price").val("");
				
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
								<td>`+data.company_name+`</td>
								<td>`+data.watertype+`</td>
								<td>`+data.liter+`</td>						
								<td>`+data.quantity+`</td>						
							  </tr>		`;
					
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
					html+=` <tr>
								<td>`+data.customer_name+`</td>
								<td>`+data.mobile+`</td>
								<td>`+data.company+`</td>
								<td>`+data.watertype+`</td>						
								<td>`+data.quantity+`</td>						
								<td>`+data.price+`</td>						
							  </tr>	`;
					
				}
				$("#bill_body").html(html)
				
				
			},
		});	
}
