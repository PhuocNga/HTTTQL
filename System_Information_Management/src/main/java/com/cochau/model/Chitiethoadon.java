package com.cochau.model;

import javax.persistence.*;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "CHITIETHOADON", schema = "QLCHDT", catalog = "")
@IdClass(ChitiethoadonPK.class)
public class Chitiethoadon {
    private String mahoadon;
    private String masanpham;
    private Integer soluong;
    private Hoadon hoadonByMahoadon;
    private Sanpham sanphamByMasanpham;

    @Id
    @Column(name = "Mahoadon")
    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    @Id
    @Column(name = "Masanpham")
    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    @Basic
    @Column(name = "Soluong")
    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chitiethoadon that = (Chitiethoadon) o;

        if (mahoadon != null ? !mahoadon.equals(that.mahoadon) : that.mahoadon != null) return false;
        if (masanpham != null ? !masanpham.equals(that.masanpham) : that.masanpham != null) return false;
        if (soluong != null ? !soluong.equals(that.soluong) : that.soluong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mahoadon != null ? mahoadon.hashCode() : 0;
        result = 31 * result + (masanpham != null ? masanpham.hashCode() : 0);
        result = 31 * result + (soluong != null ? soluong.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Mahoadon", referencedColumnName = "Mahoadon", nullable = false,insertable = false,updatable = false)
    public Hoadon getHoadonByMahoadon() {
        return hoadonByMahoadon;
    }

    public void setHoadonByMahoadon(Hoadon hoadonByMahoadon) {
        this.hoadonByMahoadon = hoadonByMahoadon;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "Masanpham", referencedColumnName = "Masanpham", nullable = false,insertable = false,updatable = false)
    public Sanpham getSanphamByMasanpham() {
        return sanphamByMasanpham;
    }

    public void setSanphamByMasanpham(Sanpham sanphamByMasanpham) {
        this.sanphamByMasanpham = sanphamByMasanpham;
    }
}
