package com.cochau.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "KHENTHUONG_NHANVIEN", schema = "QLCHDT", catalog = "")
@IdClass(KhenthuongNhanvienPK.class)
public class KhenthuongNhanvien {
    private String manhanvien;
    private String makhenthuong;
    private Date ngaykhenthuong;
    private Nhanvien nhanvienByManhanvien;
    private Khenthuong khenthuongByMakhenthuong;

    @Id
    @Column(name = "Manhanvien")
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Id
    @Column(name = "Makhenthuong")
    public String getMakhenthuong() {
        return makhenthuong;
    }

    public void setMakhenthuong(String makhenthuong) {
        this.makhenthuong = makhenthuong;
    }

    @Basic
    @Column(name = "Ngaykhenthuong")
    public Date getNgaykhenthuong() {
        return ngaykhenthuong;
    }

    public void setNgaykhenthuong(Date ngaykhenthuong) {
        this.ngaykhenthuong = ngaykhenthuong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KhenthuongNhanvien that = (KhenthuongNhanvien) o;

        if (manhanvien != null ? !manhanvien.equals(that.manhanvien) : that.manhanvien != null) return false;
        if (makhenthuong != null ? !makhenthuong.equals(that.makhenthuong) : that.makhenthuong != null) return false;
        if (ngaykhenthuong != null ? !ngaykhenthuong.equals(that.ngaykhenthuong) : that.ngaykhenthuong != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manhanvien != null ? manhanvien.hashCode() : 0;
        result = 31 * result + (makhenthuong != null ? makhenthuong.hashCode() : 0);
        result = 31 * result + (ngaykhenthuong != null ? ngaykhenthuong.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Manhanvien", referencedColumnName = "Manhanvien", nullable = false,insertable = false,updatable = false)
    public Nhanvien getNhanvienByManhanvien() {
        return nhanvienByManhanvien;
    }

    public void setNhanvienByManhanvien(Nhanvien nhanvienByManhanvien) {
        this.nhanvienByManhanvien = nhanvienByManhanvien;
    }

    @ManyToOne
    @JoinColumn(name = "Makhenthuong", referencedColumnName = "Makhenthuong", nullable = false,insertable = false,updatable = false)
    public Khenthuong getKhenthuongByMakhenthuong() {
        return khenthuongByMakhenthuong;
    }

    public void setKhenthuongByMakhenthuong(Khenthuong khenthuongByMakhenthuong) {
        this.khenthuongByMakhenthuong = khenthuongByMakhenthuong;
    }
}
