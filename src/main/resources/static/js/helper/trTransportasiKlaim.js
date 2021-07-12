$(document).ready(function() {
    $('#trTransportasiKlaim').val('true');
});

//BARU SAMPAI EDIT
function editTrTransportasiKlaim(param) {
    console.log(param);
    var idTrTransportasiKlaim = $('#idTrTransportasiKlaimText' + param).text();
    var biayaTransportasi = $('#biayaTransportasiText' + param).text();
    var statusTransportasi = $('#statusTransportasiText' + param).text();
    var idTransportasi = $('#idTransportasiText' + param).text();
    

    $('.idTrTransportasiKlaimEdit').val(idTrTransportasiKlaim);
    $('.biayaTransportasiEdit').val(biayaTransportasi);
    $('.statusTransportasiEdit').val('true');
    $('.idTransportasiEdit').val(idTransportasi);
    
    // $('#edit-row-form').attr("action", "/status/edit");
    $('#editTrTransportasiKlaim').modal('toggle');
}

function removeTrTransportasiKlaim(param) {
    var idTrTransportasiKlaim = $('#idTrTransportasiKlaimText' + param).text();
    var biayaTransportasi = $('#biayaTransportasiText' + param).text();
    var idTransportasi = $('#idTransportasiText' + param).text();
    
    console.log(idTransportasi);
    $('.idTrTransportasiKlaimRemove').val(idTrTransportasiKlaim);
    $('.biayaTransportasiRemove').val(biayaTransportasi);
    $('.idTransportasiRemove').val(idTransportasi);
    $('.statusTransportasiRemove').val('false');

    $('.idTrTransportasiKlaimText').text(idTrTransportasiKlaim);
    // $('#remove-row-form').attr("action", "/status/edit");
    $('#removeTrTransportasiKlaim').modal('toggle');
}


$(document).ready(function() {
    $('#trTransportasiKlaim').val('true');
});/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


