package com.cochau.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Van Huynh on 31-05-18.
 */
public class ChitiethoadonPK implements Serializable {
	private String mahoadon;
	private String masanpham;

	public ChitiethoadonPK(String mahoadon, String masanpham) {
		super();
		this.mahoadon = mahoadon;
		this.masanpham = masanpham;
	}

	public ChitiethoadonPK() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Column(name = "Mahoadon")
	@Id
	public String getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}

	@Column(name = "Masanpham")
	@Id
	public String getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ChitiethoadonPK that = (ChitiethoadonPK) o;

		if (mahoadon != null ? !mahoadon.equals(that.mahoadon) : that.mahoadon != null)
			return false;
		if (masanpham != null ? !masanpham.equals(that.masanpham) : that.masanpham != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = mahoadon != null ? mahoadon.hashCode() : 0;
		result = 31 * result + (masanpham != null ? masanpham.hashCode() : 0);
		return result;
	}
}
