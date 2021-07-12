/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.controller;

import com.project.klaim.entity.TblApproval;
import com.project.klaim.entity.TblApprovalStatus;
import com.project.klaim.entity.TblKlaim;
import com.project.klaim.entity.TblKota;
import com.project.klaim.entity.TblProvinsi;
import com.project.klaim.entity.TblTrTransportasiKlaim;
import static com.project.klaim.entity.TblTrTransportasiKlaim_.biayaTransportasi;
import com.project.klaim.entity.TblTransportasi;
import com.project.klaim.entity.TblUser;
import com.project.klaim.service.ApprovalService;
import com.project.klaim.service.ApprovalStatusService;
import com.project.klaim.service.KlaimService;
import com.project.klaim.service.KotaService;
import com.project.klaim.service.TrTransportasiKlaimService;
import com.project.klaim.service.TransportasiService;
import com.project.klaim.service.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MELLA
 */
@Controller
@RequestMapping
public class KlaimController {

    @Autowired
    KlaimService klaimService;

    @Autowired
    UserService userService;

    @Autowired
    KotaService kotaService;

    @Autowired
    TransportasiService transportasiService;

    @Autowired
    TrTransportasiKlaimService trTransportasiKlaimService;
    
    @Autowired
    ApprovalStatusService approvalStatusService;
    
    @Autowired
    ApprovalService approvalService;

    @GetMapping("/klaim/add")
    public String getKlaim(Model model) {
        Iterable<TblKlaim> klaim = klaimService.getAll();
        model.addAttribute("klaim", klaim);
        Iterable<TblUser> user = userService.getUserActive();
        model.addAttribute("user", user);
        Iterable<TblTransportasi> transportasi = transportasiService.getTransportasiActive();
        model.addAttribute("transportasi", transportasi);
        Iterable<TblKota> kota = kotaService.getAll();
        model.addAttribute("kota", kota);
//        List<TblKlaim> manager = klaimService.getUserManager();
//        model.addAttribute("manager", manager);
        

        TblKlaim klaimCrud = new TblKlaim();
        model.addAttribute("addKlaim", klaimCrud);
//        model.addAttribute("editKota", kotaCrud);
//        model.addAttribute("removeProvinsi", provinsiCrud);

        System.out.println("ini halaman klaim");

        return "klaim/v_page_add.html";
    }

    @RequestMapping(value = "/klaim/add/insert", method = RequestMethod.POST)
    public String getKlaimInsert(
            //            @RequestParam(value = "idKlaim", required = false) Integer idKlaim,
            @RequestParam(value = "tglKlaim", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date tglKlaim,
            @RequestParam(value = "tglMulaiDinasKlaim", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date tglMulaiDinasKlaim,
            @RequestParam(value = "tglAkhirDinasKlaim", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date tglAkhirDinasKlaim,
            @RequestParam(value = "kegiatanDinasKlaim", required = false) String kegiatanDinasKlaim,
            @RequestParam(value = "hotelKlaim", required = false) String hotelKlaim,
            @RequestParam(value = "biayaHotelKlaim", required = false) Integer biayaHotelKlaim,
            @RequestParam(value = "biayaKonsumsiKlaim", required = false) Integer biayaKonsumsiKlaim,
//            @RequestParam(value = "totalTransportasi", required = false) Integer totalTransportasi,
//            @RequestParam(value = "totalKlaim", required = false) Integer totalKlaim,
            //            ini type data blob
            @RequestParam(value = "notaHotelKlaim") byte[] notaHotelKlaim,
            @RequestParam(value = "notaTransportasiKlaim") byte[] notaTransportasiKlaim,
            @RequestParam(value = "notaKonsumsiKlaim") byte[] notaKonsumsiKlaim,
            //            ini relasi 
            @RequestParam(value = "idUser", required = false) Integer idUser,
//            @RequestParam(value = "idUserManager", required = false) Integer idUserManager,
            @RequestParam(value = "idKota", required = false) Integer idKota,
            @RequestParam(value = "Mobilid", required = false) Integer idTransportasiMobil,
            @RequestParam(value = "Mobilbiaya", required = false) Integer idTransportasiMobilbiaya,
            @RequestParam(value = "Pesawatid", required = false) Integer idTransportasiPesawat,
            @RequestParam(value = "Pesawatbiaya", required = false) Integer idTransportasiPesawatbiaya,
            @RequestParam(value = "Keretaid", required = false) Integer idTransportasiKereta,
            @RequestParam(value = "Keretabiaya", required = false) Integer idTransportasiKeretabiaya,
            @RequestParam(value = "Motorid", required = false) Integer idTransportasiMotor,
            @RequestParam(value = "Motorbiaya", required = false) Integer idTransportasiMotorbiaya,
            @RequestParam(value = "idApprovalStatus", required = false) Integer idApprovalStatus
            
            
    ) {
//        System.out.println("ini id klaim" + idKlaim);
        System.out.println("ini tgl klaim" + tglKlaim);
        System.out.println("ini tgl mulai Dinas Klaim" + tglMulaiDinasKlaim);
        System.out.println("ini tgl akhir Dinas Klaim" + tglAkhirDinasKlaim);
        System.out.println("ini kegiatan Klaim" + kegiatanDinasKlaim);
        System.out.println("ini Hotel Klaim" + hotelKlaim);
        System.out.println("ini biaya Hotel Klaim" + biayaHotelKlaim);
        System.out.println("ini biaya Konsumsi Klaim" + biayaKonsumsiKlaim);
//        System.out.println("ini total transportasi Klaim" + totalTransportasi);
//        System.out.println("ini total Klaim" + totalKlaim);
        System.out.println("ini notaHotelKlaim" + notaHotelKlaim);
        System.out.println("ini notaTransportasiKlaim" + notaTransportasiKlaim);
        System.out.println("ini notaKonsumsiKlaim" + notaKonsumsiKlaim);
        System.out.println("ini idUser" + idUser);
        System.out.println("ini idKota" + idKota);
        System.out.println("ini idTransportasiMobil" + idTransportasiMobil);
        System.out.println("ini idTransportasiMobilbiaya" + idTransportasiMobilbiaya);
        System.out.println("ini idTransportasiPesawat" + idTransportasiPesawat);
        System.out.println("ini idTransportasiPesawatbiaya" + idTransportasiPesawatbiaya);
        System.out.println("ini idTransportasiKereta" + idTransportasiKereta);
        System.out.println("ini idTransportasiKeretabiaya" + idTransportasiKeretabiaya);
        System.out.println("ini idTransportasiMotor" + idTransportasiMotor);
        System.out.println("ini idTransportasiMotorbiaya" + idTransportasiMotorbiaya);

        Object idUserObject = new TblUser(3);
        Object idKotaObject = new TblKota(idKota);
        
        
        System.out.println(idUserObject);
        Integer idKlaimMax = klaimService.getIdKlaimMax();
        Integer idKlaim = null;
        if (idKlaimMax != null) {
            idKlaim = idKlaimMax + 1;
        }else{
            idKlaim = 1;
        }
        

        System.out.println(idKlaim);
        
//      PERHITUNGAN
        Integer totalTransportasi = idTransportasiMobilbiaya + idTransportasiPesawatbiaya + idTransportasiKeretabiaya + idTransportasiMotorbiaya;
        Integer totalKlaim = biayaHotelKlaim + biayaKonsumsiKlaim + totalTransportasi;
       

        TblKlaim klaim = new TblKlaim(idKlaim, tglKlaim, tglMulaiDinasKlaim, tglAkhirDinasKlaim, kegiatanDinasKlaim, hotelKlaim, biayaHotelKlaim, biayaKonsumsiKlaim, totalTransportasi, totalKlaim, notaHotelKlaim, notaTransportasiKlaim, notaKonsumsiKlaim, idUserObject, idKotaObject);
        klaim.setIdKlaim(idKlaim);
        klaim.setTglKlaim(tglKlaim);
        klaim.setTglMulaiDinasKlaim(tglMulaiDinasKlaim);
        klaim.setTglAkhirDinasKlaim(tglAkhirDinasKlaim);
        klaim.setKegiatanDinasKlaim(kegiatanDinasKlaim);
        klaim.setHotelKlaim(hotelKlaim);
        klaim.setBiayaHotelKlaim(biayaHotelKlaim);
        klaim.setBiayaKonsumsiKlaim(biayaKonsumsiKlaim);
        klaim.setTotalTransportasi(totalTransportasi);
        klaim.setTotalKlaim(totalKlaim);
        klaim.setNotaHotelKlaim(notaHotelKlaim);
        klaim.setNotaKonsumsiKlaim(notaKonsumsiKlaim);
        klaim.setNotaTransportasiKlaim(notaTransportasiKlaim);
        klaim.setIdUser((TblUser) idUserObject);
        klaim.setIdKota((TblKota) idKotaObject);

        this.klaimService.save(klaim);
        

        Object idKlaimObject = new TblKlaim(idKlaim);
        if (idTransportasiMobilbiaya != null) {
            Object idTransportasiObject = new TblTransportasi(idTransportasiMobil);
            Boolean statusTransportasi = true;
            Integer biayaTransportasi = idTransportasiMobilbiaya;

            TblTrTransportasiKlaim trTrans = new TblTrTransportasiKlaim(idKlaimObject, idTransportasiObject, biayaTransportasi, statusTransportasi);

            trTrans.setIdKlaim((TblKlaim) idKlaimObject);
            trTrans.setIdTransportasi((TblTransportasi) idTransportasiObject);
            trTrans.setBiayaTransportasi(biayaTransportasi);
            trTrans.setStatusTransportasi(true);
            this.trTransportasiKlaimService.save(trTrans);

        } 

        if (idTransportasiKeretabiaya != null) {
            Object idTransportasiObject = new TblTransportasi(idTransportasiKereta);
            Boolean statusTransportasi = true;
            Integer biayaTransportasi = idTransportasiKeretabiaya;

            TblTrTransportasiKlaim trTransK = new TblTrTransportasiKlaim(idKlaimObject, idTransportasiObject, biayaTransportasi, statusTransportasi);

            trTransK.setIdKlaim((TblKlaim) idKlaimObject);
            trTransK.setIdTransportasi((TblTransportasi) idTransportasiObject);
            trTransK.setBiayaTransportasi(biayaTransportasi);
            trTransK.setStatusTransportasi(true);
            this.trTransportasiKlaimService.save(trTransK);
        }

        if (idTransportasiPesawatbiaya != null) {
            Object idTransportasiObject = new TblTransportasi(idTransportasiPesawat);
            Boolean statusTransportasi = true;
            Integer biayaTransportasi = idTransportasiPesawatbiaya;

            TblTrTransportasiKlaim trTransP = new TblTrTransportasiKlaim(idKlaimObject, idTransportasiObject, biayaTransportasi, statusTransportasi);

            trTransP.setIdKlaim((TblKlaim) idKlaimObject);
            trTransP.setIdTransportasi((TblTransportasi) idTransportasiObject);
            trTransP.setBiayaTransportasi(biayaTransportasi);
            trTransP.setStatusTransportasi(true);
            this.trTransportasiKlaimService.save(trTransP);
        }
        if (idTransportasiMotorbiaya != null) {
            Object idTransportasiObject = new TblTransportasi(idTransportasiMotor);
            Boolean statusTransportasi = true;
            Integer biayaTransportasi = idTransportasiMotorbiaya;

            TblTrTransportasiKlaim trTransM = new TblTrTransportasiKlaim(idKlaimObject, idTransportasiObject, biayaTransportasi, statusTransportasi);

            trTransM.setIdKlaim((TblKlaim) idKlaimObject);
            trTransM.setIdTransportasi((TblTransportasi) idTransportasiObject);
            trTransM.setBiayaTransportasi(biayaTransportasi);
            trTransM.setStatusTransportasi(true);
            this.trTransportasiKlaimService.save(trTransM);
        }
        
//        Object idUserManagerObject = new TblUser(2);
//        Object idApprovalStatusObject = new TblApprovalStatus(idApprovalStatus);
//        TblApproval approvalAdd = new TblApproval (idApprovalStatusObject, idKlaimObject);        
//        approvalAdd.setIdApprovalStatus((TblApprovalStatus)idApprovalStatusObject);
//        approvalAdd.setIdKlaim((TblKlaim)idKlaimObject);
////        approvalAdd.setIdUser((TblUser)idUserManagerObject);
//        this.approvalService.save(approvalAdd);Integer idKlaimMax = klaimService.getIdKlaimMax();


        Integer idApprovalMax = approvalService.getIdApprovalMax();
        Integer idApproval = null;
        if (idApprovalMax != null) {
            idApproval = idApprovalMax + 1;
        }else{
            idApproval = 1;
        }
        
        Object idUserManagerObject = new TblUser (2);        
        Object idApprovalStatusObject = new TblApprovalStatus(10);        
        TblApproval approvalAdd = new TblApproval (idApproval, idApprovalStatusObject, idKlaimObject, idUserManagerObject);        
        approvalAdd.setIdApproval(idApproval);
        approvalAdd.setIdApprovalStatus((TblApprovalStatus)idApprovalStatusObject);
        approvalAdd.setIdKlaim((TblKlaim)idKlaimObject);
        approvalAdd.setIdUser((TblUser)idUserManagerObject);
        this.approvalService.save(approvalAdd);

//        
//        this.approvalService.save(approvalAdd);
        

        return "redirect:/klaim";
    }

    @GetMapping("/klaim")
    public String getKlaimList(Model model) {
        Iterable<TblKlaim> klaim = klaimService.getAll();
        model.addAttribute("klaim", klaim);
        Iterable<TblUser> user = userService.getUserActive();
        model.addAttribute("user", user);
        Iterable<TblTransportasi> transportasi = transportasiService.getTransportasiActive();
        model.addAttribute("transportasi", transportasi);
        Iterable<TblKota> kota = kotaService.getAll();
        model.addAttribute("kota", kota);

        TblKlaim klaimCrud = new TblKlaim();
        model.addAttribute("addKlaim", klaimCrud);
//        model.addAttribute("editKota", kotaCrud);
//        model.addAttribute("removeProvinsi", provinsiCrud);

        System.out.println("ini halaman klaim");

        return "klaim/v_page.html";
    }
    
//    @GetMapping("/manager")
//    public String getManagerList(Model model) {
//        List<TblKlaim> manager = klaimService.getUserManager();
//        model.addAttribute("manager", manager);
//        
//        TblKlaim klaimCrud = new TblKlaim();
//        model.addAttribute("addManager", klaimCrud);
//
//        System.out.println("ini halaman klaim");
//
//        return "klaim/v_page.html";
//        
//    }
}
