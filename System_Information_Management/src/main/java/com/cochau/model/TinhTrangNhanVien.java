package com.cochau.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "TINH_TRANG_NHAN_VIEN", schema = "QLCHDT", catalog = "")
public class TinhTrangNhanVien {
    private String matrangthai;
    private String trangthai;
    private Double phantramluongtru;
    private Collection<ChamcongNhanvien> chamcongNhanviensByMatrangthai;

    @Id
    @Column(name = "Matrangthai")
    public String getMatrangthai() {
        return matrangthai;
    }

    public void setMatrangthai(String matrangthai) {
        this.matrangthai = matrangthai;
    }

    @Basic
    @Column(name = "Trangthai")
    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Basic
    @Column(name = "Phantramluongtru")
    public Double getPhantramluongtru() {
        return phantramluongtru;
    }

    public void setPhantramluongtru(Double phantramluongtru) {
        this.phantramluongtru = phantramluongtru;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TinhTrangNhanVien that = (TinhTrangNhanVien) o;

        if (matrangthai != null ? !matrangthai.equals(that.matrangthai) : that.matrangthai != null) return false;
        if (trangthai != null ? !trangthai.equals(that.trangthai) : that.trangthai != null) return false;
        if (phantramluongtru != null ? !phantramluongtru.equals(that.phantramluongtru) : that.phantramluongtru != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = matrangthai != null ? matrangthai.hashCode() : 0;
        result = 31 * result + (trangthai != null ? trangthai.hashCode() : 0);
        result = 31 * result + (phantramluongtru != null ? phantramluongtru.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tinhTrangNhanVienByMatrangthai",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<ChamcongNhanvien> getChamcongNhanviensByMatrangthai() {
        return chamcongNhanviensByMatrangthai;
    }

    public void setChamcongNhanviensByMatrangthai(Collection<ChamcongNhanvien> chamcongNhanviensByMatrangthai) {
        this.chamcongNhanviensByMatrangthai = chamcongNhanviensByMatrangthai;
    }
}
