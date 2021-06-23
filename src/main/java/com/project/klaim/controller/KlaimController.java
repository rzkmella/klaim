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
public class KlaimController {
    
    @GetMapping("/klaim")
    public String getKlaim(Model model) {
        
        System.out.println("ini klaim");
        return "klaim/v_page.html";
    
}
}
