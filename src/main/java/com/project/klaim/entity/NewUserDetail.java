/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author MELLA
 */
public class NewUserDetail implements UserDetails {

    private String emailUser;
    private String passwordUser;
    private List<GrantedAuthority> authorities; //type dari coolection memungkinkan untuk menggunakan lebih dari satu role user

    public NewUserDetail(String emailUser, String passwordUser, String namaRole) {
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_:" + namaRole));// di custom dsini jadi hanya bisa memakai satu role
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return passwordUser;
    }

    @Override
    public String getUsername() {
        return emailUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
