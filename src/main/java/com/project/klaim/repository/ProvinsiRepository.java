/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.repository;

import com.project.klaim.entity.TblProvinsi;
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
public interface ProvinsiRepository extends CrudRepository<TblProvinsi, Integer>{
//    @Query(value = "SELECT * FROM tbl_provinsi WHERE id_provinsi = :idProvinsi", nativeQuery = true)
//    List<TblProvinsi> getProvinsiById (@Param(value = "idProvinsi")Integer idProvinsi);  
    
}
