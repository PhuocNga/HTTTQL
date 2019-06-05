package com.cochau.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Van Huynh on 31-05-18.
 */
public class DuyethangSanphamPK implements Serializable {
    private String masanpham;
    private String madonduyethang;

    @Column(name = "Masanpham")
    @Id
    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    @Column(name = "Madonduyethang")
    @Id
    public String getMadonduyethang() {
        return madonduyethang;
    }

    public void setMadonduyethang(String madonduyethang) {
        this.madonduyethang = madonduyethang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DuyethangSanphamPK that = (DuyethangSanphamPK) o;

        if (masanpham != null ? !masanpham.equals(that.masanpham) : that.masanpham != null) return false;
        if (madonduyethang != null ? !madonduyethang.equals(that.madonduyethang) : that.madonduyethang != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = masanpham != null ? masanpham.hashCode() : 0;
        result = 31 * result + (madonduyethang != null ? madonduyethang.hashCode() : 0);
        return result;
    }
}
