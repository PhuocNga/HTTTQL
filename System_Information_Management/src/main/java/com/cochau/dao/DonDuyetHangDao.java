package com.cochau.dao;

import java.util.List;

import com.cochau.model.Donduyethang;

public interface DonDuyetHangDao {
	public boolean themDonDuyetHang(Donduyethang ddh);
	public List<Donduyethang> hienThiDonChuaDuyet();
	public Donduyethang findTheoMaDon(String id);
	public boolean checkDuyetHayChua(Donduyethang ddh);
}
