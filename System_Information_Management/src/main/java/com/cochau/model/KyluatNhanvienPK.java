package com.cochau.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Van Huynh on 31-05-18.
 */
public class KyluatNhanvienPK implements Serializable {
    private String manhanvien;
    private String makyluat;

    @Column(name = "Manhanvien")
    @Id
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Column(name = "Makyluat")
    @Id
    public String getMakyluat() {
        return makyluat;
    }

    public void setMakyluat(String makyluat) {
        this.makyluat = makyluat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KyluatNhanvienPK that = (KyluatNhanvienPK) o;

        if (manhanvien != null ? !manhanvien.equals(that.manhanvien) : that.manhanvien != null) return false;
        if (makyluat != null ? !makyluat.equals(that.makyluat) : that.makyluat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manhanvien != null ? manhanvien.hashCode() : 0;
        result = 31 * result + (makyluat != null ? makyluat.hashCode() : 0);
        return result;
    }
}
