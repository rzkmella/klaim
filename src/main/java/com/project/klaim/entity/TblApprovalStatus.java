/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MELLA
 */
@Entity
@Table(name = "tbl_approval_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblApprovalStatus.findAll", query = "SELECT t FROM TblApprovalStatus t"),
    @NamedQuery(name = "TblApprovalStatus.findByIdApprovalStatus", query = "SELECT t FROM TblApprovalStatus t WHERE t.idApprovalStatus = :idApprovalStatus"),
    @NamedQuery(name = "TblApprovalStatus.findByNamaApprovalStatus", query = "SELECT t FROM TblApprovalStatus t WHERE t.namaApprovalStatus = :namaApprovalStatus"),
    @NamedQuery(name = "TblApprovalStatus.findByApprovalStatus", query = "SELECT t FROM TblApprovalStatus t WHERE t.approvalStatus = :approvalStatus")})
public class TblApprovalStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_approval_status")
    private Integer idApprovalStatus;
    @Basic(optional = false)
    @Column(name = "nama_approval_status")
    private String namaApprovalStatus;
    @Basic(optional = false)
    @Column(name = "approval_status")
    private boolean approvalStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApprovalStatus", fetch = FetchType.LAZY)
    private List<TblApproval> tblApprovalList;

    public TblApprovalStatus() {
    }

    public TblApprovalStatus(Integer idApprovalStatus) {
        this.idApprovalStatus = idApprovalStatus;
    }

    public TblApprovalStatus(Integer idApprovalStatus, String namaApprovalStatus, boolean approvalStatus) {
        this.idApprovalStatus = idApprovalStatus;
        this.namaApprovalStatus = namaApprovalStatus;
        this.approvalStatus = approvalStatus;
    }


    public Integer getIdApprovalStatus() {
        return idApprovalStatus;
    }

    public void setIdApprovalStatus(Integer idApprovalStatus) {
        this.idApprovalStatus = idApprovalStatus;
    }

    public String getNamaApprovalStatus() {
        return namaApprovalStatus;
    }

    public void setNamaApprovalStatus(String namaApprovalStatus) {
        this.namaApprovalStatus = namaApprovalStatus;
    }

    public boolean getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @XmlTransient
    public List<TblApproval> getTblApprovalList() {
        return tblApprovalList;
    }

    public void setTblApprovalList(List<TblApproval> tblApprovalList) {
        this.tblApprovalList = tblApprovalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApprovalStatus != null ? idApprovalStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblApprovalStatus)) {
            return false;
        }
        TblApprovalStatus other = (TblApprovalStatus) object;
        if ((this.idApprovalStatus == null && other.idApprovalStatus != null) || (this.idApprovalStatus != null && !this.idApprovalStatus.equals(other.idApprovalStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.klaim.entity.TblApprovalStatus[ idApprovalStatus=" + idApprovalStatus + " ]";
    }
    
}
