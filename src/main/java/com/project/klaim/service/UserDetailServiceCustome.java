/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.NewUserDetail;
import com.project.klaim.entity.TblRole;
import com.project.klaim.entity.TblUser;
import com.project.klaim.repository.RoleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class UserDetailServiceCustome implements UserDetailsService{

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public UserDetails loadUserByUsername(String emailUser) throws UsernameNotFoundException {
        
        TblUser user = userService.getEmail(emailUser);
        
        
     
        
        String email = user.getEmailUser();
        System.out.println("email " +email);
        String password = user.getPasswordUser();
         System.out.println("password " +password);
        Integer roleid = user.getIdRole().getIdRole();
        System.out.println("role " +roleid);
        
        Optional<TblRole> rolee = roleRepository.findById(roleid);
        String role = rolee.get().getNamaRole();       
        System.out.println("role " +role);
        
        return new NewUserDetail(email, password, role);
   }
    
    
}
