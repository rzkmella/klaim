/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.repository;

import com.project.klaim.entity.TblKlaim;
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
public interface KlaimRepository extends CrudRepository<TblKlaim, Integer>{
//    SAMPAI SINI MELLL TGL 04 07 2021
    @Query(value = "SELECT * FROM tbl_klaim JOIN tbl_user tbl_klaim.id_user = tbl_user.id_user WHERE id_user = :idUser", nativeQuery = true)
//    List <TblKlaim> getById(@Param(value="idUser") Integer idUser
    public TblKlaim getIdUser(@Param("idUser") Integer idUser);
    
    @Query(value = "SELECT MAX(id_klaim) FROM tbl_klaim", nativeQuery = true)
    public Integer getIdKlaimMax();
    
//    @Query(value = "SELECT id_user, nama_lengkap_user from tbl_user join tbl_role on tbl_user.id_role=tbl_role.id_role where nama_role='manager';", nativeQuery = true)
//    List <TblKlaim> getUserManager();
}
