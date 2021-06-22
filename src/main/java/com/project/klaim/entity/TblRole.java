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
@Table(name = "tbl_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRole.findAll", query = "SELECT t FROM TblRole t"),
    @NamedQuery(name = "TblRole.findByIdRole", query = "SELECT t FROM TblRole t WHERE t.idRole = :idRole"),
    @NamedQuery(name = "TblRole.findByNamaRole", query = "SELECT t FROM TblRole t WHERE t.namaRole = :namaRole"),
    @NamedQuery(name = "TblRole.findByStatusRole", query = "SELECT t FROM TblRole t WHERE t.statusRole = :statusRole")})
public class TblRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_role")
    private Integer idRole;
    @Basic(optional = false)
    @Column(name = "nama_role")
    private String namaRole;
    @Basic(optional = false)
    @Column(name = "status_role")
    private boolean statusRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRole", fetch = FetchType.LAZY)
    private List<TblUser> tblUserList;

    public TblRole() {
    }

    public TblRole(Integer idRole) {
        this.idRole = idRole;
    }

    public TblRole(Integer idRole, String namaRole, boolean statusRole) {
        this.idRole = idRole;
        this.namaRole = namaRole;
        this.statusRole = statusRole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNamaRole() {
        return namaRole;
    }

    public void setNamaRole(String namaRole) {
        this.namaRole = namaRole;
    }

    public boolean getStatusRole() {
        return statusRole;
    }

    public void setStatusRole(boolean statusRole) {
        this.statusRole = statusRole;
    }

    @XmlTransient
    public List<TblUser> getTblUserList() {
        return tblUserList;
    }

    public void setTblUserList(List<TblUser> tblUserList) {
        this.tblUserList = tblUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRole)) {
            return false;
        }
        TblRole other = (TblRole) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.klaim.entity.TblRole[ idRole=" + idRole + " ]";
    }
    
}
