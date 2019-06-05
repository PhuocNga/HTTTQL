package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.ChiTietHoaDonDAO;
import com.cochau.model.Chitiethoadon;
import com.cochau.services.ChiTietHoaDonService;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {

	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDAO;

	@Override
	public List<Chitiethoadon> getAll() {
		return chiTietHoaDonDAO.getAll();
	}

	@Override
	public List<Chitiethoadon> getChiTietHoaDon(String maHoaDon) {
		return chiTietHoaDonDAO.getChiTietHoaDon(maHoaDon);
	}

	@Override
	public boolean add(Chitiethoadon chitiethoadon) {
		return chiTietHoaDonDAO.add(chitiethoadon);
	}

	@Override
	public boolean edit(Chitiethoadon chitiethoadon) {
		return chiTietHoaDonDAO.edit(chitiethoadon);
	}

	@Override
	public boolean remove(String maHoaDon) {
		return chiTietHoaDonDAO.remove(maHoaDon);
	}

}
