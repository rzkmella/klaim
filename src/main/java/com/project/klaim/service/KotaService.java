/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.TblKota;
import com.project.klaim.interfaces.KotaInterface;
import com.project.klaim.repository.KotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class KotaService implements KotaInterface{
    @Autowired
    private KotaRepository kotaRepository;

    @Override
    public void save(TblKota kota) {
        kotaRepository.save(kota);
    }

    @Override
    public Iterable<TblKota> getAll() {
        return kotaRepository.findAll();
    }
    
}
