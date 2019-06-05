package com.cochau.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Van Huynh on 31-05-18.
 */
public class LuongNhanvienPK implements Serializable {
    private String manhanvien;
    private Date thangtrongnam;

    @Column(name = "Manhanvien")
    @Id
    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }

    @Column(name = "Thangtrongnam")
    @Id
    public Date getThangtrongnam() {
        return thangtrongnam;
    }

    public void setThangtrongnam(Date thangtrongnam) {
        this.thangtrongnam = thangtrongnam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LuongNhanvienPK that = (LuongNhanvienPK) o;

        if (manhanvien != null ? !manhanvien.equals(that.manhanvien) : that.manhanvien != null) return false;
        if (thangtrongnam != null ? !thangtrongnam.equals(that.thangtrongnam) : that.thangtrongnam != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manhanvien != null ? manhanvien.hashCode() : 0;
        result = 31 * result + (thangtrongnam != null ? thangtrongnam.hashCode() : 0);
        return result;
    }
}
