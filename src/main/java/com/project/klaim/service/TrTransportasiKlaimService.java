/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.TblTrTransportasiKlaim;
import com.project.klaim.interfaces.TrTransportasiKlaimInterface;
import com.project.klaim.repository.TrTransportasiKlaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class TrTransportasiKlaimService implements TrTransportasiKlaimInterface{
    @Autowired
    private TrTransportasiKlaimRepository trTransportasiKlaimRepository;
    
    @Override
    public void save(TblTrTransportasiKlaim trTransportasiKlaim) {
        trTransportasiKlaimRepository.save(trTransportasiKlaim);
    }

    @Override
    public Iterable<TblTrTransportasiKlaim> getAll() {
        return trTransportasiKlaimRepository.findAll();
    }

    @Override
    public Iterable<TblTrTransportasiKlaim> getKlaimById(Integer idKlaim) {
        return trTransportasiKlaimRepository.getKlaimById(idKlaim);
    }
    
    
    
}
