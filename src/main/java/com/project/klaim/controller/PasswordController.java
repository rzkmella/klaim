/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.controller;

import com.project.klaim.entity.TblRole;
import com.project.klaim.entity.TblUser;
import com.project.klaim.service.RoleService;
import com.project.klaim.service.SpringMailService;
import com.project.klaim.service.UserService;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class PasswordController {
   
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private SpringMailService springMailService; 

//    @GetMapping("/password")
//    public String getPassword(Model model) {
//        
//        System.out.println("ini password forgot");
//        return "password/v_page_forgot.html";
//    
    
    @GetMapping("/user")
    public String getUser(Model model){
        Iterable<TblUser> user = userService.getUserActive();
        model.addAttribute("user", user);
        Iterable<TblRole> role = roleService.getRoleActive();
        model.addAttribute("role", role);

//pengecekan relasi     
//        for (TblRole rol : role){
//            System.out.println(rol.getIdRole());
//            System.out.println(rol.getNamaRole());
//        }

        TblUser userCrud = new TblUser();

        model.addAttribute("addUser", userCrud);
        model.addAttribute("editUser", userCrud);
        model.addAttribute("removeUser", userCrud);

        System.out.println("ini user");
        return ("user/v_page.html");
    }
    
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(
            @RequestParam(value = "idUser", required = false) Integer idUser,
            @RequestParam(value = "namaLengkapUser", required = false) String namaLengkapUser,
            @RequestParam(value = "emailUser", required = false) String emailUser,
            @RequestParam(value = "passwordUser", required = false) String passwordUser,
            @RequestParam(value = "noRekeningUser", required = false) String noRekeningUser,
            @RequestParam(value = "statusUser", required = false) boolean statusUser,
//            @RequestParam(value = "token", required = false) String token,
            @RequestParam(value = "idRole", required = false) Integer idRole
    ) {

        Object idRoleObject = new TblRole(idRole);

        TblUser user = new TblUser(idUser, namaLengkapUser, emailUser, passwordUser, noRekeningUser, statusUser, idRoleObject);
        user.setIdUser(idUser);
        user.setNamaLengkapUser(namaLengkapUser);
        user.setEmailUser(emailUser);
        user.setPasswordUser(passwordUser);
        user.setNoRekeningUser(noRekeningUser);
        user.setStatusUser(statusUser);
        user.setIdRole((TblRole)idRoleObject);
        
        System.out.println("ini add user");

        this.userService.save(user);
        return "redirect:/user";
    }
    
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String editUser(
            @RequestParam(value = "idUser", required = false) Integer idUser,
            @RequestParam(value = "namaLengkapUser", required = false) String namaLengkapUser,
            @RequestParam(value = "emailUser", required = false) String emailUser,
            @RequestParam(value = "passwordUser", required = false) String passwordUser,
            @RequestParam(value = "noRekeningUser", required = false) String noRekeningUser,
            @RequestParam(value = "statusUser", required = false) boolean statusUser,
//            @RequestParam(value = "token", required = false) String token,
            @RequestParam(value = "idRole", required = false) Integer idRole
    ) {

        Object idRoleObject = new TblRole(idRole);

        TblUser user = new TblUser(idUser, namaLengkapUser, emailUser, passwordUser, noRekeningUser, statusUser, idRoleObject);
        user.setIdUser(idUser);
        user.setNamaLengkapUser(namaLengkapUser);
        user.setEmailUser(emailUser);
        user.setPasswordUser(passwordUser);
        user.setNoRekeningUser(noRekeningUser);
        user.setStatusUser(statusUser);
        user.setIdRole((TblRole)idRoleObject);

        this.userService.save(user);
        return "redirect:/user";
    }
    
    
    @GetMapping("/password/forgot")
    public String getforgotPassword() {

        return "password/v_page_forgot.html";
    }

    @GetMapping("/password/reset")
    public String getresetPassword() {

        return "password/v_page_reset.html";
    }

    @PostMapping("/password/forgot/request")
    public String setrequestForgotPassword(
            @RequestParam (value = "email", required = true) String email){
        {
            System.out.println(email);
            TblUser getTblUser = userService.getEmail(email);
            String sender = getTblUser.getNamaLengkapUser();
            

            String key = UUID.randomUUID().toString();//generate key

            String subject = "Password Reset";
            String content = "Use Code: " + key + ", or click on button bellow";
            String link = "http://localhost:8082/password/reset/";

            System.out.println("send mail running");

            Map<String, Object> model = new HashMap<>();
            model.put("title", subject);
            model.put("name", sender);
            model.put("messege", content);
            model.put("url", link);

            springMailService.sendMail(model, subject, email);
            return "redirect:/password/forgot";
        }
    }
    
}

