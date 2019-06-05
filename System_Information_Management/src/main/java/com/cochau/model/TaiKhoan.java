package com.cochau.model;

import javax.persistence.*;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "TAI_KHOAN", schema = "QLCHDT", catalog = "")
public class TaiKhoan {
    private int id;
    private String tentaikhoan;
    private String matkhau;
    private String manhanvien;
    private String hinhanh;
    private String roleId;
    private Nhanvien nhanvienByManhanvien;
    private Role roleByRoleId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Tentaikhoan")
    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    @Basic
    @Column(name = "Matkhau")
    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
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
    @Column(name = "hinhanh")
    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    @Basic
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaiKhoan taiKhoan = (TaiKhoan) o;

        if (id != taiKhoan.id) return false;
        if (tentaikhoan != null ? !tentaikhoan.equals(taiKhoan.tentaikhoan) : taiKhoan.tentaikhoan != null)
            return false;
        if (matkhau != null ? !matkhau.equals(taiKhoan.matkhau) : taiKhoan.matkhau != null) return false;
        if (manhanvien != null ? !manhanvien.equals(taiKhoan.manhanvien) : taiKhoan.manhanvien != null) return false;
        if (hinhanh != null ? !hinhanh.equals(taiKhoan.hinhanh) : taiKhoan.hinhanh != null) return false;
        if (roleId != null ? !roleId.equals(taiKhoan.roleId) : taiKhoan.roleId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tentaikhoan != null ? tentaikhoan.hashCode() : 0);
        result = 31 * result + (matkhau != null ? matkhau.hashCode() : 0);
        result = 31 * result + (manhanvien != null ? manhanvien.hashCode() : 0);
        result = 31 * result + (hinhanh != null ? hinhanh.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id",insertable = false,updatable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
