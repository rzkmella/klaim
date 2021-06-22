/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MELLA
 */
@Controller
@RequestMapping
public class testController {
    //System.out.println("nama")
    
    @GetMapping("/mella")
    public void getRoleStatus(Model model) {
        System.out.println("mella");
        System.out.println("mella");
    }
    
}
