package com.cochau.services;

import java.util.List;

import com.cochau.model.Donduyethang;

public interface DonDuyetHangService {
	public boolean themDonDuyetHang(Donduyethang ddh);
	public List<Donduyethang> hienThiDonChuaDuyet();
	public Donduyethang findTheoMaDon(String id);
	public boolean checkDuyetHayChua(Donduyethang ddh);

}
