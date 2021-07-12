/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.TblTransportasi;
import com.project.klaim.interfaces.TransportasiInterface;
import com.project.klaim.repository.TransportasiRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class TransportasiService implements TransportasiInterface{

    @Autowired
    private TransportasiRepository transportasiRepository;
    
    @Override
    public void save(TblTransportasi transportasi) {
        transportasiRepository.save(transportasi);
    }

    @Override
    public Iterable<TblTransportasi> getTransportasiActive() {
        return transportasiRepository.getTransportasiActive();
    }

    @Override
    public Optional<TblTransportasi> getTransportasiById(Integer idTransportasi) {
        return transportasiRepository.findById(idTransportasi);
                
    }
    
}
