/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MELLA
 */
@Entity
@Table(name = "tbl_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblApproval.findAll", query = "SELECT t FROM TblApproval t"),
    @NamedQuery(name = "TblApproval.findByIdApproval", query = "SELECT t FROM TblApproval t WHERE t.idApproval = :idApproval")})
public class TblApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_approval")
    private Integer idApproval;
    @JoinColumn(name = "id_klaim", referencedColumnName = "id_klaim")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblKlaim idKlaim;
    @JoinColumn(name = "id_approval_status", referencedColumnName = "id_approval_status")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblApprovalStatus idApprovalStatus;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblUser idUser;

    public TblApproval() {
    }

    public TblApproval(Integer idApproval) {
        this.idApproval = idApproval;
    }

//    public TblApproval(Object idUserManagerObject, Object idApprovalStatusObject, Object idKlaimObject) {
//        this.idUser = (TblUser) idUser;
//        this.idApprovalStatus = (TblApprovalStatus) idApprovalStatus;
//        this.idKlaim = (TblKlaim) idKlaim;
//    }

//    public TblApproval(Object idApprovalStatusObject, Object idKlaimObject, Object idUserObject) {
//        this.idApprovalStatus = (TblApprovalStatus) idApprovalStatus;
//        this.idKlaim = (TblKlaim) idKlaim;
//        this.idUser = (TblUser) idUser;
//    }

    public TblApproval(Integer idApproval, Object idApprovalStatusObject, Object idKlaimObject, Object idUserObject) {
        this.idApproval = idApproval;
        this.idApprovalStatus = (TblApprovalStatus) idApprovalStatus;
        this.idKlaim = (TblKlaim) idKlaim;
        this.idUser = (TblUser) idUser;
    }

    public TblApproval(Object idApprovalStatusObject, Object idKlaimObject) {
        this.idApprovalStatus = (TblApprovalStatus) idApprovalStatus;
        this.idKlaim = (TblKlaim) idKlaim;
 
    }

    public TblApproval(Integer idApproval, Object idApprovalStatusObject, Object idKlaimObject) {
        this.idApproval = idApproval;
        this.idApprovalStatus = (TblApprovalStatus) idApprovalStatus;
        this.idKlaim = (TblKlaim) idKlaim;
    }

    public Integer getIdApproval() {
        return idApproval;
    }

    public void setIdApproval(Integer idApproval) {
        this.idApproval = idApproval;
    }

    public TblKlaim getIdKlaim() {
        return idKlaim;
    }

    public void setIdKlaim(TblKlaim idKlaim) {
        this.idKlaim = idKlaim;
    }

    public TblApprovalStatus getIdApprovalStatus() {
        return idApprovalStatus;
    }

    public void setIdApprovalStatus(TblApprovalStatus idApprovalStatus) {
        this.idApprovalStatus = idApprovalStatus;
    }

    public TblUser getIdUser() {
        return idUser;
    }

    public void setIdUser(TblUser idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApproval != null ? idApproval.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblApproval)) {
            return false;
        }
        TblApproval other = (TblApproval) object;
        if ((this.idApproval == null && other.idApproval != null) || (this.idApproval != null && !this.idApproval.equals(other.idApproval))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.klaim.entity.TblApproval[ idApproval=" + idApproval + " ]";
    }
    
}
