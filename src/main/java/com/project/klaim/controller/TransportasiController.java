/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.controller;

import com.project.klaim.entity.TblRole;
import com.project.klaim.entity.TblTransportasi;
import com.project.klaim.service.TransportasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MELLA
 */
@Controller
@RequestMapping
public class TransportasiController {
   @Autowired
   private TransportasiService transportasiService;
   
   @GetMapping("/transportasi")
   public String getTransportasi(Model model){
        Iterable<TblTransportasi> transportasi = transportasiService.getTransportasiActive();
        model.addAttribute("transportasi", transportasi);

        TblTransportasi transportasiCrud = new TblTransportasi();

        model.addAttribute("addTransportasi", transportasiCrud);
        model.addAttribute("editTransportasi", transportasiCrud);
        model.addAttribute("removeTransportasi", transportasiCrud);

        System.out.println("ini transportasi");
        return ("transportasi/v_page.html");
    
}
   @RequestMapping(value = "/transportasi/add", method = RequestMethod.POST)
   // @GetMapping("/role/add")
    public String getTransportasiAdd(@ModelAttribute("addTransportasi") TblTransportasi transportasi) {
        this.transportasiService.save(transportasi);

        System.out.println("ini masuk halaman add transportasi");
        return "redirect:/transportasi";
    }

    @PostMapping(value = "/transportasi/edit")
    public String getTransportasiEdit(
            @RequestParam(value = "idTransportasi", required = false) Integer idTransportasi,
            @RequestParam(value = "namaTransportasi", required = false) String namaTransportasi,
//            @RequestParam(value = "biayaTransportasi", required = false) Integer biayaTransportasi,
            @RequestParam(value = "statusTransportasi", required = false) boolean statusTransportasi
    ) {
//        TblTransportasi transportasiEdit = new TblTransportasi(idTransportasi, namaTransportasi, biayaTransportasi, statusTransportasi);
        TblTransportasi transportasiEdit = new TblTransportasi(idTransportasi, namaTransportasi, statusTransportasi);
        transportasiEdit.setIdTransportasi(idTransportasi);
        transportasiEdit.setNamaTransportasi(namaTransportasi);
        
//        transportasiEdit.setBiayaTransportasi(biayaTransportasi);
        

        this.transportasiService.save(transportasiEdit);
        return "redirect:/transportasi";

    }
   
}
