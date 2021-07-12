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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MELLA
 */
@Entity
@Table(name = "tbl_provinsi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProvinsi.findAll", query = "SELECT t FROM TblProvinsi t"),
    @NamedQuery(name = "TblProvinsi.findByIdProvinsi", query = "SELECT t FROM TblProvinsi t WHERE t.idProvinsi = :idProvinsi"),
    @NamedQuery(name = "TblProvinsi.findByNamaProvinsi", query = "SELECT t FROM TblProvinsi t WHERE t.namaProvinsi = :namaProvinsi")})
public class TblProvinsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_provinsi")
    private Integer idProvinsi;
    @Basic(optional = false)
    @Column(name = "nama_provinsi")
    private String namaProvinsi;

    public TblProvinsi() {
    }

    public TblProvinsi(Integer idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public TblProvinsi(Integer idProvinsi, String namaProvinsi) {
        this.idProvinsi = idProvinsi;
        this.namaProvinsi = namaProvinsi;
    }

    public Integer getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(Integer idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvinsi != null ? idProvinsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProvinsi)) {
            return false;
        }
        TblProvinsi other = (TblProvinsi) object;
        if ((this.idProvinsi == null && other.idProvinsi != null) || (this.idProvinsi != null && !this.idProvinsi.equals(other.idProvinsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.klaim.entity.TblProvinsi[ idProvinsi=" + idProvinsi + " ]";
    }
    
}
