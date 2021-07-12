$(document).ready(function() {
    $('#provinsi').val('true');
});


function editProvinsi(param) {
    console.log(param);
    var idProvinsi = $('#idProvinsiText' + param).text();
    var namaProvinsi = $('#namaProvinsiText' + param).text();
    

    $('.idProvinsiEdit').val(idProvinsi);
    $('.namaProvinsiEdit').val(namaProvinsi);
    
    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editProvinsi').modal('toggle');
}

function removeProvinsi(param) {
    var idProvinsi = $('#idProvinsiText' + param).text();
    var namaProvinsi = $('#namaProvinsiText' + param).text();
    console.log(idProvinsi);
    $('.idProvinsiRemove').val(idProvinsi);
    $('.namaProvinsiRemove').val(namaProvinsi);
    
    $('.namaProvinsiRemoveText').text(namaProvinsi);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeProvinsi').modal('toggle');
}


$(document).ready(function() {
    $('#provinsi').val('true');
});/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


