/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.TblUser;
import com.project.klaim.interfaces.UserInterface;
import com.project.klaim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class UserService implements UserInterface{

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public TblUser getEmail(String emailUser) {
        return userRepository.getEmail(emailUser);
    }

    @Override
    public TblUser getPassword(String passwordUser) {
        return userRepository.getPassword(passwordUser);
    }

    @Override
    public void save(TblUser user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<TblUser> getUserActive() {
        return userRepository.getUserActive();
    }
    
    
}
