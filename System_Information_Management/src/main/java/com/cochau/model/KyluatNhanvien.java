package com.cochau.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "KYLUAT_NHANVIEN", schema = "QLCHDT", catalog = "")
@IdClass(KyluatNhanvienPK.class)
public class KyluatNhanvien {
    private String manhanvien;
    private String makyluat;
    private Date ngaykyluat;
    private Nhanvien nhanvienByManhanvien;
    private Kyluat kyluatByMakyluat;

    @Id
    @Column(name = "Manhanvien")
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Id
    @Column(name = "Makyluat")
    public String getMakyluat() {
        return makyluat;
    }

    public void setMakyluat(String makyluat) {
        this.makyluat = makyluat;
    }

    @Basic
    @Column(name = "Ngaykyluat")
    public Date getNgaykyluat() {
        return ngaykyluat;
    }

    public void setNgaykyluat(Date ngaykyluat) {
        this.ngaykyluat = ngaykyluat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KyluatNhanvien that = (KyluatNhanvien) o;

        if (manhanvien != null ? !manhanvien.equals(that.manhanvien) : that.manhanvien != null) return false;
        if (makyluat != null ? !makyluat.equals(that.makyluat) : that.makyluat != null) return false;
        if (ngaykyluat != null ? !ngaykyluat.equals(that.ngaykyluat) : that.ngaykyluat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manhanvien != null ? manhanvien.hashCode() : 0;
        result = 31 * result + (makyluat != null ? makyluat.hashCode() : 0);
        result = 31 * result + (ngaykyluat != null ? ngaykyluat.hashCode() : 0);
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
    @JoinColumn(name = "Makyluat", referencedColumnName = "Makyluat", nullable = false,insertable = false,updatable = false)
    public Kyluat getKyluatByMakyluat() {
        return kyluatByMakyluat;
    }

    public void setKyluatByMakyluat(Kyluat kyluatByMakyluat) {
        this.kyluatByMakyluat = kyluatByMakyluat;
    }
}
