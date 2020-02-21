var final_id;

$(document).ready(function(){
	
	getDepartment();
	getClass();
	getDepartmentClass();
});

function studentregistration(){
	
	var firstname = $("#firstname").val();
	var lastname = $("#lastname").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var age = $("#age").val();
	var gender = $("#gender").val();
	var address = $("#address").val();
	var ten = $("#ten").val();
	var twelve = $("#twelve").val();
	var schoolname = $("#school").val();
	var father = $("#father").val();
	var mother = $("#mother").val();
	var department = $("#department").val();
	var classname = $("#class").val();

//alert("localhost:8080/api/student_register/"+firstname+"/"+lastname+"/"+mobile+"/"+email+"/"+age+"/"+gender+"/"+address+"/"+ten+"/"+twelve+"/"+schoolname+"/"+father+"/"+mother+"/"+department+"/"+classname)	;
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/student_register/"+firstname+"/"+lastname+"/"+mobile+"/"+email+"/"+age+"/"+gender+"/"+address+"/"+ten+"/"+twelve+"/"+schoolname+"/"+father+"/"+mother+"/"+department+"/"+classname,
			success: function(data) {
				alert(data);
				$("#firstname").val("");
				$("#lastname").val("");
				$("#mobile").val("");
				$("#email").val("");
				$("#age").val("");
				$("#address").val("");
				$("#ten").val("");
				$("#twelve").val("");
				$("#school").val("");
				$("#father").val("");
				$("#mother").val("");
				
				
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
				
				if(data){
					window.location.href="/admission/student-registration.html"
				}else{
					alert('Invalid username or password')
				}
			}
			});
}


function getDepartment(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_department",
			success: function(data) {
				
				var html=``;
				for(var row in data){
					
					html +=`<option>`+data[row].department_name+`</option>`;
				}
				$("#department").html(html);
			}
			});
}

function getDepartmentClass(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_department_class",
			success: function(data) {
				showAppPendingStudents(data[0].departmentname,data[0].classname);
				var html=``;
				for(var row in data){
					
					html +=`<tr>
								<td onclick="showAppPendingStudents('`+data[row].departmentname+`','`+data[row].classname+`')" style="cursor:pointer">`+data[row].departmentname+` `+data[row].classname+`</td>
								</tr>
							  <tr>`;
				}
				$("#classDepartment").html(html);
			}
			});
}

function showAppPendingStudents(deptname,classname){
				
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/show_pending_student/"+deptname+"/"+classname,
			success: function(data) {
				
				var html=``;
				var html1=``;
				for(var row in data){
					var r = data[row];
					html +=`<tr>
							<td>`+r.firstname+`</td>
							<td>`+r.ten+`</td>
							<td>`+r.twelve+`</td>
							<td><button onclick="approve('`+r.id+`','`+r.department+`','`+r.classname+`')" type="button" class="btn btn-success">Approve</button></td>
							<td><button onclick="reject('`+r.id+`','`+r.department+`','`+r.classname+`')" type="button" class="btn btn-danger">Reject</button></td>
						 </tr>`;
					
					html1 +=`<tr>
								<td>`+r.firstname+`</td>
								<td>`+r.ten+`</td>
								<td>`+r.twelve+`</td>
								<td>`+r.mobile+`</td>
								</tr>
							  <tr>`;
				}
				$("#studentdetails").html(html);
				$("#student_details1").html(html1);
			}
			});
}

function approve(id,department,classname){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/approve/"+id+"/"+department+"/"+classname,
			success: function(data) {
				alert(data);
				showAppPendingStudents(department,classname);
			}
			});
}

function reject(id,department,classname){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/reject/"+id,
			success: function(data) {
				alert(data);
				showAppPendingStudents(department,classname);
			}
			});
}

function getClass(){
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/get_class",
			success: function(data) {
				
				var html=``;
				for(var row in data){
					
					html +=`<option>`+data[row].class_name+`</option>`;
				}
				$("#class").html(html);
			}
			});
}

function addDepartment(){
	var department = $("#department").val();
	var classname = $("#classname").val();
	var seat = $("#seat").val();
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/add_department/"+department+"/"+classname+"/"+seat,
			success: function(data) {
				alert(data);
				$("#department").val("");
				$("#classname").val("");
				$("#seat").val("");
				
			}
			});
}

function getProfile(id){
	
	
	$.ajax({
			type:"POST",
			url:"http://localhost:8080/api/getProfile/"+id,
			data:{id:id},
			success: function(data) {
				setProfile(data[0]);
				
			},
			dataType: 'json',
			});
}

function setProfile(data){
					
					var profile='<div class="title">'+
                        '<a target="_blank" href="">'+data["name"]+'</a>'+
                    '</div>'+
					'<div class="desc">'+data["mobile"]+'</div>'+
                    '<div class="desc">'+data["address"]+'</div>'+
                    '<div class="desc">USER</div>';
					$('#admin_profile').html(profile);
					
	
}

function ViewBranchList(){
	
			$.ajax({
				type:"GET",
				url:"http://localhost:8080/api/viewBranch",
				success: function(datas) {
						var html='';
						var serselect='';
						for(var i=0;i<datas.length;i++){
							var data = datas[i];
							serselect=serselect+'<option value='+data['id']+'>'+data['name']+'</option>';
							
							
						}
						
						
						
						
						$("#serbranch").html(serselect);
						$("#billbranch").html(serselect);
						BillDetails();
						
						$("#billbranch").change(function(){
							BillDetails();
						});
						
						
						

						
						
						
						
					
				},
			});
		
}

function getUserDetails(){
	$.ajax({
				type:"POST",
				url:"http://localhost:8080/api/userdetails/"+final_id,
				data:{id:final_id},
				success: function(datas) {
					 var data= datas[0];
					$("input[name=sername]").val(data['name']);
					$("input[name=sermno]").val(data['mobile']);
					   //id="serbranch"  id="servehicle"  name="serno"  name="problem" name="seraddress"
					
					$("#addservice").click(function(){
						addService(data['id']);
					});
					
				},
			});
}

function addService(id){
	
	
	var mobile=$("input[name=sermno]").val().trim();
	var name=$("input[name=sername]").val().trim();
	var branch=$('#serbranch').val().trim();
	var vehicletype=$('#servehicle').val().trim();
	var serno=$("input[name=serno]").val().trim();
	var problem=$("textarea[name=serproblem]").val().trim();
	var address=$("textarea[name=seraddress]").val().trim();
	
	var vehicle='';
	if(vehicletype==1){
		vehicle='CAR';
	}else if(vehicletype==2){
		vehicle='BIKE';
	}
	
	if(name.length==0 || mobile.length==0 || branch.length==0 || vehicletype.length==0 || serno.length==0 || problem.length==0 || address.length==0){
		swal("Required Fields!", "Should Enter all required Fields!", "warning");
	}else{
		$.ajax({
				type:"POST",
				url:"http://localhost:8080/api/addService/"+mobile+"/"+name+"/"+branch+"/"+vehicle+"/"+serno+"/"+problem+"/"+address+"/"+id,
				data:{uid:id,mobile:mobile,name:name,branch:branch,vehicle:vehicle,serno:serno,problem:problem,address:address},
				success: function(datas) {
					$("input[name=sermno]").val("");
					$("input[name=sername]").val("");
					$("input[name=serno]").val("");
					$("textarea[name=serproblem]").val("");
					$("textarea[name=seraddress]").val("");
					 
					PendingService();
					DeliveredService();
				},
			});
	}
	

}
function PendingService(){
	var html='';
	$.ajax({
				type:"POST",
				url:"http://localhost:8080/api/pendingService/"+final_id,
				data:{id:final_id},
				success: function(datas) {
					for (var i=0;i<datas.length;i++){
						var data=datas[i];
					html=html+'<tr>'+
							'<td>'+data['branchname']+'</td>'+
							'<td>'+data['serno']+'</td>'+
							'<td>'+data['date']+'</td>'+
							'<td>'+data['problem']+'</td>'+
							'<td><button onclick="deleteService('+data['id']+')" type="button" class="btn btn-danger">Cancel</button></td>'+
							'</tr>';
					}
					$("#pengingtablebody").html(html);
					
				},
			});
	
}


function deleteService(id){
	
	$.ajax({
				type:"POST",
				data:{id:id},
				url:"http://localhost:8080/api/deleteService/"+id,
				success: function(datas) {
						PendingService();
				}
			});
}

function DeliveredService(){
	var html='';
	$.ajax({
				type:"POST",
				url:"http://localhost:8080/api/deliveredService/"+final_id,
				data:{id:final_id},
				success: function(datas) {
					for (var i=0;i<datas.length;i++){
						var data=datas[i];
					html=html+'<tr>'+
							'<td>'+data['branchname']+'</td>'+
							'<td>'+data['serno']+'</td>'+
							'<td>'+data['date']+'</td>'+
							'<td>'+data['problem']+'</td>'+
							'</tr>';
					}
					$("#deliveredtablebody").html(html);
					
					
				},
			});
	
}


function BillDetails(){
var html ='<tr class="header"><th >Branch</th><th >Date</th><th >Problem</th><th >No</th><th >Amount</th></tr>';
	var branch=$("#billbranch").val();
	
	var date=$("#admissiondate").val();
	var tot=0;
	$.ajax({
				type:"POST",
				data:{branch:branch,uid:final_id},
				url:"http://localhost:8080/api/userBill/"+branch+"/"+final_id,
				success: function(datas) {
					
					for(var i=0;i<datas.length;i++){
						
						var data = datas[i];
						tot= tot+data['amount'];
						
						html=html+'<tr><td>'+data['branch']+'</td><td>'+data['date']+'</td><td>'+data['problem']+'</td><td>'+data['serno']+'</td><td>'+data['amount']+'</td></tr>';
						
					}
					$("#myTable").html(html);
					$("#totalbill").html("Total	: "+tot);
					
					
				}
			});
			
			
	//viewBill
}

function logout(){
	
	window.location.href='/car/index.html';
}




