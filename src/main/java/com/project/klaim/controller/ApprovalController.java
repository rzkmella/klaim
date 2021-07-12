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
import com.project.klaim.entity.TblUser;
import com.project.klaim.service.ApprovalService;
import com.project.klaim.service.ApprovalStatusService;
import com.project.klaim.service.KlaimService;
import com.project.klaim.service.UserService;
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
public class ApprovalController {
    
    @Autowired
    ApprovalService approvalService;
    
    @Autowired
    ApprovalStatusService approvalStatusService;
    
    @Autowired
    KlaimService klaimService;
    
    @Autowired
    UserService userService;
    
    
    @GetMapping("/approval")
    public String getApproval(Model model) {
        
        Iterable<TblApproval> approval = approvalService.getAll();
        model.addAttribute("approval", approval);
        
        Iterable<TblApprovalStatus> approvalStatus = approvalStatusService.getApprovalActive();
        model.addAttribute("approvalStatus", approvalStatus);
        
        Iterable<TblKlaim> klaim = klaimService.getAll();
        model.addAttribute("klaim", klaim);
        
        Iterable<TblUser> user = userService.getUserActive();
        model.addAttribute("user", user);
        
        TblApproval approvalCrud = new TblApproval();
//        model.addAttribute("addApproval", approvalCrud);
        model.addAttribute("editApproval", approvalCrud);       
        
        
        System.out.println("ini approval");
        return "approval/v_page.html";
    }
    
    @RequestMapping(value = "/approval/edit", method = RequestMethod.POST)
    public String editApproval(
            @RequestParam(value = "idApproval", required = false) Integer idApproval,
            @RequestParam(value = "idApprovalStatus", required = false) Integer idApprovalStatus,
            @RequestParam(value = "idKlaim", required = false) Integer idKlaim,
            @RequestParam(value = "idUser", required = false) Integer idUser
    ) {
        System.out.println("ini edit approval");
        
        Object idApprovalStatusObject = new TblApproval(idApprovalStatus);
        Object idKlaimObject = new TblKlaim(idKlaim);
        Object idUserObject = new TblUser(2);

        TblApproval approval = new TblApproval(idApproval, idApprovalStatusObject, idKlaimObject, idUserObject);
        approval.setIdApproval(idApproval);
        approval.setIdApprovalStatus((TblApprovalStatus)idApprovalStatusObject);
        approval.setIdKlaim((TblKlaim)idKlaimObject);

        this.approvalService.save(approval);
        return "redirect:/approval";
    }
    
}
