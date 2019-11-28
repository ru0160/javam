
$(document).ready(function()
{

    $.getJSON("/admin/allRoles", function (data) {
        var select = document.querySelector('select');
        var allRolles = new Array();
        $.each(data, function (key,value) {
            allRolles[key] = value.name;
        })
        var myDiv = document.getElementById("selectAddUser");

        var selectList = document.createElement("select");
        selectList.setAttribute("id", "mySelect");
        myDiv.appendChild(selectList);
        for (var i = 0; i < allRolles.length; i++) {
            var option = document.createElement("option");
            option.setAttribute("value", allRolles[i]);
            option.text = allRolles[i];
            selectList.appendChild(option);
        }
    });
    $.ajax({
        url: "/admin/users",
        type: "GET",
        dataType:"json",
        success: function (response) {
            var trHTML = "";
            $.each(response, function (key,value) {
                var userRole = "";
                $.each(value.roles, function (key,value){
                    userRole = value.name;
                });
                $('#userstable').append(
                    "<tr> \
                    <th class=\"font-weight-normal\">" + value.id + "</th> \
                            <th>" + value.name + "</th>> \
                            <th>" + value.password + "</th> \
                            <th>" + userRole + "</th> \
                            <th> <button onclick='edt("+ value.id +")' type=\"button\" class=\"btn btn-primary\" \
                            data-toggle=\"modal\" data-target=\"#edituser\" id='usrBtn' >Edit</button> </th> \
                            <th> <button onclick='del("+ value.id +")' class=\"btn btn-danger\">Delete</button> </th> \
                    </tr>"
                );
            });
        }

    });
    $("#submitEdit").on('click', function () {
        editUser();
    })

    $("#AddUserBtn").on('click', function () {
        addUser();
    })

});

function edt(id) {
    var select = document.querySelector('select');
    $.getJSON("/admin/allRoles", function (data) {
        var allRolles = new Array();
        $.each(data, function (key,value) {
            allRolles[key] = value.name;
        })
        $.getJSON("/admin/getUserById/" + id, function(data) {
            $("#disabledTextInput").val(data.id);
            $("#nameUser").val(data.name);
            $("#password").val(data.password);
            var role = "";
            $.each(data.roles, function (key,value){
                role = value.name;
            });
            for(var i = 0; i < allRolles.length; i++ ){
                select.add(new Option(allRolles[i]));
                if(select.options[i].value == role){
                    select[i].selected = true;
                }
            }
        });
    });
}

function del(id) {
    $.ajax({
        type : "DELETE",
        url : "/admin/delete/?id=" + id,
        success: function(data){
            $(location).attr('href',"/admin/listUsers");
        },
        error: function (e) {
            console.log(e);
        }
    });
}

function editUser(){
    var selind = document.getElementById("userRole").options.selectedIndex;
    var val= document.getElementById("userRole").options[selind].value;
    var roles = [{
        "name" : val,
    }]
    var user = {
        "id" : $('#disabledTextInput').val(),
        "name" : $('#nameUser').val(),
        "password" : $('#password').val(),
        "roles" : roles

    }

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "/admin/edit/",
        datatype: 'application/json',
        data: JSON.stringify(user),
        success: function(data){
            $(location).attr('href',"/admin/listUsers");
        },
        error: function(error){
            alert(error);
        }
    }).done()
}

function addUser() {
    var selind = document.getElementById("mySelect").options.selectedIndex;
    var val= document.getElementById("mySelect").options[selind].value;
    var role = [{
        "name" : val,
    }]
    var user = {
        "name" : $('#userName').val(),
        "password" : $('#userPassword').val(),
        "roles" : role,
    }


    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "/admin/createuser/",
        datatype: 'application/json',
        data: JSON.stringify(user),
        success: function(data){
            $(location).attr('href',"/admin/listUsers");
        },
        error: function(error){
            alert(error);
        }
    }).done()
}

function selectAllRoles() {
    $.getJSON("/admin/allRoles", function (data) {
        var allRolles = new Array();
        $.each(data, function (key,value) {
            allRolles[key] = value.name;
        })
        return allRolles;
    })
}






