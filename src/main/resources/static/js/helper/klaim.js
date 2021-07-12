$(document).ready(function() {
    $('#klaim').val('true');
});


function editKlaim(param) {
    console.log(param);
    var idKlaim = $('#idKlaimText' + param).text();
    var tglKlaim = $('#tglKlaimText' + param).text();
    var tglMulaiDinasKlaim = $('#tglMulaiDinasKlaimText' + param).text();
    var tglAkhirDinasKlaim = $('#tglMulaiDinasKlaimText' + param).text();
    var kegiatanDinasKlaim = $('#kegiatanDinasKlaimText' + param).text();
    var hotelKlaim = $('#kegiatanDinasKlaimText' + param).text();
    var biayaHotelKlaim = $('#biayaHotelKlaimText' + param).text();
    var biayaKonsumsiKlaim = $('#biayaKonsumsiKlaimText' + param).text();
    var totalKlaim = $('#totalKlaimText' + param).text();
    var notaHotelKlaim = $('#notaHotelKlaimText' + param).text();
    var notaKonsumsiKlaim = $('#notaKonsumsiKlaimText' + param).text();
    var notaTransportasiKlaim = $('#notaTransportasiKlaimText' + param).text();
    var idUser = $('#idUserText' + param).text();
    var idKota= $('#idKotaText' + param).text();
    var idTransportasi = $('#idTransportasiText' + param).text();
    

    $('.idKlaimEdit').val(idKlaim);
    $('.tglKlaimEdit').val(tglKlaim);
    $('.tglMulaiDinasKlaimEdit').val(tglMulaiDinasKlaim);
    $('.tglAkhirDinasKlaimEdit').val(tglAkhirDinasKlaim);
    $('.kegiatanDinasKlaimEdit').val(kegiatanDinasKlaim);
    $('.hotelKlaimEdit').val(hotelKlaim);
    $('.biayaHotelKlaimEdit').val(biayaHotelKlaim);
    $('.biayaKonsumsiKlaimEdit').val(biayaKonsumsiKlaim);
    $('.totalKlaimEdit').val(totalKlaim);
    
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


