/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.TblKlaim;
import com.project.klaim.interfaces.KlaimInterface;
import com.project.klaim.repository.KlaimRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class KlaimService implements KlaimInterface{
    @Autowired
    private KlaimRepository klaimRepository;

    @Override
    public void save(TblKlaim klaim) {
        klaimRepository.save(klaim);
    }

    @Override
    public Iterable<TblKlaim> getAll() {
        return klaimRepository.findAll();
    }

    @Override
    public Integer getIdKlaimMax() {
        return klaimRepository.getIdKlaimMax();
    }
//
//    @Override
//    public List<TblKlaim> getUserManager() {
//        return klaimRepository.getUserManager();
//    }
//
//    @Override
//    public List<TblKlaim> getUserManager() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
}
