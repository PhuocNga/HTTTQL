package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.DonDuyetHangDao;
import com.cochau.model.Donduyethang;
import com.cochau.services.DonDuyetHangService;
@Service
public class DonDuyetHangServiceImpl implements DonDuyetHangService{

	@Autowired
	DonDuyetHangDao dhd;
	@Override
	public boolean themDonDuyetHang(Donduyethang ddh) {
		
		return dhd.themDonDuyetHang(ddh);
	}
	@Override
	public List<Donduyethang> hienThiDonChuaDuyet() {
		// TODO Auto-generated method stub
		return dhd.hienThiDonChuaDuyet();
	}
	@Override
	public Donduyethang findTheoMaDon(String id) {
		// TODO Auto-generated method stub
		return dhd.findTheoMaDon(id);
	}
	@Override
	public boolean checkDuyetHayChua(Donduyethang ddh) {
		// TODO Auto-generated method stub
		return dhd.checkDuyetHayChua(ddh);
	}
	

}
