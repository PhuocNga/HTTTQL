package com.cochau.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "PHIEUNHAPKHO", schema = "QLCHDT", catalog = "")
public class Phieunhapkho {
    private String maphieunhapkho;
    private Date ngaynhapkho;
    private String manhanvien;
    private Integer tongsoluong;
    private Double tonggiatri;
    private Nhanvien nhanvienByManhanvien;
    private Collection<SanphamNhapkho> sanphamNhapkhosByMaphieunhapkho;

    @Id
    @Column(name = "Maphieunhapkho")
    public String getMaphieunhapkho() {
        return maphieunhapkho;
    }

    public void setMaphieunhapkho(String maphieunhapkho) {
        this.maphieunhapkho = maphieunhapkho;
    }

    @Basic
    @Column(name = "Ngaynhapkho")
    public Date getNgaynhapkho() {
        return ngaynhapkho;
    }

    public void setNgaynhapkho(Date ngaynhapkho) {
        this.ngaynhapkho = ngaynhapkho;
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
    @Column(name = "Tongsoluong")
    public Integer getTongsoluong() {
        return tongsoluong;
    }

    public void setTongsoluong(Integer tongsoluong) {
        this.tongsoluong = tongsoluong;
    }

    @Basic
    @Column(name = "Tonggiatri")
    public Double getTonggiatri() {
        return tonggiatri;
    }

    public void setTonggiatri(Double tonggiatri) {
        this.tonggiatri = tonggiatri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phieunhapkho that = (Phieunhapkho) o;

        if (maphieunhapkho != null ? !maphieunhapkho.equals(that.maphieunhapkho) : that.maphieunhapkho != null)
            return false;
        if (ngaynhapkho != null ? !ngaynhapkho.equals(that.ngaynhapkho) : that.ngaynhapkho != null) return false;
        if (manhanvien != null ? !manhanvien.equals(that.manhanvien) : that.manhanvien != null) return false;
        if (tongsoluong != null ? !tongsoluong.equals(that.tongsoluong) : that.tongsoluong != null) return false;
        if (tonggiatri != null ? !tonggiatri.equals(that.tonggiatri) : that.tonggiatri != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maphieunhapkho != null ? maphieunhapkho.hashCode() : 0;
        result = 31 * result + (ngaynhapkho != null ? ngaynhapkho.hashCode() : 0);
        result = 31 * result + (manhanvien != null ? manhanvien.hashCode() : 0);
        result = 31 * result + (tongsoluong != null ? tongsoluong.hashCode() : 0);
        result = 31 * result + (tonggiatri != null ? tonggiatri.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Manhanvien", referencedColumnName = "Manhanvien",insertable = false,updatable = false)
    public Nhanvien getNhanvienByManhanvien() {
        return nhanvienByManhanvien;
    }

    public void setNhanvienByManhanvien(Nhanvien nhanvienByManhanvien) {
        this.nhanvienByManhanvien = nhanvienByManhanvien;
    }

    @OneToMany(mappedBy = "phieunhapkhoByMaphieunhapkho",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<SanphamNhapkho> getSanphamNhapkhosByMaphieunhapkho() {
        return sanphamNhapkhosByMaphieunhapkho;
    }

    public void setSanphamNhapkhosByMaphieunhapkho(Collection<SanphamNhapkho> sanphamNhapkhosByMaphieunhapkho) {
        this.sanphamNhapkhosByMaphieunhapkho = sanphamNhapkhosByMaphieunhapkho;
    }
}
