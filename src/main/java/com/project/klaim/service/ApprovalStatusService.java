/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.TblApprovalStatus;
import com.project.klaim.interfaces.ApprovalStatusInterface;
import com.project.klaim.repository.ApprovalStatusRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class ApprovalStatusService implements ApprovalStatusInterface{
    
    @Autowired
    private ApprovalStatusRepository approvalStatusRepository;

//    @Override
//    public void save(TblApprovalStatus approvalStatus) {
//        approvalStatusRepository.save(approvalStatus);
//    }
//
//    @Override
//    public Iterable<TblApprovalStatus> getApprovalActive() {
//        return approvalStatusRepository.getApprovalStatusActive();
//    }
//
//    @Override
//    public Optional<TblApprovalStatus> getApprovalById(Integer idApprovalStatus) {
//        return approvalStatusRepository.findById(idApprovalStatus);
//    }

    @Override
    public Iterable<TblApprovalStatus> getAll() {
        return approvalStatusRepository.findAll();
    }

    @Override
    public Optional<TblApprovalStatus> getApprovalById(Integer idApprovalStatus) {
        return approvalStatusRepository.findById(idApprovalStatus);
    }

    @Override
    public void deleteById(Integer id) {
        approvalStatusRepository.deleteById(id);
    }

    @Override
    public void save(TblApprovalStatus approvalStatus) {
        approvalStatusRepository.save(approvalStatus);
    }

    @Override
    public Iterable<TblApprovalStatus> getApprovalActive() {
        return approvalStatusRepository.getApprovalStatusActive();
    }
    
}
