/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.interfaces;

import com.project.klaim.entity.TblKlaim;
import java.util.List;

/**
 *
 * @author MELLA
 */
public interface KlaimInterface {
    void save(TblKlaim klaim);    
    Iterable<TblKlaim> getAll();
    public Integer getIdKlaimMax(); 
//    List <TblKlaim> getUserManager();
}
