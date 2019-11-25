
$(document).ready(function()
{
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
                    </tr>"
                );
            });
        }

    });
    $("#submitEdit").on('click', function () {
        editUser();
    })

    $("#submitEdit").on('click', function () {
        addUser();
    })

});

function edt(id) {
    $.getJSON("/admin/getUserById/" + id, function(data) {
        $("#disabledTextInput").val(data.id);
        $("#nameUser").val(data.name);
        $("#password").val(data.password);
        var role = "";
        $.each(data.roles, function (key,value){
            $("#role").val(value.name);
        });
    });


}
function editUser(){
    var user = {
        "id" : $('#disabledTextInput').val(),
        "name" : $('#nameUser').val(),
        "password" : $('#password').val(),

    }

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "/admin/edit/?role=" + $('#role').val(),
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
    var user = {
        "name" : $('#userName').val(),
        "password" : $('#userPassword').val(),

    }

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "/admin/createuser/?role=" + $('#role').val(),
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






