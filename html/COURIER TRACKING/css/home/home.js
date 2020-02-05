// Material Design example
$(document).ready(function () {
	
    update()
});

function update() {
    showCustomerList();
    viewCourier();
}
function addCustomer() {
    var name = $("#name1").val();
    var mobile = $("#mobile1").val();
    var address = $("#address1").val();

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/addCustomer/'+name+'/'+mobile+'/'+address,
        data:{
            'name': name,
            'mobile': mobile,
            'address': address
        },
    }).done(function (datas) {
        alert(datas);
        $("#name1").val("");
        $("#mobile1").val("");
        $("#address1").val("");

        update();
    });
}

function showCustomerList() {

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/viewCustomer'

    }).done(function (datas) {

        var html = ``;
        for (var i in datas) {
            var data = datas[i];

            html += ` <tr>
                        <th scope="row">`+(++i)+`</th>
                            <td>`+data.name+`</td>
                            <td>`+data.mobile+`</td>
                            <td>`+data.address+`</td>
                        </tr>`;
        }
        $("#customerbody").html(html)
    });
}


function addCourier() {
    var name = $("#name3").val();
    var mobile = $("#mobile3").val();
    var address = $("#address3").val();
    var sendlocation = $("#send3").val();


    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/addCourier/'+name+'/'+mobile+'/'+sendlocation+'/'+address,
        data: {
            name: name,
            mobile: mobile,
            sendlocation: sendlocation,
            fulladdress:address
        }
    }).done(function (datas) {
        alert(datas);
        $("#name3").val("");
        $("#mobile3").val("");
        $("#address3").val("");
        $("#send3").val("");

        update();
    });
}

function viewCourier() {

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/api/viewCourier',

    }).done(function (datas) {

        var html = ``;
        for (var i in datas) {
            var data = datas[i];

            html += ` <tr>
                        <th scope="row">`+data.id+`</th>
                            <td>`+data.name+`</td>
                            <td>`+data.mobile+`</td>
                            <td>`+data.address+`</td>
                            <td>`+data.sendlocation+`</td>
                            <td>`+data.currentlocation+`</td>
                        </tr>`;
        }
        $("#courierbody").html(html)
    });
}

function updateCourier() {

    var courierno = $("#courierno").val();
    var currentlocation = $("#currentlocation").val();

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/updateCourier/'+courierno+'/'+currentlocation,
        data: {
            courierno: courierno,
            currentlocation: currentlocation
        }
    }).done(function (datas) {
        alert(datas);
        $("#courierno").val("");
        $("#currentlocation").val("");


        update();
    });
}