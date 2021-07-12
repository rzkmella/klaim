/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.controller;

import com.project.klaim.entity.TblApprovalStatus;
import com.project.klaim.entity.TblProvinsi;
import com.project.klaim.service.ProvinsiService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ProvinsiController {

    @Autowired
    private ProvinsiService provinsiService;

    @GetMapping("/provinsi")
    public String getProvinsi(Model model) //            @PathVariable Integer idProvinsi) 
    {
//        Optional<TblProvinsi> provinsi = provinsiService.getProvin
//        model.addAttribute("provinsi", provinsi);
        Iterable<TblProvinsi> provinsi = provinsiService.getAll();
        model.addAttribute("provinsi", provinsi);
        TblProvinsi provinsiCrud = new TblProvinsi();

        model.addAttribute("addProvinsi", provinsiCrud);
        model.addAttribute("editProvinsi", provinsiCrud);
        model.addAttribute("removeProvinsi", provinsiCrud);

        System.out.println("ini provinsi");
//        for (TblProvinsi provinsis : provinsi){
//            System.out.println(provinsis.getNamaProvinsi());
//            
//        }

        return "provinsi/v_page.html";
    }

    @RequestMapping(value = "provinsi/add", method = RequestMethod.POST)
//    @GetMapping("/provinsi/add")
    public String getProvinsiAdd(@ModelAttribute("addProvinsi") TblProvinsi provinsi) {
        this.provinsiService.save(provinsi);

        System.out.println("ini provinsi add");
        return "redirect:/provinsi";
    }

    @PostMapping(value = "/provinsi/edit")
    public String getProvinsiEdit(
            @RequestParam(value = "idProvinsi", required = false) Integer idProvinsi,
            @RequestParam(value = "namaProvinsi", required = false) String namaProvinsi
    ) {
        TblProvinsi provinsiEdit = new TblProvinsi(idProvinsi, namaProvinsi);
        provinsiEdit.setIdProvinsi(idProvinsi);
        provinsiEdit.setNamaProvinsi(namaProvinsi);

        this.provinsiService.save(provinsiEdit);
        return "redirect:/provinsi";

    }

}
