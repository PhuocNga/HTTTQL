package com.cochau.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "KHACHHANG", schema = "QLCHDT", catalog = "")
public class Khachhang {
    private String makhachhang;
    private String tenkhachhang;
    private Date ngaysinh;
    private String diachi;
    private String sochungminh;
    private String sodienthoai;
    private Boolean isExit;
    private Collection<Hoadon> hoadonsByMakhachhang;

    @Id
    @Column(name = "Makhachhang")
    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    @Basic
    @Column(name = "Tenkhachhang")
    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    @Basic
    @Column(name = "Ngaysinh")
    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Basic
    @Column(name = "Diachi")
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Basic
    @Column(name = "Sochungminh")
    public String getSochungminh() {
        return sochungminh;
    }

    public void setSochungminh(String sochungminh) {
        this.sochungminh = sochungminh;
    }

    @Basic
    @Column(name = "Sodienthoai")
    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
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

        Khachhang khachhang = (Khachhang) o;

        if (makhachhang != null ? !makhachhang.equals(khachhang.makhachhang) : khachhang.makhachhang != null)
            return false;
        if (tenkhachhang != null ? !tenkhachhang.equals(khachhang.tenkhachhang) : khachhang.tenkhachhang != null)
            return false;
        if (ngaysinh != null ? !ngaysinh.equals(khachhang.ngaysinh) : khachhang.ngaysinh != null) return false;
        if (diachi != null ? !diachi.equals(khachhang.diachi) : khachhang.diachi != null) return false;
        if (sochungminh != null ? !sochungminh.equals(khachhang.sochungminh) : khachhang.sochungminh != null)
            return false;
        if (sodienthoai != null ? !sodienthoai.equals(khachhang.sodienthoai) : khachhang.sodienthoai != null)
            return false;
        if (isExit != null ? !isExit.equals(khachhang.isExit) : khachhang.isExit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = makhachhang != null ? makhachhang.hashCode() : 0;
        result = 31 * result + (tenkhachhang != null ? tenkhachhang.hashCode() : 0);
        result = 31 * result + (ngaysinh != null ? ngaysinh.hashCode() : 0);
        result = 31 * result + (diachi != null ? diachi.hashCode() : 0);
        result = 31 * result + (sochungminh != null ? sochungminh.hashCode() : 0);
        result = 31 * result + (sodienthoai != null ? sodienthoai.hashCode() : 0);
        result = 31 * result + (isExit != null ? isExit.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "khachhangByMakhachhang",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Hoadon> getHoadonsByMakhachhang() {
        return hoadonsByMakhachhang;
    }

    public void setHoadonsByMakhachhang(Collection<Hoadon> hoadonsByMakhachhang) {
        this.hoadonsByMakhachhang = hoadonsByMakhachhang;
    }
}
