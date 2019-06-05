package com.cochau.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "HOADON", schema = "QLCHDT", catalog = "")
public class Hoadon {
    private String mahoadon;
    private Date ngaylaphoadon;
    private String manhanvien;
    private Double tongtien;
    private Integer tongsoluong;
    private String makhachhang;
    private Boolean isExits;
    private Collection<Chitiethoadon> chitiethoadonsByMahoadon;
    private Nhanvien nhanvienByManhanvien;
    private Khachhang khachhangByMakhachhang;

    @Id
    @Column(name = "Mahoadon")
    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    @Column
    @Temporal(TemporalType.DATE)
    public Date getNgaylaphoadon() {
        return ngaylaphoadon;
    }

    public void setNgaylaphoadon(Date ngaylaphoadon) {
        this.ngaylaphoadon = ngaylaphoadon;
    }

    @Basic
    @Column(name = "Manhanvien")
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Basic
    @Column(name = "Tongtien")
    public Double getTongtien() {
        return tongtien;
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }

    @Basic
    @Column(name = "Tongsoluong")
    public Integer getTongsoluong() {
        return tongsoluong;
    }

    public void setTongsoluong(Integer tongsoluong) {
        this.tongsoluong = tongsoluong;
    }

    @Basic
    @Column(name = "Makhachhang")
    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    @Basic
    @Column(name = "isExits")
    public Boolean getExits() {
        return isExits;
    }

    public void setExits(Boolean exits) {
        isExits = exits;
    }


    @OneToMany(mappedBy = "hoadonByMahoadon",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    public Collection<Chitiethoadon> getChitiethoadonsByMahoadon() {
        return chitiethoadonsByMahoadon;
    }

    public void setChitiethoadonsByMahoadon(Collection<Chitiethoadon> chitiethoadonsByMahoadon) {
        this.chitiethoadonsByMahoadon = chitiethoadonsByMahoadon;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "Manhanvien", referencedColumnName = "Manhanvien",insertable = false,updatable = false)
    public Nhanvien getNhanvienByManhanvien() {
        return nhanvienByManhanvien;
    }

    public void setNhanvienByManhanvien(Nhanvien nhanvienByManhanvien) {
        this.nhanvienByManhanvien = nhanvienByManhanvien;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "Makhachhang", referencedColumnName = "Makhachhang",insertable = false,updatable = false)
    public Khachhang getKhachhangByMakhachhang() {
        return khachhangByMakhachhang;
    }

    public void setKhachhangByMakhachhang(Khachhang khachhangByMakhachhang) {
        this.khachhangByMakhachhang = khachhangByMakhachhang;
    }
}
