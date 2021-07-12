/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MELLA
 */
@Entity
@Table(name = "tbl_klaim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblKlaim.findAll", query = "SELECT t FROM TblKlaim t"),
    @NamedQuery(name = "TblKlaim.findByIdKlaim", query = "SELECT t FROM TblKlaim t WHERE t.idKlaim = :idKlaim"),
    @NamedQuery(name = "TblKlaim.findByTglKlaim", query = "SELECT t FROM TblKlaim t WHERE t.tglKlaim = :tglKlaim"),
    @NamedQuery(name = "TblKlaim.findByTglMulaiDinasKlaim", query = "SELECT t FROM TblKlaim t WHERE t.tglMulaiDinasKlaim = :tglMulaiDinasKlaim"),
    @NamedQuery(name = "TblKlaim.findByTglAkhirDinasKlaim", query = "SELECT t FROM TblKlaim t WHERE t.tglAkhirDinasKlaim = :tglAkhirDinasKlaim"),
    @NamedQuery(name = "TblKlaim.findByKegiatanDinasKlaim", query = "SELECT t FROM TblKlaim t WHERE t.kegiatanDinasKlaim = :kegiatanDinasKlaim"),
    @NamedQuery(name = "TblKlaim.findByHotelKlaim", query = "SELECT t FROM TblKlaim t WHERE t.hotelKlaim = :hotelKlaim"),
    @NamedQuery(name = "TblKlaim.findByBiayaHotelKlaim", query = "SELECT t FROM TblKlaim t WHERE t.biayaHotelKlaim = :biayaHotelKlaim"),
    @NamedQuery(name = "TblKlaim.findByBiayaKonsumsiKlaim", query = "SELECT t FROM TblKlaim t WHERE t.biayaKonsumsiKlaim = :biayaKonsumsiKlaim"),
    @NamedQuery(name = "TblKlaim.findByTotalTransportasi", query = "SELECT t FROM TblKlaim t WHERE t.totalTransportasi = :totalTransportasi"),
    @NamedQuery(name = "TblKlaim.findByTotalKlaim", query = "SELECT t FROM TblKlaim t WHERE t.totalKlaim = :totalKlaim")})
public class TblKlaim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_klaim")
    private Integer idKlaim;
    @Basic(optional = false)
    @Column(name = "tgl_klaim")
    @Temporal(TemporalType.DATE)
    private Date tglKlaim;
    @Basic(optional = false)
    @Column(name = "tgl_mulai_dinas_klaim")
    @Temporal(TemporalType.DATE)
    private Date tglMulaiDinasKlaim;
    @Basic(optional = false)
    @Column(name = "tgl_akhir_dinas_klaim")
    @Temporal(TemporalType.DATE)
    private Date tglAkhirDinasKlaim;
    @Basic(optional = false)
    @Column(name = "kegiatan_dinas_klaim")
    private String kegiatanDinasKlaim;
    @Basic(optional = false)
    @Column(name = "hotel_klaim")
    private String hotelKlaim;
    @Basic(optional = false)
    @Column(name = "biaya_hotel_klaim")
    private int biayaHotelKlaim;
    @Basic(optional = false)
    @Column(name = "biaya_konsumsi_klaim")
    private int biayaKonsumsiKlaim;
    @Basic(optional = false)
    @Column(name = "total_transportasi")
    private int totalTransportasi;
    @Basic(optional = false)
    @Column(name = "total_klaim")
    private int totalKlaim;
    @Basic(optional = false)
    @Lob
    @Column(name = "nota_hotel_klaim")
    private byte[] notaHotelKlaim;
    @Basic(optional = false)
    @Lob
    @Column(name = "nota_transportasi_klaim")
    private byte[] notaTransportasiKlaim;
    @Basic(optional = false)
    @Lob
    @Column(name = "nota_konsumsi_klaim")
    private byte[] notaKonsumsiKlaim;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblUser idUser;
    @JoinColumn(name = "id_kota", referencedColumnName = "id_kota")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblKota idKota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKlaim", fetch = FetchType.LAZY)
    private List<TblTrTransportasiKlaim> tblTrTransportasiKlaimList;

    public TblKlaim() {
    }

    public TblKlaim(Integer idKlaim) {
        this.idKlaim = idKlaim;
    }

    public TblKlaim(Integer idKlaim, Date tglKlaim, Date tglMulaiDinasKlaim, Date tglAkhirDinasKlaim, String kegiatanDinasKlaim, String hotelKlaim, int biayaHotelKlaim, int biayaKonsumsiKlaim, int totalTransportasi, int totalKlaim, byte[] notaHotelKlaim, byte[] notaTransportasiKlaim, byte[] notaKonsumsiKlaim) {
        this.idKlaim = idKlaim;
        this.tglKlaim = tglKlaim;
        this.tglMulaiDinasKlaim = tglMulaiDinasKlaim;
        this.tglAkhirDinasKlaim = tglAkhirDinasKlaim;
        this.kegiatanDinasKlaim = kegiatanDinasKlaim;
        this.hotelKlaim = hotelKlaim;
        this.biayaHotelKlaim = biayaHotelKlaim;
        this.biayaKonsumsiKlaim = biayaKonsumsiKlaim;
        this.totalTransportasi = totalTransportasi;
        this.totalKlaim = totalKlaim;
        this.notaHotelKlaim = notaHotelKlaim;
        this.notaTransportasiKlaim = notaTransportasiKlaim;
        this.notaKonsumsiKlaim = notaKonsumsiKlaim;
    }

    public TblKlaim(Integer idKlaim, Date tglKlaim, Date tglMulaiDinasKlaim, Date tglAkhirDinasKlaim, String kegiatanDinasKlaim, String hotelKlaim, Integer biayaHotelKlaim, Integer biayaKonsumsiKlaim, Integer totalTransportasi, Integer totalKlaim, byte[] notaHotelKlaim, byte[] notaTransportasiKlaim, byte[] notaKonsumsiKlaim, Object idUserObject, Object idKotaObject) {
        this.idKlaim = idKlaim;
        this.tglKlaim = tglKlaim;
        this.tglMulaiDinasKlaim = tglMulaiDinasKlaim;
        this.tglAkhirDinasKlaim = tglAkhirDinasKlaim;
        this.kegiatanDinasKlaim = kegiatanDinasKlaim;
        this.hotelKlaim = hotelKlaim;
        this.biayaHotelKlaim = biayaHotelKlaim;
        this.biayaKonsumsiKlaim = biayaKonsumsiKlaim;
        this.totalTransportasi = totalTransportasi;
        this.totalKlaim = totalKlaim;
        this.notaHotelKlaim = notaHotelKlaim;
        this.notaTransportasiKlaim = notaTransportasiKlaim;
        this.notaKonsumsiKlaim = notaKonsumsiKlaim;
        this.idUser = (TblUser) idUser;
        this.idKota = (TblKota) idKota;
    }

   

//    public TblKlaim(Integer idKlaim, Date tglKlaim, Date tglMulaiDinasKlaim, Date tglAkhirDinasKlaim, String kegiatanDinasKlaim, String hotelKlaim, Integer biayaHotelKlaim, Integer biayaKonsumsiKlaim, Integer totalTransportasi, Integer totalKlaim, MultipartFile notaHotelKlaim, MultipartFile notaTransportasiKlaim, MultipartFile notaKonsumsiKlaim, Object idUserObject, Object idKotaObject) {
//        his.idKlaim = idKlaim;
//        this.tglKlaim = tglKlaim;
//        this.tglMulaiDinasKlaim = tglMulaiDinasKlaim;
//        this.tglAkhirDinasKlaim = tglAkhirDinasKlaim;
//        this.kegiatanDinasKlaim = kegiatanDinasKlaim;
//        this.hotelKlaim = hotelKlaim;
//        this.biayaHotelKlaim = biayaHotelKlaim;
//        this.biayaKonsumsiKlaim = biayaKonsumsiKlaim;
//        this.totalTransportasi = totalTransportasi;
//        this.totalKlaim = totalKlaim;
//        this.notaHotelKlaim = notaHotelKlaim;
//        this.notaTransportasiKlaim = notaTransportasiKlaim;
//        this.notaKonsumsiKlaim = notaKonsumsiKlaim;
//        this.idUser = (TblUser) idUser;
//        this.idKota = (TblKota) idKota;this.idKlaim = idKlaim;
//        this.tglKlaim = tglKlaim;
//        this.tglMulaiDinasKlaim = tglMulaiDinasKlaim;
//        this.tglAkhirDinasKlaim = tglAkhirDinasKlaim;
//        this.kegiatanDinasKlaim = kegiatanDinasKlaim;
//        this.hotelKlaim = hotelKlaim;
//        this.biayaHotelKlaim = biayaHotelKlaim;
//        this.biayaKonsumsiKlaim = biayaKonsumsiKlaim;
//        this.totalTransportasi = totalTransportasi;
//        this.totalKlaim = totalKlaim;
//        this.notaHotelKlaim = notaHotelKlaim;
//        this.notaTransportasiKlaim = notaTransportasiKlaim;
//        this.notaKonsumsiKlaim = notaKonsumsiKlaim;
//        this.idUser = (TblUser) idUser;
//        this.idKota = (TblKota) idKota;
//    }

    public Integer getIdKlaim() {
        return idKlaim;
    }

    public void setIdKlaim(Integer idKlaim) {
        this.idKlaim = idKlaim;
    }

    public Date getTglKlaim() {
        return tglKlaim;
    }

    public void setTglKlaim(Date tglKlaim) {
        this.tglKlaim = tglKlaim;
    }

    public Date getTglMulaiDinasKlaim() {
        return tglMulaiDinasKlaim;
    }

    public void setTglMulaiDinasKlaim(Date tglMulaiDinasKlaim) {
        this.tglMulaiDinasKlaim = tglMulaiDinasKlaim;
    }

    public Date getTglAkhirDinasKlaim() {
        return tglAkhirDinasKlaim;
    }

    public void setTglAkhirDinasKlaim(Date tglAkhirDinasKlaim) {
        this.tglAkhirDinasKlaim = tglAkhirDinasKlaim;
    }

    public String getKegiatanDinasKlaim() {
        return kegiatanDinasKlaim;
    }

    public void setKegiatanDinasKlaim(String kegiatanDinasKlaim) {
        this.kegiatanDinasKlaim = kegiatanDinasKlaim;
    }

    public String getHotelKlaim() {
        return hotelKlaim;
    }

    public void setHotelKlaim(String hotelKlaim) {
        this.hotelKlaim = hotelKlaim;
    }

    public int getBiayaHotelKlaim() {
        return biayaHotelKlaim;
    }

    public void setBiayaHotelKlaim(int biayaHotelKlaim) {
        this.biayaHotelKlaim = biayaHotelKlaim;
    }

    public int getBiayaKonsumsiKlaim() {
        return biayaKonsumsiKlaim;
    }

    public void setBiayaKonsumsiKlaim(int biayaKonsumsiKlaim) {
        this.biayaKonsumsiKlaim = biayaKonsumsiKlaim;
    }

    public int getTotalTransportasi() {
        return totalTransportasi;
    }

    public void setTotalTransportasi(int totalTransportasi) {
        this.totalTransportasi = totalTransportasi;
    }

    public int getTotalKlaim() {
        return totalKlaim;
    }

    public void setTotalKlaim(int totalKlaim) {
        this.totalKlaim = totalKlaim;
    }

    public byte[] getNotaHotelKlaim() {
        return notaHotelKlaim;
    }

    public void setNotaHotelKlaim(byte[] notaHotelKlaim) {
        this.notaHotelKlaim = notaHotelKlaim;
    }

    public byte[] getNotaTransportasiKlaim() {
        return notaTransportasiKlaim;
    }

    public void setNotaTransportasiKlaim(byte[] notaTransportasiKlaim) {
        this.notaTransportasiKlaim = notaTransportasiKlaim;
    }

    public byte[] getNotaKonsumsiKlaim() {
        return notaKonsumsiKlaim;
    }

    public void setNotaKonsumsiKlaim(byte[] notaKonsumsiKlaim) {
        this.notaKonsumsiKlaim = notaKonsumsiKlaim;
    }

    public TblUser getIdUser() {
        return idUser;
    }

    public void setIdUser(TblUser idUser) {
        this.idUser = idUser;
    }

    public TblKota getIdKota() {
        return idKota;
    }

    public void setIdKota(TblKota idKota) {
        this.idKota = idKota;
    }

    @XmlTransient
    public List<TblTrTransportasiKlaim> getTblTrTransportasiKlaimList() {
        return tblTrTransportasiKlaimList;
    }

    public void setTblTrTransportasiKlaimList(List<TblTrTransportasiKlaim> tblTrTransportasiKlaimList) {
        this.tblTrTransportasiKlaimList = tblTrTransportasiKlaimList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKlaim != null ? idKlaim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblKlaim)) {
            return false;
        }
        TblKlaim other = (TblKlaim) object;
        if ((this.idKlaim == null && other.idKlaim != null) || (this.idKlaim != null && !this.idKlaim.equals(other.idKlaim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.klaim.entity.TblKlaim[ idKlaim=" + idKlaim + " ]";
    }
    
}
