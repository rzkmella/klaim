/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.repository;

import com.project.klaim.entity.TblApproval;
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
public interface ApprovalRepository extends CrudRepository<TblApproval, Integer>{
    @Query(value = "SELECT * FROM tbl_approval JOIN tbl_approval_status ON tbl_approval.id_approval_status = tbl_approval_status.id_approval_status WHERE id_approval_status = :idApprovalStatus", nativeQuery = true)
    public TblApproval getIdApprovalStatus(@Param("idApprovalStatus") Integer idApprovalStatus);
    @Query(value = "SELECT * FROM tbl_approval JOIN tbl_klaim ON tbl_approval.id_klaim = tbl_klaim.id_klaim WHERE id_klaim = :idKlaim", nativeQuery = true)
    public TblApproval getIdKlaim(@Param("idKlaim") Integer idKlaim);
    @Query(value = "SELECT * FROM tbl_approval JOIN tbl_user ON tbl_approval.id_user = tbl_user.id_user WHERE id_user = :idUser", nativeQuery = true)
    public TblApproval getIdUser(@Param("idUser") Integer idUser);
    
    @Query(value = "SELECT MAX(id_approval) FROM tbl_approval", nativeQuery = true)
    public Integer getIdApprovalMax();

    
}
