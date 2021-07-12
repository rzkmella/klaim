/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.repository;

import com.project.klaim.entity.TblTransportasi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MELLA
 */
@Repository
public interface TransportasiRepository extends CrudRepository<TblTransportasi, Integer>{
    @Query(value = "SELECT * FROM tbl_transportasi WHERE tbl_transportasi.status_transportasi = 1", nativeQuery = true)
    public Iterable<TblTransportasi> getTransportasiActive();
}
