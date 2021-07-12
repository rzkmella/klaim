/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.repository;

import com.project.klaim.entity.TblKota;
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
public interface KotaRepository extends CrudRepository<TblKota, Integer>{
    @Query(value = "SELECT * FROM tbl_kota JOIN tbl_provinsi tbl_kota.id_provinsi = tbl_provinsi.id_provinsi WHERE id_kota = :idKota", nativeQuery = true)
    List <TblKota> getKotaById(@Param(value="idKota") Integer idKota);
}
