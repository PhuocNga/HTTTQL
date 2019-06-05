package com.cochau.model;

import javax.persistence.*;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "SANPHAM_NHAKHO", schema = "QLCHDT", catalog = "")
@IdClass(SanphamNhapkhoPK.class)
public class SanphamNhapkho {
    private String masanpham;
    private String maphieunhapkho;
    private Integer soluong;
    private Double tonggia;
    private Sanpham sanphamByMasanpham;
    private Phieunhapkho phieunhapkhoByMaphieunhapkho;

    @Id
    @Column(name = "Masanpham")
    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    @Id
    @Column(name = "Maphieunhapkho")
    public String getMaphieunhapkho() {
        return maphieunhapkho;
    }

    public void setMaphieunhapkho(String maphieunhapkho) {
        this.maphieunhapkho = maphieunhapkho;
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
    @Column(name = "Tonggia")
    public Double getTonggia() {
        return tonggia;
    }

    public void setTonggia(Double tonggia) {
        this.tonggia = tonggia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SanphamNhapkho that = (SanphamNhapkho) o;

        if (masanpham != null ? !masanpham.equals(that.masanpham) : that.masanpham != null) return false;
        if (maphieunhapkho != null ? !maphieunhapkho.equals(that.maphieunhapkho) : that.maphieunhapkho != null)
            return false;
        if (soluong != null ? !soluong.equals(that.soluong) : that.soluong != null) return false;
        if (tonggia != null ? !tonggia.equals(that.tonggia) : that.tonggia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = masanpham != null ? masanpham.hashCode() : 0;
        result = 31 * result + (maphieunhapkho != null ? maphieunhapkho.hashCode() : 0);
        result = 31 * result + (soluong != null ? soluong.hashCode() : 0);
        result = 31 * result + (tonggia != null ? tonggia.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Masanpham", referencedColumnName = "Masanpham", nullable = false,insertable = false,updatable = false)
    public Sanpham getSanphamByMasanpham() {
        return sanphamByMasanpham;
    }

    public void setSanphamByMasanpham(Sanpham sanphamByMasanpham) {
        this.sanphamByMasanpham = sanphamByMasanpham;
    }

    @ManyToOne
    @JoinColumn(name = "Maphieunhapkho", referencedColumnName = "Maphieunhapkho", nullable = false,insertable = false,updatable = false)
    public Phieunhapkho getPhieunhapkhoByMaphieunhapkho() {
        return phieunhapkhoByMaphieunhapkho;
    }

    public void setPhieunhapkhoByMaphieunhapkho(Phieunhapkho phieunhapkhoByMaphieunhapkho) {
        this.phieunhapkhoByMaphieunhapkho = phieunhapkhoByMaphieunhapkho;
    }
}
