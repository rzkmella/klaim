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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUser.findAll", query = "SELECT t FROM TblUser t"),
    @NamedQuery(name = "TblUser.findByIdUser", query = "SELECT t FROM TblUser t WHERE t.idUser = :idUser"),
    @NamedQuery(name = "TblUser.findByNamaLengkapUser", query = "SELECT t FROM TblUser t WHERE t.namaLengkapUser = :namaLengkapUser"),
    @NamedQuery(name = "TblUser.findByEmailUser", query = "SELECT t FROM TblUser t WHERE t.emailUser = :emailUser"),
    @NamedQuery(name = "TblUser.findByPasswordUser", query = "SELECT t FROM TblUser t WHERE t.passwordUser = :passwordUser"),
    @NamedQuery(name = "TblUser.findByNoRekeningUser", query = "SELECT t FROM TblUser t WHERE t.noRekeningUser = :noRekeningUser"),
    @NamedQuery(name = "TblUser.findByStatusUser", query = "SELECT t FROM TblUser t WHERE t.statusUser = :statusUser"),
    @NamedQuery(name = "TblUser.findByToken", query = "SELECT t FROM TblUser t WHERE t.token = :token")})
public class TblUser implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser", fetch = FetchType.LAZY)
    private List<TblKlaim> tblKlaimList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Basic(optional = false)
    @Column(name = "nama_lengkap_user")
    private String namaLengkapUser;
    @Basic(optional = false)
    @Column(name = "email_user")
    private String emailUser;
    @Basic(optional = false)
    @Column(name = "password_user")
    private String passwordUser;
    @Basic(optional = false)
    @Column(name = "no_rekening_user")
    private String noRekeningUser;
    @Basic(optional = false)
    @Column(name = "status_user")
    private boolean statusUser;
    @Column(name = "token")
    private String token;
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblRole idRole;

    public TblUser() {
    }

    public TblUser(Integer idUser) {
        this.idUser = idUser;
    }

    public TblUser(Integer idUser, String namaLengkapUser, String emailUser, String passwordUser, String noRekeningUser, boolean statusUser) {
        this.idUser = idUser;
        this.namaLengkapUser = namaLengkapUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.noRekeningUser = noRekeningUser;
        this.statusUser = statusUser;
    }

    public TblUser(Integer idUser, String namaLengkapUser, String emailUser, String passwordUser, String noRekeningUser, boolean statusUser, Object idRoleObject) {
        this.idUser = idUser;
        this.namaLengkapUser = namaLengkapUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.noRekeningUser = noRekeningUser;
        this.statusUser = statusUser;
        this.idRole = (TblRole) idRole;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNamaLengkapUser() {
        return namaLengkapUser;
    }

    public void setNamaLengkapUser(String namaLengkapUser) {
        this.namaLengkapUser = namaLengkapUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getNoRekeningUser() {
        return noRekeningUser;
    }

    public void setNoRekeningUser(String noRekeningUser) {
        this.noRekeningUser = noRekeningUser;
    }

    public boolean getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(boolean statusUser) {
        this.statusUser = statusUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TblRole getIdRole() {
        return idRole;
    }

    public void setIdRole(TblRole idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUser)) {
            return false;
        }
        TblUser other = (TblUser) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.klaim.entity.TblUser[ idUser=" + idUser + " ]";
    }

    @XmlTransient
    public List<TblKlaim> getTblKlaimList() {
        return tblKlaimList;
    }

    public void setTblKlaimList(List<TblKlaim> tblKlaimList) {
        this.tblKlaimList = tblKlaimList;
    }

}
