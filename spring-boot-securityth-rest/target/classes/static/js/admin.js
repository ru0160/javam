$(document).ready(function()
{
    $.ajax({
        url: "/admin/users",
        type: "GET",
        dataType:"json",
        success: function (response)
        {
            var trHTML = '';
            $.each(response, function (key,value) {
                trHTML +=
                    '<tr><td>' + value.id +
                    '</td><td>' + value.name +
                    '</td><td>' + value.password +
                     for(var i = 0; i < value.roles.length; i++){
                         '</td><td>' + value.roles[i].name
                     } +
                    '</td><td>' + "Edit" +
                    '</td><td>' + "Delete" +
                    '</td></tr>';
            });
            $('#userstable').append(trHTML);
        }
    });
});