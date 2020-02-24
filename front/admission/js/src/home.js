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
				var html1=``;
				for(var row in data){
					
					html +=`<tr>
								<td onclick="showAppPendingStudents('`+data[row].departmentname+`','`+data[row].classname+`')" style="cursor:pointer">`+data[row].departmentname+` `+data[row].classname+`</td>
								</tr>
							  <tr>`;
							  
					html1 +=`<tr>
								<td onclick="showAppAcceptedStudents('`+data[row].departmentname+`','`+data[row].classname+`')" style="cursor:pointer">`+data[row].departmentname+` `+data[row].classname+`</td>
								</tr>
							  <tr>`;
				}
				$("#classDepartment").html(html);
				$("#classDepartment1").html(html1);
			}
			});
}

function showAppAcceptedStudents(deptname,classname){
				
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/show_accepted_student/"+deptname+"/"+classname,
			success: function(data) {
				
				
				var html1=``;
				for(var row in data){
					var r = data[row];
					
					
					html1 +=`<tr>
								<td>`+r.firstname+`</td>
								<td>`+r.ten+`</td>
								<td>`+r.twelve+`</td>
								<td>`+r.mobile+`</td>
								</tr>
							  <tr>`;
				}
				
				$("#student_details1").html(html1);
			}
			});
}

function showAppPendingStudents(deptname,classname){
				
	$.ajax({
			type:"GET",
			url:"http://localhost:8080/api/show_pending_student/"+deptname+"/"+classname,
			success: function(data) {
				
				var html=``;
				
				for(var row in data){
					var r = data[row];
					html +=`<tr>
							<td>`+r.firstname+`</td>
							<td>`+r.ten+`</td>
							<td>`+r.twelve+`</td>
							<td><button onclick="approve('`+r.id+`','`+r.department+`','`+r.classname+`')" type="button" class="btn btn-success">Approve</button></td>
							<td><button onclick="reject('`+r.id+`','`+r.department+`','`+r.classname+`')" type="button" class="btn btn-danger">Reject</button></td>
						 </tr>`;
					
					
				}
				$("#studentdetails").html(html);
				
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


function logout(){
	
	window.location.href='/car/index.html';
}




