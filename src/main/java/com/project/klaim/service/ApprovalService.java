/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.TblApproval;
import com.project.klaim.interfaces.ApprovalInterface;
import com.project.klaim.repository.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class ApprovalService implements ApprovalInterface{
    @Autowired
    private ApprovalRepository approvalRepository;

    @Override
    public void save(TblApproval approval) {
        approvalRepository.save(approval);
    }

    @Override
    public Iterable<TblApproval> getAll() {
        return approvalRepository.findAll();
    }

    @Override
    public TblApproval getIdApprovalStatus(Integer idApprovalStatus) {
        return approvalRepository.getIdApprovalStatus(idApprovalStatus);
    }

    @Override
    public TblApproval getIdKlaim(Integer idKlaim) {
        return approvalRepository.getIdKlaim(idKlaim);
    }

    @Override
    public TblApproval getIdUser(Integer idUser) {
        return approvalRepository.getIdUser(idUser);
    }

    @Override
    public Integer getIdApprovalMax() {
    return approvalRepository.getIdApprovalMax();
            
    }
    
}
