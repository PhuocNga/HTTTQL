package com.cochau.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Van Huynh on 31-05-18.
 */
public class ChamcongNhanvienPK implements Serializable {
    private String manhanvien;
    private String matrangthai;
    private Date ngaychamcong;

    @Column(name = "Manhanvien")
    @Id
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Column(name = "Matrangthai")
    @Id
    public String getMatrangthai() {
        return matrangthai;
    }

    public void setMatrangthai(String matrangthai) {
        this.matrangthai = matrangthai;
    }

    @Column(name = "Ngaychamcong")
    @Id
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

        ChamcongNhanvienPK that = (ChamcongNhanvienPK) o;

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
}
