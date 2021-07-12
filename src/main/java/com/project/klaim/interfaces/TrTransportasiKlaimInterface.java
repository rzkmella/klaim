/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.interfaces;

import com.project.klaim.entity.TblTrTransportasiKlaim;

/**
 *
 * @author MELLA
 */
public interface TrTransportasiKlaimInterface {
    void save(TblTrTransportasiKlaim trTransportasiKlaim);    
    Iterable<TblTrTransportasiKlaim> getAll();
    Iterable<TblTrTransportasiKlaim> getKlaimById(Integer idKlaim);
}
