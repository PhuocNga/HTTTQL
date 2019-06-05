package com.cochau.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "LUONG_NHANVIEN", schema = "QLCHDT", catalog = "")
@IdClass(LuongNhanvienPK.class)
public class LuongNhanvien {
    private String manhanvien;
    private Date thangtrongnam;
    private Integer songaynghicophep;
    private Integer songaynghikhongphep;
    private Integer solanditre;
    private Double tongluong;
    private Nhanvien nhanvienByManhanvien;

    @Id
    @Column(name = "Manhanvien")
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Id
    @Column(name = "Thangtrongnam")
    public Date getThangtrongnam() {
        return thangtrongnam;
    }

    public void setThangtrongnam(Date thangtrongnam) {
        this.thangtrongnam = thangtrongnam;
    }

    @Basic
    @Column(name = "Songaynghicophep")
    public Integer getSongaynghicophep() {
        return songaynghicophep;
    }

    public void setSongaynghicophep(Integer songaynghicophep) {
        this.songaynghicophep = songaynghicophep;
    }

    @Basic
    @Column(name = "Songaynghikhongphep")
    public Integer getSongaynghikhongphep() {
        return songaynghikhongphep;
    }

    public void setSongaynghikhongphep(Integer songaynghikhongphep) {
        this.songaynghikhongphep = songaynghikhongphep;
    }

    @Basic
    @Column(name = "Solanditre")
    public Integer getSolanditre() {
        return solanditre;
    }

    public void setSolanditre(Integer solanditre) {
        this.solanditre = solanditre;
    }

    @Basic
    @Column(name = "Tongluong")
    public Double getTongluong() {
        return tongluong;
    }

    public void setTongluong(Double tongluong) {
        this.tongluong = tongluong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LuongNhanvien that = (LuongNhanvien) o;

        if (manhanvien != null ? !manhanvien.equals(that.manhanvien) : that.manhanvien != null) return false;
        if (thangtrongnam != null ? !thangtrongnam.equals(that.thangtrongnam) : that.thangtrongnam != null)
            return false;
        if (songaynghicophep != null ? !songaynghicophep.equals(that.songaynghicophep) : that.songaynghicophep != null)
            return false;
        if (songaynghikhongphep != null ? !songaynghikhongphep.equals(that.songaynghikhongphep) : that.songaynghikhongphep != null)
            return false;
        if (solanditre != null ? !solanditre.equals(that.solanditre) : that.solanditre != null) return false;
        if (tongluong != null ? !tongluong.equals(that.tongluong) : that.tongluong != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manhanvien != null ? manhanvien.hashCode() : 0;
        result = 31 * result + (thangtrongnam != null ? thangtrongnam.hashCode() : 0);
        result = 31 * result + (songaynghicophep != null ? songaynghicophep.hashCode() : 0);
        result = 31 * result + (songaynghikhongphep != null ? songaynghikhongphep.hashCode() : 0);
        result = 31 * result + (solanditre != null ? solanditre.hashCode() : 0);
        result = 31 * result + (tongluong != null ? tongluong.hashCode() : 0);
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
}
