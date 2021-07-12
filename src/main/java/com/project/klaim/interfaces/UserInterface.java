/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.interfaces;

import com.project.klaim.entity.TblUser;

/**
 *
 * @author MELLA
 */
public interface UserInterface {
    void save(TblUser user);
    Iterable<TblUser> getUserActive();  
    TblUser getEmail(String emailUser);
    TblUser getPassword(String passwordUser);
    
}
