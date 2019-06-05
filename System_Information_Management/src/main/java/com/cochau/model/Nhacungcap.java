package com.cochau.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Van Huynh on 31-05-18.
 */
@Entity
@Table(name = "NHACUNGCAP", schema = "QLCHDT", catalog = "")
public class Nhacungcap {
    private String manhacungcap;
    private String tennhacungcap;
    private String diachi;
    private String sodienthoai;
    private Boolean isExit;
    private Collection<Sanpham> sanphamsByManhacungcap;

    @Id
    @Column(name = "Manhacungcap")
    public String getManhacungcap() {
        return manhacungcap;
    }

    public void setManhacungcap(String manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    @Basic
    @Column(name = "Tennhacungcap")
    public String getTennhacungcap() {
        return tennhacungcap;
    }

    public void setTennhacungcap(String tennhacungcap) {
        this.tennhacungcap = tennhacungcap;
    }

    @Basic
    @Column(name = "Diachi")
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Basic
    @Column(name = "Sodienthoai")
    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    @Basic
    @Column(name = "IsExit")
    public Boolean getExit() {
        return isExit;
    }

    public void setExit(Boolean exit) {
        isExit = exit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nhacungcap that = (Nhacungcap) o;

        if (manhacungcap != null ? !manhacungcap.equals(that.manhacungcap) : that.manhacungcap != null) return false;
        if (tennhacungcap != null ? !tennhacungcap.equals(that.tennhacungcap) : that.tennhacungcap != null)
            return false;
        if (diachi != null ? !diachi.equals(that.diachi) : that.diachi != null) return false;
        if (sodienthoai != null ? !sodienthoai.equals(that.sodienthoai) : that.sodienthoai != null) return false;
        if (isExit != null ? !isExit.equals(that.isExit) : that.isExit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = manhacungcap != null ? manhacungcap.hashCode() : 0;
        result = 31 * result + (tennhacungcap != null ? tennhacungcap.hashCode() : 0);
        result = 31 * result + (diachi != null ? diachi.hashCode() : 0);
        result = 31 * result + (sodienthoai != null ? sodienthoai.hashCode() : 0);
        result = 31 * result + (isExit != null ? isExit.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "nhacungcapByManhacungcap",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Sanpham> getSanphamsByManhacungcap() {
        return sanphamsByManhacungcap;
    }

    public void setSanphamsByManhacungcap(Collection<Sanpham> sanphamsByManhacungcap) {
        this.sanphamsByManhacungcap = sanphamsByManhacungcap;
    }
}
