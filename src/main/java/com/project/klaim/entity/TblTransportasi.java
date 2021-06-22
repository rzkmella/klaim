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
@Table(name = "tbl_transportasi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTransportasi.findAll", query = "SELECT t FROM TblTransportasi t"),
    @NamedQuery(name = "TblTransportasi.findByIdTransportasi", query = "SELECT t FROM TblTransportasi t WHERE t.idTransportasi = :idTransportasi"),
    @NamedQuery(name = "TblTransportasi.findByNamaTransportasi", query = "SELECT t FROM TblTransportasi t WHERE t.namaTransportasi = :namaTransportasi"),
    @NamedQuery(name = "TblTransportasi.findByBiayaTransportasi", query = "SELECT t FROM TblTransportasi t WHERE t.biayaTransportasi = :biayaTransportasi")})
public class TblTransportasi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transportasi")
    private Integer idTransportasi;
    @Basic(optional = false)
    @Column(name = "nama_transportasi")
    private String namaTransportasi;
    @Basic(optional = false)
    @Column(name = "biaya_transportasi")
    private int biayaTransportasi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTransportasi", fetch = FetchType.LAZY)
    private List<TblKlaim> tblKlaimList;

    public TblTransportasi() {
    }

    public TblTransportasi(Integer idTransportasi) {
        this.idTransportasi = idTransportasi;
    }

    public TblTransportasi(Integer idTransportasi, String namaTransportasi, int biayaTransportasi) {
        this.idTransportasi = idTransportasi;
        this.namaTransportasi = namaTransportasi;
        this.biayaTransportasi = biayaTransportasi;
    }

    public Integer getIdTransportasi() {
        return idTransportasi;
    }

    public void setIdTransportasi(Integer idTransportasi) {
        this.idTransportasi = idTransportasi;
    }

    public String getNamaTransportasi() {
        return namaTransportasi;
    }

    public void setNamaTransportasi(String namaTransportasi) {
        this.namaTransportasi = namaTransportasi;
    }

    public int getBiayaTransportasi() {
        return biayaTransportasi;
    }

    public void setBiayaTransportasi(int biayaTransportasi) {
        this.biayaTransportasi = biayaTransportasi;
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
        hash += (idTransportasi != null ? idTransportasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTransportasi)) {
            return false;
        }
        TblTransportasi other = (TblTransportasi) object;
        if ((this.idTransportasi == null && other.idTransportasi != null) || (this.idTransportasi != null && !this.idTransportasi.equals(other.idTransportasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.klaim.entity.TblTransportasi[ idTransportasi=" + idTransportasi + " ]";
    }
    
}
