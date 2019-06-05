package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.Khenthuong_NhanvienDAO;
import com.cochau.model.KhenthuongNhanvien;
import com.cochau.services.Khenthuong_NhanvienService;

@Service
public class Khenthuong_NhanvienServiceImpl implements Khenthuong_NhanvienService {

	@Autowired
	Khenthuong_NhanvienDAO khenThuong_NhanVienDAO;

	@Override
	public List<KhenthuongNhanvien> getAll() {
		return khenThuong_NhanVienDAO.getAll();
	}

	@Override
	public List<KhenthuongNhanvien> getKhenthuongNhanvien(String maNhanVien) {
		return khenThuong_NhanVienDAO.getKhenthuongNhanvien(maNhanVien);
	}

	@Override
	public boolean add(KhenthuongNhanvien khenThuongNhanvien) {
		return khenThuong_NhanVienDAO.add(khenThuongNhanvien);
	}

	@Override
	public boolean edit(KhenthuongNhanvien khenThuongNhanvien) {
		return khenThuong_NhanVienDAO.edit(khenThuongNhanvien);
	}

	@Override
	public boolean remove(String maNhanVien) {
		return khenThuong_NhanVienDAO.remove(maNhanVien);
	}

}
