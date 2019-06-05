package com.cochau.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "CHAMCONG_NHANVIEN", schema = "QLCHDT", catalog = "")
@IdClass(ChamcongNhanvienPK.class)
public class ChamcongNhanvien {
    private String manhanvien;
    private String matrangthai;
    private Date ngaychamcong;
    private Nhanvien nhanvienByManhanvien;
    private TinhTrangNhanVien tinhTrangNhanVienByMatrangthai;

    @Id
    @Column(name = "Manhanvien")
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Id
    @Column(name = "Matrangthai")
    public String getMatrangthai() {
        return matrangthai;
    }

    public void setMatrangthai(String matrangthai) {
        this.matrangthai = matrangthai;
    }

    @Id
    @Column(name = "Ngaychamcong")
    public Date getNgaychamcong() {
        return ngaychamcong;
    }

    public void setNgaychamcong(Date ngaychamcong) {
        this.ngaychamcong = ngaychamcong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChamcongNhanvien that = (ChamcongNhanvien) o;

        if (manhanvien != null ? !manhanvien.equals(that.manhanvien) : that.manhanvien != null) return false;
        if (matrangthai != null ? !matrangthai.equals(that.matrangthai) : that.matrangthai != null) return false;
        if (ngaychamcong != null ? !ngaychamcong.equals(that.ngaychamcong) : that.ngaychamcong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manhanvien != null ? manhanvien.hashCode() : 0;
        result = 31 * result + (matrangthai != null ? matrangthai.hashCode() : 0);
        result = 31 * result + (ngaychamcong != null ? ngaychamcong.hashCode() : 0);
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
    @JoinColumn(name = "Matrangthai", referencedColumnName = "Matrangthai", nullable = false,insertable = false,updatable = false)
    public TinhTrangNhanVien getTinhTrangNhanVienByMatrangthai() {
        return tinhTrangNhanVienByMatrangthai;
    }

    public void setTinhTrangNhanVienByMatrangthai(TinhTrangNhanVien tinhTrangNhanVienByMatrangthai) {
        this.tinhTrangNhanVienByMatrangthai = tinhTrangNhanVienByMatrangthai;
    }
}
