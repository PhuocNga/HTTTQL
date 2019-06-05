package com.cochau.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "CHUCVU", schema = "QLCHDT", catalog = "")
public class Chucvu {
    private String machucvu;
    private String tenchucvu;
    private String capbac;
    private Double luong;
    private Collection<Nhanvien> nhanviensByMachucvu;

    @Id
    @Column(name = "Machucvu")
    public String getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    @Basic
    @Column(name = "Tenchucvu")
    public String getTenchucvu() {
        return tenchucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    @Basic
    @Column(name = "Capbac")
    public String getCapbac() {
        return capbac;
    }

    public void setCapbac(String capbac) {
        this.capbac = capbac;
    }

    @Basic
    @Column(name = "Luong")
    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chucvu chucvu = (Chucvu) o;

        if (machucvu != null ? !machucvu.equals(chucvu.machucvu) : chucvu.machucvu != null) return false;
        if (tenchucvu != null ? !tenchucvu.equals(chucvu.tenchucvu) : chucvu.tenchucvu != null) return false;
        if (capbac != null ? !capbac.equals(chucvu.capbac) : chucvu.capbac != null) return false;
        if (luong != null ? !luong.equals(chucvu.luong) : chucvu.luong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = machucvu != null ? machucvu.hashCode() : 0;
        result = 31 * result + (tenchucvu != null ? tenchucvu.hashCode() : 0);
        result = 31 * result + (capbac != null ? capbac.hashCode() : 0);
        result = 31 * result + (luong != null ? luong.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "chucvuByMachucvu",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Nhanvien> getNhanviensByMachucvu() {
        return nhanviensByMachucvu;
    }

    public void setNhanviensByMachucvu(Collection<Nhanvien> nhanviensByMachucvu) {
        this.nhanviensByMachucvu = nhanviensByMachucvu;
    }
}
