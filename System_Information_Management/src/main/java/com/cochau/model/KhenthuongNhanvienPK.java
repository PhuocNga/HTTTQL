package com.cochau.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Van Huynh on 31-05-18.
 */
public class KhenthuongNhanvienPK implements Serializable {
    private String manhanvien;
    private String makhenthuong;

    @Column(name = "Manhanvien")
    @Id
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Column(name = "Makhenthuong")
    @Id
    public String getMakhenthuong() {
        return makhenthuong;
    }

    public void setMakhenthuong(String makhenthuong) {
        this.makhenthuong = makhenthuong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KhenthuongNhanvienPK that = (KhenthuongNhanvienPK) o;

        if (manhanvien != null ? !manhanvien.equals(that.manhanvien) : that.manhanvien != null) return false;
        if (makhenthuong != null ? !makhenthuong.equals(that.makhenthuong) : that.makhenthuong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manhanvien != null ? manhanvien.hashCode() : 0;
        result = 31 * result + (makhenthuong != null ? makhenthuong.hashCode() : 0);
        return result;
    }
}
