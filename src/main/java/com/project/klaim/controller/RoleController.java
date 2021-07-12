/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.controller;


import com.project.klaim.entity.TblRole;
import com.project.klaim.service.RoleService;
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
public class RoleController {
    @Autowired
    private RoleService roleService;
        
        
    
//   @GetMapping("/role")
//    public String getRoleStatus(Model model) {
//        
//        System.out.println("ini role");
//        return "role/v_page.html";
//    }
    @GetMapping("/role")
    public String getRole(Model model) {
        Iterable<TblRole> role = roleService.getRoleActive();
        model.addAttribute("role", role);

        TblRole roleCrud = new TblRole();

        model.addAttribute("addRole", roleCrud);
        model.addAttribute("editRole", roleCrud);
        model.addAttribute("removeRole", roleCrud);

        System.out.println("ini role");
        return ("role/v_page.html");

    }
    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
   // @GetMapping("/role/add")
    public String getRoleAdd(
            @RequestParam(value = "idRole", required = false) Integer idRole,
            @RequestParam(value = "namaRole", required = false) String namaRole
    )  {
        Boolean statusRole = true;
        TblRole roleAdd = new TblRole(idRole, namaRole, statusRole);
        roleAdd.setIdRole(idRole);
        roleAdd.setNamaRole(namaRole);
        roleAdd.setStatusRole(statusRole);
        
        this.roleService.save(roleAdd);

        System.out.println("ini masuk halaman add role");
        return "redirect:/role";
    }

    @PostMapping(value = "/role/edit")
    public String getRoleEdit(
            @RequestParam(value = "idRole", required = false) Integer idRole,
            @RequestParam(value = "namaRole", required = false) String namaRole,
            @RequestParam(value = "statusRole", required = false) Boolean statusRole
    ) {
        TblRole roleEdit = new TblRole(idRole, namaRole, statusRole);
        roleEdit.setIdRole(idRole);
        roleEdit.setNamaRole(namaRole);
        roleEdit.setStatusRole(statusRole);

        this.roleService.save(roleEdit);
        return "redirect:/role";

    }
    
}
