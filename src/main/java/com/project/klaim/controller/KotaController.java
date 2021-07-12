/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.controller;

import com.project.klaim.entity.TblKota;
import com.project.klaim.entity.TblProvinsi;
import com.project.klaim.service.KotaService;
import com.project.klaim.service.ProvinsiService;
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
public class KotaController {

    @Autowired
    KotaService kotaService;

    @Autowired
    ProvinsiService provinsiService;

    @GetMapping("/kota")
    public String getKota(Model model) {
        Iterable<TblKota> kota = kotaService.getAll();
        model.addAttribute("kota", kota);
        Iterable<TblProvinsi> provinsi = provinsiService.getAll();
        model.addAttribute("provinsi", provinsi);
//pengecekan
        for (TblProvinsi prov : provinsi) {
            System.out.println(prov.getIdProvinsi());
            System.out.println(prov.getNamaProvinsi());
        }

        TblKota kotaCrud = new TblKota();
        model.addAttribute("addKota", kotaCrud);
        model.addAttribute("editKota", kotaCrud);
//      model.addAttribute("removeProvinsi", provinsiCrud);

        System.out.println("ini kota");

        return "kota/v_page.html";
    }

    @RequestMapping(value = "/kota/add", method = RequestMethod.POST)
    public String addKota(
            @RequestParam(value = "idKota", required = false) Integer idKota,
            @RequestParam(value = "namaKota", required = false) String namaKota,
            @RequestParam(value = "idProvinsi", required = false) Integer idProvinsi
    ) {

        Object idProvinsiObject = new TblProvinsi(idProvinsi);

        TblKota kota = new TblKota(idKota, namaKota, idProvinsiObject);
        kota.setIdKota(idKota);
        kota.setNamaKota(namaKota);
        kota.setIdProvinsi((TblProvinsi) idProvinsiObject);

        this.kotaService.save(kota);
        return "redirect:/kota";
    }

    @RequestMapping(value = "/kota/edit", method = RequestMethod.POST)
    public String editKota(
            @RequestParam(value = "idKota", required = false) Integer idKota,
            @RequestParam(value = "namaKota", required = false) String namaKota,
            @RequestParam(value = "idProvinsi", required = false) Integer idProvinsi
    ) {

        Object idProvinsiObject = new TblProvinsi(idProvinsi);

        TblKota kota = new TblKota(idKota, namaKota, idProvinsiObject);
        kota.setIdKota(idKota);
        kota.setNamaKota(namaKota);
        kota.setIdProvinsi((TblProvinsi) idProvinsiObject);

        this.kotaService.save(kota);
        return "redirect:/kota";
    }

}
