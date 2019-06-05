package com.cochau.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "NHANVIEN", schema = "QLCHDT", catalog = "")
public class Nhanvien {
    private String manhanvien;
    private String tennhanvien;
    private Date ngaysinh;
    private String gioitinh;
    private String diachi;
    private String sodienthoai;
    private String machucvu;
    private Boolean isExit;
    private Collection<ChamcongNhanvien> chamcongNhanviensByManhanvien;
    private Collection<Donduyethang> donduyethangsByManhanvien;
    private Collection<Hoadon> hoadonsByManhanvien;
    private Collection<KhenthuongNhanvien> khenthuongNhanviensByManhanvien;
    private Collection<KyluatNhanvien> kyluatNhanviensByManhanvien;
    private Collection<LuongNhanvien> luongNhanviensByManhanvien;
    private Chucvu chucvuByMachucvu;
    private Collection<Phieunhapkho> phieunhapkhosByManhanvien;
    private Collection<TaiKhoan> taiKhoansByManhanvien;

    @Id
    @Column(name = "Manhanvien")
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Basic
    @Column(name = "Tennhanvien")
    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
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
    @Column(name = "Gioitinh")
    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
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
    @Column(name = "Sodienthoai")
    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    @Basic
    @Column(name = "Machucvu")
    public String getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
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

        Nhanvien nhanvien = (Nhanvien) o;

        if (manhanvien != null ? !manhanvien.equals(nhanvien.manhanvien) : nhanvien.manhanvien != null) return false;
        if (tennhanvien != null ? !tennhanvien.equals(nhanvien.tennhanvien) : nhanvien.tennhanvien != null)
            return false;
        if (ngaysinh != null ? !ngaysinh.equals(nhanvien.ngaysinh) : nhanvien.ngaysinh != null) return false;
        if (gioitinh != null ? !gioitinh.equals(nhanvien.gioitinh) : nhanvien.gioitinh != null) return false;
        if (diachi != null ? !diachi.equals(nhanvien.diachi) : nhanvien.diachi != null) return false;
        if (sodienthoai != null ? !sodienthoai.equals(nhanvien.sodienthoai) : nhanvien.sodienthoai != null)
            return false;
        if (machucvu != null ? !machucvu.equals(nhanvien.machucvu) : nhanvien.machucvu != null) return false;
        if (isExit != null ? !isExit.equals(nhanvien.isExit) : nhanvien.isExit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manhanvien != null ? manhanvien.hashCode() : 0;
        result = 31 * result + (tennhanvien != null ? tennhanvien.hashCode() : 0);
        result = 31 * result + (ngaysinh != null ? ngaysinh.hashCode() : 0);
        result = 31 * result + (gioitinh != null ? gioitinh.hashCode() : 0);
        result = 31 * result + (diachi != null ? diachi.hashCode() : 0);
        result = 31 * result + (sodienthoai != null ? sodienthoai.hashCode() : 0);
        result = 31 * result + (machucvu != null ? machucvu.hashCode() : 0);
        result = 31 * result + (isExit != null ? isExit.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "nhanvienByManhanvien",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<ChamcongNhanvien> getChamcongNhanviensByManhanvien() {
        return chamcongNhanviensByManhanvien;
    }

    public void setChamcongNhanviensByManhanvien(Collection<ChamcongNhanvien> chamcongNhanviensByManhanvien) {
        this.chamcongNhanviensByManhanvien = chamcongNhanviensByManhanvien;
    }

    @OneToMany(mappedBy = "nhanvienByManhanvien",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Donduyethang> getDonduyethangsByManhanvien() {
        return donduyethangsByManhanvien;
    }

    public void setDonduyethangsByManhanvien(Collection<Donduyethang> donduyethangsByManhanvien) {
        this.donduyethangsByManhanvien = donduyethangsByManhanvien;
    }

    @OneToMany(mappedBy = "nhanvienByManhanvien",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Hoadon> getHoadonsByManhanvien() {
        return hoadonsByManhanvien;
    }

    public void setHoadonsByManhanvien(Collection<Hoadon> hoadonsByManhanvien) {
        this.hoadonsByManhanvien = hoadonsByManhanvien;
    }

    @OneToMany(mappedBy = "nhanvienByManhanvien",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<KhenthuongNhanvien> getKhenthuongNhanviensByManhanvien() {
        return khenthuongNhanviensByManhanvien;
    }

    public void setKhenthuongNhanviensByManhanvien(Collection<KhenthuongNhanvien> khenthuongNhanviensByManhanvien) {
        this.khenthuongNhanviensByManhanvien = khenthuongNhanviensByManhanvien;
    }

    @OneToMany(mappedBy = "nhanvienByManhanvien",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<KyluatNhanvien> getKyluatNhanviensByManhanvien() {
        return kyluatNhanviensByManhanvien;
    }

    public void setKyluatNhanviensByManhanvien(Collection<KyluatNhanvien> kyluatNhanviensByManhanvien) {
        this.kyluatNhanviensByManhanvien = kyluatNhanviensByManhanvien;
    }

    @OneToMany(mappedBy = "nhanvienByManhanvien",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<LuongNhanvien> getLuongNhanviensByManhanvien() {
        return luongNhanviensByManhanvien;
    }

    public void setLuongNhanviensByManhanvien(Collection<LuongNhanvien> luongNhanviensByManhanvien) {
        this.luongNhanviensByManhanvien = luongNhanviensByManhanvien;
    }

    @ManyToOne
    @JoinColumn(name = "Machucvu", referencedColumnName = "Machucvu",insertable = false,updatable = false)
    public Chucvu getChucvuByMachucvu() {
        return chucvuByMachucvu;
    }

    public void setChucvuByMachucvu(Chucvu chucvuByMachucvu) {
        this.chucvuByMachucvu = chucvuByMachucvu;
    }

    @OneToMany(mappedBy = "nhanvienByManhanvien",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Phieunhapkho> getPhieunhapkhosByManhanvien() {
        return phieunhapkhosByManhanvien;
    }

    public void setPhieunhapkhosByManhanvien(Collection<Phieunhapkho> phieunhapkhosByManhanvien) {
        this.phieunhapkhosByManhanvien = phieunhapkhosByManhanvien;
    }

    @OneToMany(mappedBy = "nhanvienByManhanvien",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<TaiKhoan> getTaiKhoansByManhanvien() {
        return taiKhoansByManhanvien;
    }

    public void setTaiKhoansByManhanvien(Collection<TaiKhoan> taiKhoansByManhanvien) {
        this.taiKhoansByManhanvien = taiKhoansByManhanvien;
    }
}
