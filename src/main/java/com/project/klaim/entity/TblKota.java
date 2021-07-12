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
@Table(name = "tbl_kota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblKota.findAll", query = "SELECT t FROM TblKota t"),
    @NamedQuery(name = "TblKota.findByIdKota", query = "SELECT t FROM TblKota t WHERE t.idKota = :idKota"),
    @NamedQuery(name = "TblKota.findByNamaKota", query = "SELECT t FROM TblKota t WHERE t.namaKota = :namaKota")})
public class TblKota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_kota")
    private Integer idKota;
    @Basic(optional = false)
    @Column(name = "nama_kota")
    private String namaKota;
    @JoinColumn(name = "id_provinsi", referencedColumnName = "id_provinsi")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblProvinsi idProvinsi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKota", fetch = FetchType.LAZY)
    private List<TblKlaim> tblKlaimList;

    public TblKota() {
    }

    public TblKota(Integer idKota) {
        this.idKota = idKota;
    }

    public TblKota(Integer idKota, String namaKota) {
        this.idKota = idKota;
        this.namaKota = namaKota;
    }

    public TblKota(Integer idKota, String namaKota, Object idProvinsi) {
        this.idKota = idKota;
        this.namaKota = namaKota;
        this.idProvinsi = (TblProvinsi)idProvinsi;
    }

    public Integer getIdKota() {
        return idKota;
    }

    public void setIdKota(Integer idKota) {
        this.idKota = idKota;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public TblProvinsi getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(TblProvinsi idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    @XmlTransient
    public List<TblKlaim> getTblKlaimList() {
        return tblKlaimList;
    }

    public void setTblKlaimList(List<TblKlaim> tblKlaimList) {
        this.tblKlaimList = tblKlaimList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKota != null ? idKota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblKota)) {
            return false;
        }
        TblKota other = (TblKota) object;
        if ((this.idKota == null && other.idKota != null) || (this.idKota != null && !this.idKota.equals(other.idKota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.klaim.entity.TblKota[ idKota=" + idKota + " ]";
    }
    
}
