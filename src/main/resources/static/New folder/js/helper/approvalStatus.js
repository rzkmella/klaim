$(document).ready(function() {
    $('#approvalStatus').val('true');
});


function editApprovalStatus(param) {
    console.log(param);
    var idApprovalStatus = $('#idApprovalStatusText' + param).text();
    var namaApprovalStatus = $('#namaApprovalStatusText' + param).text();
    var approvalStatus = $('#approvalStatusText' + param).text();

    $('.idApprovalStatusEdit').val(idApprovalStatus);
    $('.namaApprovalStatusEdit').val(namaApprovalStatus);
    $('.approvalStatusEdit').val('true');
    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editApprovalStatus').modal('toggle');
}

function removeApprovalStatus(param) {
    var idApprovalStatus = $('#idApprovalStatusText' + param).text();
    var namaApprovalStatus = $('#namaStatusText' + param).text();
    console.log(idApprovalStatus);
    $('.idApprovalStatusRemove').val(idApprovalStatus);
    $('.namaApprovalStatusRemove').val(namaApprovalStatus);
    $('.approvalStatusRemove').val('false');
    $('.namaApprovalStatusRemoveText').text(namaApprovalStatus);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeApprovalStatus').modal('toggle');
}


$(document).ready(function() {
    $('#approvalStatus').val('true');
});/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


