/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.repository;

import com.project.klaim.entity.TblApprovalStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MELLA
 */
@Repository
public interface ApprovalStatusRepository extends CrudRepository<TblApprovalStatus, Integer>{
    @Query(value = "SELECT * FROM tbl_approval_status WHERE tbl_approval_status.approval_status = 1", nativeQuery = true)
    Iterable <TblApprovalStatus> getApprovalStatusActive();
}
