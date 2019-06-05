package com.cochau.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "KYLUAT", schema = "QLCHDT", catalog = "")
public class Kyluat {
    private String makyluat;
    private String tenkyluat;
    private String lydokyluat;
    private String mucdo;
    private Collection<KyluatNhanvien> kyluatNhanviensByMakyluat;

    @Id
    @Column(name = "Makyluat")
    public String getMakyluat() {
        return makyluat;
    }

    public void setMakyluat(String makyluat) {
        this.makyluat = makyluat;
    }

    @Basic
    @Column(name = "Tenkyluat")
    public String getTenkyluat() {
        return tenkyluat;
    }

    public void setTenkyluat(String tenkyluat) {
        this.tenkyluat = tenkyluat;
    }

    @Basic
    @Column(name = "Lydokyluat")
    public String getLydokyluat() {
        return lydokyluat;
    }

    public void setLydokyluat(String lydokyluat) {
        this.lydokyluat = lydokyluat;
    }

    @Basic
    @Column(name = "Mucdo")
    public String getMucdo() {
        return mucdo;
    }

    public void setMucdo(String mucdo) {
        this.mucdo = mucdo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kyluat kyluat = (Kyluat) o;

        if (makyluat != null ? !makyluat.equals(kyluat.makyluat) : kyluat.makyluat != null) return false;
        if (tenkyluat != null ? !tenkyluat.equals(kyluat.tenkyluat) : kyluat.tenkyluat != null) return false;
        if (lydokyluat != null ? !lydokyluat.equals(kyluat.lydokyluat) : kyluat.lydokyluat != null) return false;
        if (mucdo != null ? !mucdo.equals(kyluat.mucdo) : kyluat.mucdo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = makyluat != null ? makyluat.hashCode() : 0;
        result = 31 * result + (tenkyluat != null ? tenkyluat.hashCode() : 0);
        result = 31 * result + (lydokyluat != null ? lydokyluat.hashCode() : 0);
        result = 31 * result + (mucdo != null ? mucdo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kyluatByMakyluat",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<KyluatNhanvien> getKyluatNhanviensByMakyluat() {
        return kyluatNhanviensByMakyluat;
    }

    public void setKyluatNhanviensByMakyluat(Collection<KyluatNhanvien> kyluatNhanviensByMakyluat) {
        this.kyluatNhanviensByMakyluat = kyluatNhanviensByMakyluat;
    }
}
