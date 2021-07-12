$(document).ready(function() {
    $('#kota').val('true');
});


function editKota(param) {
    console.log(param);
    var idKota = $('#idKotaText' + param).text();
    var namaKota = $('#namaKotaText' + param).text();
    var idProvinsi = $('#idProvinsiText' + param).text();
    

    $('.idKotaEdit').val(idKota);
    $('.namaKotaEdit').val(namaKota);
    $('.idProvinsiEdit').val(idProvinsi);
    
    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editKota').modal('toggle');
}

function removeKota(param) {
    var idKota = $('#idKotaText' + param).text();
    var namaKota = $('#namaKotaText' + param).text();
    var idProvinsi = $('#idProvinsiText' + param).text();
    console.log(idProvinsi);
    $('.idKotaRemove').val(idKota);
    $('.namaKotaRemove').val(namaKota);
    $('.idProvinsiRemove').val(idProvinsi);

    $('.namaKotaRemoveText').text(namaKota);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeKota').modal('toggle');
}


$(document).ready(function() {
    $('#kota').val('true');
});/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


