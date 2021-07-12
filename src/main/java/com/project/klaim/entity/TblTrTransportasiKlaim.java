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
import javax.persistence.metamodel.SingularAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MELLA
 */
@Entity
@Table(name = "tbl_tr_transportasi_klaim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTrTransportasiKlaim.findAll", query = "SELECT t FROM TblTrTransportasiKlaim t"),
    @NamedQuery(name = "TblTrTransportasiKlaim.findByIdTrTransportasiKlaim", query = "SELECT t FROM TblTrTransportasiKlaim t WHERE t.idTrTransportasiKlaim = :idTrTransportasiKlaim"),
    @NamedQuery(name = "TblTrTransportasiKlaim.findByBiayaTransportasi", query = "SELECT t FROM TblTrTransportasiKlaim t WHERE t.biayaTransportasi = :biayaTransportasi"),
    @NamedQuery(name = "TblTrTransportasiKlaim.findByStatusTransportasi", query = "SELECT t FROM TblTrTransportasiKlaim t WHERE t.statusTransportasi = :statusTransportasi")})
public class TblTrTransportasiKlaim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tr_transportasi_klaim")
    private Integer idTrTransportasiKlaim;
    @Basic(optional = false)
    @Column(name = "biaya_transportasi")
    private int biayaTransportasi;
    @Basic(optional = false)
    @Column(name = "status_transportasi")
    private boolean statusTransportasi;
    @JoinColumn(name = "id_transportasi", referencedColumnName = "id_transportasi")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblTransportasi idTransportasi;
    @JoinColumn(name = "id_klaim", referencedColumnName = "id_klaim")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblKlaim idKlaim;

    public TblTrTransportasiKlaim() {
    }

    public TblTrTransportasiKlaim(Integer idTrTransportasiKlaim) {
        this.idTrTransportasiKlaim = idTrTransportasiKlaim;
    }

    public TblTrTransportasiKlaim(Integer idTrTransportasiKlaim, int biayaTransportasi, boolean statusTransportasi) {
        this.idTrTransportasiKlaim = idTrTransportasiKlaim;
        this.biayaTransportasi = biayaTransportasi;
        this.statusTransportasi = statusTransportasi;
    }
//
//    public TblTrTransportasiKlaim(Object idKlaimObject, Object idTransportasiObject, SingularAttribute<TblTrTransportasiKlaim, Integer> biayaTransportasi) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


    public TblTrTransportasiKlaim(Object idKlaimObject, Object idTransportasiObject, Integer biayaTransportasi, Boolean statusTransportasi) {
        this.biayaTransportasi = biayaTransportasi;
        this.statusTransportasi = statusTransportasi;
        this.idKlaim = (TblKlaim) idKlaim;
        this.idTransportasi = (TblTransportasi) idTransportasi;
    }


    

    public Integer getIdTrTransportasiKlaim() {
        return idTrTransportasiKlaim;
    }

    public void setIdTrTransportasiKlaim(Integer idTrTransportasiKlaim) {
        this.idTrTransportasiKlaim = idTrTransportasiKlaim;
    }

    public int getBiayaTransportasi() {
        return biayaTransportasi;
    }

    public void setBiayaTransportasi(int biayaTransportasi) {
        this.biayaTransportasi = biayaTransportasi;
    }

    public boolean getStatusTransportasi() {
        return statusTransportasi;
    }

    public void setStatusTransportasi(boolean statusTransportasi) {
        this.statusTransportasi = statusTransportasi;
    }

    public TblTransportasi getIdTransportasi() {
        return idTransportasi;
    }

    public void setIdTransportasi(TblTransportasi idTransportasi) {
        this.idTransportasi = idTransportasi;
    }

    public TblKlaim getIdKlaim() {
        return idKlaim;
    }

    public void setIdKlaim(TblKlaim idKlaim) {
        this.idKlaim = idKlaim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrTransportasiKlaim != null ? idTrTransportasiKlaim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTrTransportasiKlaim)) {
            return false;
        }
        TblTrTransportasiKlaim other = (TblTrTransportasiKlaim) object;
        if ((this.idTrTransportasiKlaim == null && other.idTrTransportasiKlaim != null) || (this.idTrTransportasiKlaim != null && !this.idTrTransportasiKlaim.equals(other.idTrTransportasiKlaim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.klaim.entity.TblTrTransportasiKlaim[ idTrTransportasiKlaim=" + idTrTransportasiKlaim + " ]";
    }
    
}
