/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.interfaces;

import com.project.klaim.entity.TblKota;
import com.project.klaim.entity.TblProvinsi;

/**
 *
 * @author MELLA
 */
public interface KotaInterface {
    void save(TblKota kota);    
    Iterable<TblKota> getAll();
    
}
