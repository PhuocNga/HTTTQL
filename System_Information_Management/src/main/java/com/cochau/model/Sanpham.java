package com.cochau.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "SANPHAM", schema = "QLCHDT", catalog = "")
public class Sanpham {
    private String masanpham;
    private String tensanpham;
    private Integer soluong;
    private String mausac;
    private String camaratruoc;
    private String camarasau;
    private String bonho;
    private String hedieuhanh;
    private String pin;
    private Double giaNhap;
    private Double giaban;
    private String thoigianbaohanh;
    private String manhacungcap;
    private Boolean isExit;
    private Collection<Chitiethoadon> chitiethoadonsByMasanpham;
    private Collection<DuyethangSanpham> duyethangSanphamsByMasanpham;
    private Nhacungcap nhacungcapByManhacungcap;
    private Collection<SanphamNhapkho> sanphamNhapkhosByMasanpham;

    @Id
    @Column(name = "Masanpham")
    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    @Basic
    @Column(name = "Tensanpham")
    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    @Basic
    @Column(name = "Soluong")
    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    @Basic
    @Column(name = "Mausac")
    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    @Basic
    @Column(name = "Camaratruoc")
    public String getCamaratruoc() {
        return camaratruoc;
    }

    public void setCamaratruoc(String camaratruoc) {
        this.camaratruoc = camaratruoc;
    }

    @Basic
    @Column(name = "Camarasau")
    public String getCamarasau() {
        return camarasau;
    }

    public void setCamarasau(String camarasau) {
        this.camarasau = camarasau;
    }

    @Basic
    @Column(name = "Bonho")
    public String getBonho() {
        return bonho;
    }

    public void setBonho(String bonho) {
        this.bonho = bonho;
    }

    @Basic
    @Column(name = "Hedieuhanh")
    public String getHedieuhanh() {
        return hedieuhanh;
    }

    public void setHedieuhanh(String hedieuhanh) {
        this.hedieuhanh = hedieuhanh;
    }

    @Basic
    @Column(name = "Pin")
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Basic
    @Column(name = "GiaNhap")
    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    @Basic
    @Column(name = "Giaban")
    public Double getGiaban() {
        return giaban;
    }

    public void setGiaban(Double giaban) {
        this.giaban = giaban;
    }

    @Basic
    @Column(name = "Thoigianbaohanh")
    public String getThoigianbaohanh() {
        return thoigianbaohanh;
    }

    public void setThoigianbaohanh(String thoigianbaohanh) {
        this.thoigianbaohanh = thoigianbaohanh;
    }

    @Basic
    @Column(name = "Manhacungcap")
    public String getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    @Basic
    @Column(name = "IsExit")
    public Boolean getExit() {
        return isExit;
    }

    public void setExit(Boolean exit) {
        isExit = exit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sanpham sanpham = (Sanpham) o;

        if (masanpham != null ? !masanpham.equals(sanpham.masanpham) : sanpham.masanpham != null) return false;
        if (tensanpham != null ? !tensanpham.equals(sanpham.tensanpham) : sanpham.tensanpham != null) return false;
        if (soluong != null ? !soluong.equals(sanpham.soluong) : sanpham.soluong != null) return false;
        if (mausac != null ? !mausac.equals(sanpham.mausac) : sanpham.mausac != null) return false;
        if (camaratruoc != null ? !camaratruoc.equals(sanpham.camaratruoc) : sanpham.camaratruoc != null) return false;
        if (camarasau != null ? !camarasau.equals(sanpham.camarasau) : sanpham.camarasau != null) return false;
        if (bonho != null ? !bonho.equals(sanpham.bonho) : sanpham.bonho != null) return false;
        if (hedieuhanh != null ? !hedieuhanh.equals(sanpham.hedieuhanh) : sanpham.hedieuhanh != null) return false;
        if (pin != null ? !pin.equals(sanpham.pin) : sanpham.pin != null) return false;
        if (giaNhap != null ? !giaNhap.equals(sanpham.giaNhap) : sanpham.giaNhap != null) return false;
        if (giaban != null ? !giaban.equals(sanpham.giaban) : sanpham.giaban != null) return false;
        if (thoigianbaohanh != null ? !thoigianbaohanh.equals(sanpham.thoigianbaohanh) : sanpham.thoigianbaohanh != null)
            return false;
        if (manhacungcap != null ? !manhacungcap.equals(sanpham.manhacungcap) : sanpham.manhacungcap != null)
            return false;
        if (isExit != null ? !isExit.equals(sanpham.isExit) : sanpham.isExit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = masanpham != null ? masanpham.hashCode() : 0;
        result = 31 * result + (tensanpham != null ? tensanpham.hashCode() : 0);
        result = 31 * result + (soluong != null ? soluong.hashCode() : 0);
        result = 31 * result + (mausac != null ? mausac.hashCode() : 0);
        result = 31 * result + (camaratruoc != null ? camaratruoc.hashCode() : 0);
        result = 31 * result + (camarasau != null ? camarasau.hashCode() : 0);
        result = 31 * result + (bonho != null ? bonho.hashCode() : 0);
        result = 31 * result + (hedieuhanh != null ? hedieuhanh.hashCode() : 0);
        result = 31 * result + (pin != null ? pin.hashCode() : 0);
        result = 31 * result + (giaNhap != null ? giaNhap.hashCode() : 0);
        result = 31 * result + (giaban != null ? giaban.hashCode() : 0);
        result = 31 * result + (thoigianbaohanh != null ? thoigianbaohanh.hashCode() : 0);
        result = 31 * result + (manhacungcap != null ? manhacungcap.hashCode() : 0);
        result = 31 * result + (isExit != null ? isExit.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "sanphamByMasanpham",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Chitiethoadon> getChitiethoadonsByMasanpham() {
        return chitiethoadonsByMasanpham;
    }

    public void setChitiethoadonsByMasanpham(Collection<Chitiethoadon> chitiethoadonsByMasanpham) {
        this.chitiethoadonsByMasanpham = chitiethoadonsByMasanpham;
    }

    @OneToMany(mappedBy = "sanphamByMasanpham",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<DuyethangSanpham> getDuyethangSanphamsByMasanpham() {
        return duyethangSanphamsByMasanpham;
    }

    public void setDuyethangSanphamsByMasanpham(Collection<DuyethangSanpham> duyethangSanphamsByMasanpham) {
        this.duyethangSanphamsByMasanpham = duyethangSanphamsByMasanpham;
    }

    @ManyToOne
    @JoinColumn(name = "Manhacungcap", referencedColumnName = "Manhacungcap",insertable = false,updatable = false)
    public Nhacungcap getNhacungcapByManhacungcap() {
        return nhacungcapByManhacungcap;
    }

    public void setNhacungcapByManhacungcap(Nhacungcap nhacungcapByManhacungcap) {
        this.nhacungcapByManhacungcap = nhacungcapByManhacungcap;
    }

    @OneToMany(mappedBy = "sanphamByMasanpham",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<SanphamNhapkho> getSanphamNhapkhosByMasanpham() {
        return sanphamNhapkhosByMasanpham;
    }

    public void setSanphamNhapkhosByMasanpham(Collection<SanphamNhapkho> sanphamNhapkhosByMasanpham) {
        this.sanphamNhapkhosByMasanpham = sanphamNhapkhosByMasanpham;
    }
}
