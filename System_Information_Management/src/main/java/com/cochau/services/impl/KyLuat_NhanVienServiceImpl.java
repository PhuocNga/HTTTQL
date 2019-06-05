package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.KyLuat_NhanVienDAO;
import com.cochau.model.KyluatNhanvien;
import com.cochau.services.KyLuat_NhanVienService;

@Service
public class KyLuat_NhanVienServiceImpl implements KyLuat_NhanVienService {

	@Autowired
	KyLuat_NhanVienDAO kyLuat_NhanVienDAO;

	@Override
	public List<KyluatNhanvien> getAll() {
		return kyLuat_NhanVienDAO.getAll();
	}

	@Override
	public List<KyluatNhanvien> getKyluatNhanvien(String maNhanVien) {
		return kyLuat_NhanVienDAO.getKyluatNhanvien(maNhanVien);
	}

	@Override
	public boolean add(KyluatNhanvien kyLuatNhanvien) {
		return kyLuat_NhanVienDAO.add(kyLuatNhanvien);
	}

	@Override
	public boolean edit(KyluatNhanvien kyLuatNhanvien) {
		return kyLuat_NhanVienDAO.edit(kyLuatNhanvien);
	}

	@Override
	public boolean remove(String maNhanVien) {
		return kyLuat_NhanVienDAO.remove(maNhanVien);
	}

}
