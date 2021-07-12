/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author MELLA
 */
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class securityConfiguration extends WebSecurityConfigurerAdapter {
    

    @Autowired
    UserDetailsService userDetailsService;
    
//    @Autowired
//    SecurityCustomSuccessHandler customSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //mengatur map kemana
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                
                .antMatchers("/role").hasRole("admin")
                .antMatchers("/approvalStatus").hasRole("admin")
                .antMatchers("/transportasi").hasRole("admin")
                .antMatchers("/provinsi").hasRole("admin")
                .antMatchers("/user").hasRole("admin")
                .antMatchers("/kota").hasRole("admin")
                .antMatchers("/TrTransportasiKlaim").hasRole("employee")               
                .antMatchers("/klaim").hasRole("employee")                
                .antMatchers("/approval").hasRole("manager")
                .antMatchers("/").permitAll()
                .antMatchers("/password/forgot").permitAll()
                .antMatchers("/password/forgot/request").permitAll()
                .and()
                .formLogin()
//                .successHandler(customSuccessHandler)
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .failureUrl("/index")
//                .permitAll()
//                .and().csrf()
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/accsess_denied")
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .addLogoutHandler(new SecurityLogout())
//                .logoutSuccessUrl("/login");
//                .loginPage("/loginpage")
//                .successHandler(csh)
//                .usernameParameter("email").passwordParameter("password")
                ;
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
