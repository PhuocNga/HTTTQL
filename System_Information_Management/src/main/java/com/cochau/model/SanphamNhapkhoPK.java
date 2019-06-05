package com.cochau.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Van Huynh on 31-05-18.
 */
public class SanphamNhapkhoPK implements Serializable {
    private String masanpham;
    private String maphieunhapkho;

    @Column(name = "Masanpham")
    @Id
    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    @Column(name = "Maphieunhapkho")
    @Id
    public String getMaphieunhapkho() {
        return maphieunhapkho;
    }

    public void setMaphieunhapkho(String maphieunhapkho) {
        this.maphieunhapkho = maphieunhapkho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SanphamNhapkhoPK that = (SanphamNhapkhoPK) o;

        if (masanpham != null ? !masanpham.equals(that.masanpham) : that.masanpham != null) return false;
        if (maphieunhapkho != null ? !maphieunhapkho.equals(that.maphieunhapkho) : that.maphieunhapkho != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = masanpham != null ? masanpham.hashCode() : 0;
        result = 31 * result + (maphieunhapkho != null ? maphieunhapkho.hashCode() : 0);
        return result;
    }
}
