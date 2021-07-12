$(document).ready(function() {
    $('#role').val('true');
});


function editRole(param) {
    console.log(param);
    var idRole = $('#idRoleText' + param).text();
    var namaRole = $('#namaRoleText' + param).text();
    var statusRole = $('#statusRoleText' + param).text();

    $('.idRoleEdit').val(idRole);
    $('.namaRoleEdit').val(namaRole);
    $('.statusRoleEdit').val('true');
    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editRole').modal('toggle');
}

function removeRole(param) {
    var idRole = $('#idRoleText' + param).text();
    var namaRole = $('#namaRoleText' + param).text();
    console.log(idRole);
    $('.idRoleRemove').val(idRole);
    $('.namaRoleRemove').val(namaRole);
    $('.statusRoleRemove').val('false');
    $('.namaRoleRemoveText').text(namaRole);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeRole').modal('toggle');
}


$(document).ready(function() {
    $('#approvalStatus').val('true');
});/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


