package com.cochau.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "KHENTHUONG", schema = "QLCHDT", catalog = "")
public class Khenthuong {
    private String makhenthuong;
    private String tenkhenthuong;
    private String lydokhenthuong;
    private String hinhthuckhenthuong;
    private Collection<KhenthuongNhanvien> khenthuongNhanviensByMakhenthuong;

    @Id
    @Column(name = "Makhenthuong")
    public String getMakhenthuong() {
        return makhenthuong;
    }

    public void setMakhenthuong(String makhenthuong) {
        this.makhenthuong = makhenthuong;
    }

    @Basic
    @Column(name = "Tenkhenthuong")
    public String getTenkhenthuong() {
        return tenkhenthuong;
    }

    public void setTenkhenthuong(String tenkhenthuong) {
        this.tenkhenthuong = tenkhenthuong;
    }

    @Basic
    @Column(name = "Lydokhenthuong")
    public String getLydokhenthuong() {
        return lydokhenthuong;
    }

    public void setLydokhenthuong(String lydokhenthuong) {
        this.lydokhenthuong = lydokhenthuong;
    }

    @Basic
    @Column(name = "Hinhthuckhenthuong")
    public String getHinhthuckhenthuong() {
        return hinhthuckhenthuong;
    }

    public void setHinhthuckhenthuong(String hinhthuckhenthuong) {
        this.hinhthuckhenthuong = hinhthuckhenthuong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Khenthuong that = (Khenthuong) o;

        if (makhenthuong != null ? !makhenthuong.equals(that.makhenthuong) : that.makhenthuong != null) return false;
        if (tenkhenthuong != null ? !tenkhenthuong.equals(that.tenkhenthuong) : that.tenkhenthuong != null)
            return false;
        if (lydokhenthuong != null ? !lydokhenthuong.equals(that.lydokhenthuong) : that.lydokhenthuong != null)
            return false;
        if (hinhthuckhenthuong != null ? !hinhthuckhenthuong.equals(that.hinhthuckhenthuong) : that.hinhthuckhenthuong != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = makhenthuong != null ? makhenthuong.hashCode() : 0;
        result = 31 * result + (tenkhenthuong != null ? tenkhenthuong.hashCode() : 0);
        result = 31 * result + (lydokhenthuong != null ? lydokhenthuong.hashCode() : 0);
        result = 31 * result + (hinhthuckhenthuong != null ? hinhthuckhenthuong.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "khenthuongByMakhenthuong",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<KhenthuongNhanvien> getKhenthuongNhanviensByMakhenthuong() {
        return khenthuongNhanviensByMakhenthuong;
    }

    public void setKhenthuongNhanviensByMakhenthuong(Collection<KhenthuongNhanvien> khenthuongNhanviensByMakhenthuong) {
        this.khenthuongNhanviensByMakhenthuong = khenthuongNhanviensByMakhenthuong;
    }
}
