/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.interfaces;

import com.project.klaim.entity.TblApproval;

/**
 *
 * @author MELLA
 */
public interface ApprovalInterface {
    void save(TblApproval approval);    
    Iterable<TblApproval> getAll();
    public TblApproval getIdApprovalStatus(Integer idApprovalStatus);
    public TblApproval getIdKlaim(Integer idKlaim);
    public TblApproval getIdUser(Integer idUser);
    public Integer getIdApprovalMax();
    
}
