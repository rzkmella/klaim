/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.controller;

import com.project.klaim.entity.TblTrTransportasiKlaim;
import com.project.klaim.entity.TblTransportasi;
import com.project.klaim.service.KlaimService;
import com.project.klaim.service.TrTransportasiKlaimService;
import com.project.klaim.service.TransportasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MELLA
 */
@Controller
@RequestMapping
public class TrTransportasiKlaimController {
    @Autowired
    TrTransportasiKlaimService trTransportasiKlaimService;
    
    @Autowired
    TransportasiService transportasiService;
    
    @Autowired
    KlaimService klaimService;
    

    @GetMapping("/TrTransportasiKlaim")
    public String getTrTransportasiKlaim(Model model) {
        Iterable<TblTrTransportasiKlaim> trTransportasiKlaim = trTransportasiKlaimService.getAll();
        model.addAttribute("trTransportasiKlaim", trTransportasiKlaim);
        
        Iterable<TblTransportasi> transportasi = transportasiService.getTransportasiActive();
        model.addAttribute("transportasi", transportasi);
////pengecekan
//        for (TblTransportasi trans : transportasi) {
//            System.out.println(trans.getIdTransportasi());
//            System.out.println(trans.getNamaTransportasi());
//        }

        TblTrTransportasiKlaim trCrud = new TblTrTransportasiKlaim();
        model.addAttribute("addTrTransportasiKlaim", trCrud);
        model.addAttribute("editTrTransportasiKlaim", trCrud);
        model.addAttribute("removeTrTransportasiKlaim", trCrud);

        System.out.println("ini TrTransportasiKlaim");

        return "trTransportasiKlaim/v_page.html";
    }
//    @RequestMapping(value = "/TrTransportasiKlaim/add", method = RequestMethod.POST)
//    public String addTrTransportasiKlaim(
//            @RequestParam(value = "idTrTransportasiKlaim", required = false) Integer idTrTransportasiKlaim,
//            @RequestParam(value = "biayaTransportasi", required = false) Integer biayaTransportasi,
//            @RequestParam(value = "statusTransportasi", required = false) boolean statusTransportasi,
//            @RequestParam(value = "idTransportasi", required = false) Integer idTransportasi
//    ) {
//
//        Object idTransportasiObject = new TblTransportasi(idTransportasi);
//
//        TblTrTransportasiKlaim trTransportasiKlaim = new TblTrTransportasiKlaim(idTrTransportasiKlaim, biayaTransportasi, statusTransportasi, idTransportasiObject);
//        trTransportasiKlaim.setIdTrTransportasiKlaim(idTrTransportasiKlaim);
//        trTransportasiKlaim.setBiayaTransportasi(biayaTransportasi);
//        trTransportasiKlaim.setStatusTransportasi(statusTransportasi);
//        trTransportasiKlaim.setIdTransportasi((TblTransportasi)idTransportasiObject);
//         System.out.println("ini TrTransportasiKlaim berhasil add");
//
//        this.trTransportasiKlaimService.save(trTransportasiKlaim);
//        return "redirect:/TrTransportasiKlaim";
//    }
    
//    @RequestMapping(value = "/TrTransportasiKlaim/edit", method = RequestMethod.POST)
//    public String editTrTransportasiKlaim(
//            @RequestParam(value = "idTrTransportasiKlaim", required = false) Integer idTrTransportasiKlaim,
//            @RequestParam(value = "biayaTransportasi", required = false) Integer biayaTransportasi,
//            @RequestParam(value = "statusTransportasi", required = false) boolean statusTransportasi,
//            @RequestParam(value = "idTransportasi", required = false) Integer idTransportasi
//    ) {
//
//        Object idTransportasiObject = new TblTransportasi(idTransportasi);
//
//        TblTrTransportasiKlaim trTransportasiKlaim = new TblTrTransportasiKlaim(idTrTransportasiKlaim, biayaTransportasi, statusTransportasi, idTransportasiObject);
//        trTransportasiKlaim.setIdTrTransportasiKlaim(idTrTransportasiKlaim);
//        trTransportasiKlaim.setBiayaTransportasi(biayaTransportasi);
//        trTransportasiKlaim.setStatusTransportasi(statusTransportasi);
//        trTransportasiKlaim.setIdTransportasi((TblTransportasi)idTransportasiObject);
//
//        this.trTransportasiKlaimService.save(trTransportasiKlaim);
//        return "redirect:/TrTransportasiKlaim";
//    }
    
}
