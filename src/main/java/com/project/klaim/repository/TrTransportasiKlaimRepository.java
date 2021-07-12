/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.repository;

import com.project.klaim.entity.TblTrTransportasiKlaim;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MELLA
 */
@Repository
public interface TrTransportasiKlaimRepository extends CrudRepository<TblTrTransportasiKlaim, Integer>{
    @Query(value = "SELECT * FROM tbl_tr_transportasi_klaim WHERE id_klaim = :idKlaim", nativeQuery = true)
    List <TblTrTransportasiKlaim> getKlaimById(@Param(value="idKlaim") Integer idKlaim);
    
    
    
}
