/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.interfaces;


import com.project.klaim.entity.TblTransportasi;
import java.util.Optional;

/**
 *
 * @author MELLA
 */
public interface TransportasiInterface  {
    void save(TblTransportasi transportasi);
    Iterable<TblTransportasi> getTransportasiActive();
    public Optional<TblTransportasi> getTransportasiById(Integer idTransportasi);
    
}
