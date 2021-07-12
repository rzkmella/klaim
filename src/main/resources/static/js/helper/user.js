$(document).ready(function() {
    $('#user').val('true');
});


function editUser(param) {
    console.log(param);
    var idUser = $('#idUserText' + param).text();
    var namaLengkapUser = $('#namaLengkapUserText' + param).text();
    var emailUser = $('#emailUserText' + param).text();
    var passwordUser = $('#passwordUserText' + param).text();
    var noRekeningUser = $('#noRekeningUserText' + param).text();
    var statusUser = $('#statusUserText' + param).text();
    var idRole = $('#idRoleText' + param).text();

    $('.idUserEdit').val(idUser);
    $('.namaLengkapUserEdit').val(namaLengkapUser);
    $('.emailUserEdit').val(emailUser);
    $('.passwordUserEdit').val(passwordUser);
    $('.noRekeningUserEdit').val(noRekeningUser);
    $('.statusUserEdit').val('true');
    $('.idRoleEdit').val(idRole);
    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editUser').modal('toggle');
}

function removeUser(param) {
    var idUser = $('#idUserText' + param).text();
    var namaLengkapUser = $('#namaLengkapUserText' + param).text();
    var emailUser = $('#emailUserText' + param).text();
    var passwordUser = $('#passwordUserText' + param).text();
    var noRekeningUser = $('#noRekeningUserText' + param).text();
    var idRole = $('#idRoleText' + param).text();
    
    console.log(idRole);
    $('.idUserRemove').val(idUser);
    $('.idRoleRemove').val(idRole);
    $('.namaLengkapUserRemove').val(namaLengkapUser);
    $('.emailUserRemove').val(emailUser);
    $('.passwordUserRemove').val(passwordUser);
    $('.noRekeningUserRemove').val(noRekeningUser);
    $('.statusUserRemove').val('false');
    $('.namaLengkapUserRemoveText').text(namaLengkapUser);
    
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeUser').modal('toggle');
}


$(document).ready(function() {
    $('#user').val('true');
});/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


