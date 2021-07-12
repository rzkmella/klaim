/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.TblProvinsi;
import com.project.klaim.interfaces.ProvinsiInterface;
import com.project.klaim.repository.ProvinsiRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class ProvinsiService implements ProvinsiInterface{
    
    @Autowired
    private ProvinsiRepository provinsiRepository;

    @Override
    public void save(TblProvinsi provinsi) {
        provinsiRepository.save(provinsi);
    }

    @Override
    public Iterable<TblProvinsi> getAll() {
        return provinsiRepository.findAll();
    }

    
}
