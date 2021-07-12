///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.project.klaim.config;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author MELLA
// */
//@Component
//public class SecurityCustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
//    
//     private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    @Override
//    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws 
//            IOException{
//        
//        String targetUrl = determineTargetUrl(authentication);
//        if (response.isCommitted()) {
//            System.out.println("Can't Rediect");
//            return;
//        }
//        redirectStrategy.sendRedirect(request, response, targetUrl);
//        
//     
//     
//}
//
//    private String determineTargetUrl(Authentication authentication) {
//   System.out.println("DETERMINE");
//        String url = "";
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        List<String> roles = new ArrayList<String>();
//        
//        for (GrantedAuthority a : authorities) {
//            roles.add(a.getAuthority());
//        }
//        
//        System.out.println("Role determineTargetUrl " + roles);
//        String role = roles.toString();
//        
//        System.out.println("Role : " + role);
//        
//        if (role.equals("ROLE_admin")) {
//            url = "approvalStatus";
//        } else if(role.equals("ROLE_employee")){
//            url = "klaim";
//        } else{
//            url = "approval";
//        }
//        
//        return url;
//    }
//    public void setRedirectStrategy(RedirectStrategy redirectStrategy){
//        this.redirectStrategy = redirectStrategy;
//    }
//    
//    protected RedirectStrategy getRedirectStrategy(){
//        return redirectStrategy;
//    }
//}
