$(document).ready(function() {
    $('#transportasi').val('true');
});


function editTransportasi(param) {
    console.log(param);
    var idTransportasi = $('#idTransportasiText' + param).text();
    var namaTransportasi = $('#namaTransportasiText' + param).text();
//    var biayaTransportasi = $('#biayaTransportasiText' + param).text();
    var statusTransportasi = $('#statusTransportasiText' + param).text();

    $('.idTransportasiEdit').val(idTransportasi);
    $('.namaTransportasiEdit').val(namaTransportasi);
//    $('.biayaTransportasiEdit').val(biayaTransportasi);
    $('.statusTransportasiEdit').val('true');
    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editTransportasi').modal('toggle');
}

function removeTransportasi(param) {
    var idTransportasi = $('#idTransportasiText' + param).text();
    var namaTransportasi = $('#namaTransportasiText' + param).text();
//    var biayaTransportasi = $('#biayaTransportasiText' + param).text();
    console.log(idTransportasi);
    $('.idTransportasiRemove').val(idTransportasi);
    $('.namaTransportasiRemove').val(namaTransportasi);
//    $('.biayaTransportasiRemove').val(biayaTransportasi);
    $('.statusTransportasiRemove').val('false');
    $('.namaTransportasiRemoveText').text(namaTransportasi);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeTransportasi').modal('toggle');
}


$(document).ready(function() {
    $('#transportasi').val('true');
});/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


