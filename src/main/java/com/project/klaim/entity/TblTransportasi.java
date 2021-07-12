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
    @NamedQuery(name = "TblTransportasi.findByStatusTransportasi", query = "SELECT t FROM TblTransportasi t WHERE t.statusTransportasi = :statusTransportasi")})
public class TblTransportasi implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTransportasi", fetch = FetchType.LAZY)
    private List<TblTrTransportasiKlaim> tblTrTransportasiKlaimList;

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
    @Column(name = "status_transportasi")
    private boolean statusTransportasi;

    public TblTransportasi() {
    }

    public TblTransportasi(Integer idTransportasi) {
        this.idTransportasi = idTransportasi;
    }

    public TblTransportasi(Integer idTransportasi, String namaTransportasi, boolean statusTransportasi) {
        this.idTransportasi = idTransportasi;
        this.namaTransportasi = namaTransportasi;
        this.statusTransportasi = statusTransportasi;
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

    public boolean getStatusTransportasi() {
        return statusTransportasi;
    }

    public void setStatusTransportasi(boolean statusTransportasi) {
        this.statusTransportasi = statusTransportasi;
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

    @XmlTransient
    public List<TblTrTransportasiKlaim> getTblTrTransportasiKlaimList() {
        return tblTrTransportasiKlaimList;
    }

    public void setTblTrTransportasiKlaimList(List<TblTrTransportasiKlaim> tblTrTransportasiKlaimList) {
        this.tblTrTransportasiKlaimList = tblTrTransportasiKlaimList;
    }
    
}
