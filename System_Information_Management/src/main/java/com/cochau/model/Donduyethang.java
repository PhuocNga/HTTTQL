package com.cochau.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "DONDUYETHANG", schema = "QLCHDT", catalog = "")
public class Donduyethang {
    private String madonduyethang;
    private Date ngaylap;
    private String manhanvien;
    private Integer tongsoluong;
    private Double tonggiatri;
    private Integer tinhtrangduyethang;
    private Nhanvien nhanvienByManhanvien;
    private Collection<DuyethangSanpham> duyethangSanphamsByMadonduyethang;

    @Id
    @Column(name = "Madonduyethang")
    public String getMadonduyethang() {
        return madonduyethang;
    }

    public void setMadonduyethang(String madonduyethang) {
        this.madonduyethang = madonduyethang;
    }

    @Basic
    @Column(name = "Ngaylap")
    public Date getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
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
    @Column(name = "Tongsoluong")
    public Integer getTongsoluong() {
        return tongsoluong;
    }

    public void setTongsoluong(Integer tongsoluong) {
        this.tongsoluong = tongsoluong;
    }

    @Basic
    @Column(name = "Tonggiatri")
    public Double getTonggiatri() {
        return tonggiatri;
    }

    public void setTonggiatri(Double tonggiatri) {
        this.tonggiatri = tonggiatri;
    }

    @Basic
    @Column(name = "Tinhtrangduyethang")
    public Integer getTinhtrangduyethang() {
        return tinhtrangduyethang;
    }

    public void setTinhtrangduyethang(Integer tinhtrangduyethang) {
        this.tinhtrangduyethang = tinhtrangduyethang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Donduyethang that = (Donduyethang) o;

        if (madonduyethang != null ? !madonduyethang.equals(that.madonduyethang) : that.madonduyethang != null)
            return false;
        if (ngaylap != null ? !ngaylap.equals(that.ngaylap) : that.ngaylap != null) return false;
        if (manhanvien != null ? !manhanvien.equals(that.manhanvien) : that.manhanvien != null) return false;
        if (tongsoluong != null ? !tongsoluong.equals(that.tongsoluong) : that.tongsoluong != null) return false;
        if (tonggiatri != null ? !tonggiatri.equals(that.tonggiatri) : that.tonggiatri != null) return false;
        if (tinhtrangduyethang != null ? !tinhtrangduyethang.equals(that.tinhtrangduyethang) : that.tinhtrangduyethang != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = madonduyethang != null ? madonduyethang.hashCode() : 0;
        result = 31 * result + (ngaylap != null ? ngaylap.hashCode() : 0);
        result = 31 * result + (manhanvien != null ? manhanvien.hashCode() : 0);
        result = 31 * result + (tongsoluong != null ? tongsoluong.hashCode() : 0);
        result = 31 * result + (tonggiatri != null ? tonggiatri.hashCode() : 0);
        result = 31 * result + (tinhtrangduyethang != null ? tinhtrangduyethang.hashCode() : 0);
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

    @OneToMany(mappedBy = "donduyethangByMadonduyethang",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<DuyethangSanpham> getDuyethangSanphamsByMadonduyethang() {
        return duyethangSanphamsByMadonduyethang;
    }

    public void setDuyethangSanphamsByMadonduyethang(Collection<DuyethangSanpham> duyethangSanphamsByMadonduyethang) {
        this.duyethangSanphamsByMadonduyethang = duyethangSanphamsByMadonduyethang;
    }
}
