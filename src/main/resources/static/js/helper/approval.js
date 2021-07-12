$(document).ready(function() {
    $('#approval').val('true');
});


function editApproval(param) {
    console.log(param);
    var idApproval = $('#idApprovalText' + param).text();
    var idApprovalStatus = $('#idApprovalStatusText' + param).text();
    var idKlaim = $('#idKlaimText' + param).text();
    var idUser= $('#idUserText' + param).text();

    $('.idApprovalEdit').val(idApproval);
    $('.idApprovalStatusEdit').val(idApprovalStatus);
    $('.idKlaimEdit').val(idKlaim);
    $('.idUserEdit').val(idUser);
    
    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editApproval').modal('toggle');
}

//function removeApprovalStatus(param) {
//    var idApprovalStatus = $('#idApprovalStatusText' + param).text();
//    var namaApprovalStatus = $('#namaApprovalStatusText' + param).text();
//    console.log(idApprovalStatus);
//    $('.idApprovalStatusRemove').val(idApprovalStatus);
//    $('.namaApprovalStatusRemove').val(namaApprovalStatus);
//    $('.approvalStatusRemove').val('false');
//    $('.namaApprovalStatusRemoveText').text(namaApprovalStatus);
//    // $('#remove-row-form').attr("action", "/status/edit");
//    $('#removeApprovalStatus').modal('toggle');
//}


$(document).ready(function() {
    $('#approval').val('true');
});/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


