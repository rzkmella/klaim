/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.interfaces;


import com.project.klaim.entity.TblApprovalStatus;
import java.util.Optional;

/**
 *
 * @author MELLA
 */
public interface ApprovalStatusInterface {
//    void save(TblApprovalStatus approvalStatus);
//    Iterable<TblApprovalStatus> getApprovalActive();
//    public Optional<TblApprovalStatus> getApprovalById(Integer idApprovalStatus);
    Iterable<TblApprovalStatus> getAll(); 
    Optional<TblApprovalStatus> getApprovalById(Integer idApprovalStatus);
    void deleteById(Integer id);
    void save(TblApprovalStatus approvalStatus);
    Iterable<TblApprovalStatus> getApprovalActive();
    
}
