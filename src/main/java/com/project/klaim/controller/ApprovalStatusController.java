/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.controller;

import com.project.klaim.entity.TblApprovalStatus;
import com.project.klaim.service.ApprovalStatusService;
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
public class ApprovalStatusController {

    @Autowired
    private ApprovalStatusService approvalStatusService;

    @GetMapping("/approvalStatus")
    public String getApprovalStatus(Model model) {
        Iterable<TblApprovalStatus> approvalStatus = approvalStatusService.getApprovalActive();
        model.addAttribute("approvalStatus", approvalStatus);

        TblApprovalStatus approvalStatusCrud = new TblApprovalStatus();

        model.addAttribute("addApprovalStatus", approvalStatusCrud);
        model.addAttribute("editApprovalStatus", approvalStatusCrud);
        model.addAttribute("removeApprovalStatus", approvalStatusCrud);

        System.out.println("ini approval Status");
        return ("approvalStatus/v_page.html");

    }

    @RequestMapping(value = "approvalStatus/add", method = RequestMethod.POST)
//    @GetMapping("/approvalStatus/add")
    public String getApprovalStatusAdd( 
            @RequestParam(value = "idApprovalStatus", required = false) Integer idApprovalStatus,
            @RequestParam(value = "namaApprovalStatus", required = false) String namaApprovalStatus
    )
    {
        Boolean approvalStatus = true;
        TblApprovalStatus approvalStatusAdd = new TblApprovalStatus(idApprovalStatus, namaApprovalStatus, approvalStatus);
        approvalStatusAdd.setIdApprovalStatus(idApprovalStatus);
        approvalStatusAdd.setNamaApprovalStatus(namaApprovalStatus);
        approvalStatusAdd.setApprovalStatus(approvalStatus);
        

        this.approvalStatusService.save(approvalStatusAdd);

        System.out.println("ini masuk halaman approval status");
        return "redirect:/approvalStatus";
    }

    @PostMapping(value = "/approvalStatus/edit")
    public String getApprovalStatusEdit(
            @RequestParam(value = "idApprovalStatus", required = false) Integer idApprovalStatus,
            @RequestParam(value = "namaApprovalStatus", required = false) String namaApprovalStatus
//            @RequestParam(value = "approvalStatus", required = false) Boolean approvalStatus
    ) {
        Boolean approvalStatus = true;
        TblApprovalStatus approvalStatusEdit = new TblApprovalStatus(idApprovalStatus, namaApprovalStatus, approvalStatus);
        approvalStatusEdit.setIdApprovalStatus(idApprovalStatus);
        approvalStatusEdit.setNamaApprovalStatus(namaApprovalStatus);
        approvalStatusEdit.setApprovalStatus(approvalStatus);

        this.approvalStatusService.save(approvalStatusEdit);
        return "redirect:/approvalStatus";

    }
}
