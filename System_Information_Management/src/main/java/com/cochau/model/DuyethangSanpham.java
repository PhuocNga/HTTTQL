package com.cochau.model;

import javax.persistence.*;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "DUYETHANG_SANPHAM", schema = "QLCHDT", catalog = "")
@IdClass(DuyethangSanphamPK.class)
public class DuyethangSanpham {
    private String masanpham;
    private String madonduyethang;
    private Integer soluong;
    private Sanpham sanphamByMasanpham;
    private Donduyethang donduyethangByMadonduyethang;

    @Id
    @Column(name = "Masanpham")
    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    @Id
    @Column(name = "Madonduyethang")
    public String getMadonduyethang() {
        return madonduyethang;
    }

    public void setMadonduyethang(String madonduyethang) {
        this.madonduyethang = madonduyethang;
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

        DuyethangSanpham that = (DuyethangSanpham) o;

        if (masanpham != null ? !masanpham.equals(that.masanpham) : that.masanpham != null) return false;
        if (madonduyethang != null ? !madonduyethang.equals(that.madonduyethang) : that.madonduyethang != null)
            return false;
        if (soluong != null ? !soluong.equals(that.soluong) : that.soluong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = masanpham != null ? masanpham.hashCode() : 0;
        result = 31 * result + (madonduyethang != null ? madonduyethang.hashCode() : 0);
        result = 31 * result + (soluong != null ? soluong.hashCode() : 0);
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
    @JoinColumn(name = "Madonduyethang", referencedColumnName = "Madonduyethang", nullable = false,insertable = false,updatable = false)
    public Donduyethang getDonduyethangByMadonduyethang() {
        return donduyethangByMadonduyethang;
    }

    public void setDonduyethangByMadonduyethang(Donduyethang donduyethangByMadonduyethang) {
        this.donduyethangByMadonduyethang = donduyethangByMadonduyethang;
    }
}
