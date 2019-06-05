package com.cochau.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.NhanVienDAO;
import com.cochau.model.Nhanvien;
import com.cochau.services.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService {

	@Autowired
	NhanVienDAO nhanVienDAO;

	@Override
	@Transactional
	public List<Nhanvien> getAll() {
		return nhanVienDAO.getAll();
	}

	@Override
	@Transactional
	public Nhanvien getNhanVien(String maNhanVien) {
		return nhanVienDAO.getNhanVien(maNhanVien);
	}

	@Override
	@Transactional
	public boolean add(Nhanvien nhanvien) {
		return nhanVienDAO.add(nhanvien);
	}

	@Override
	@Transactional
	public boolean edit(Nhanvien nhanvien) {
		return nhanVienDAO.edit(nhanvien);
	}

	@Override
	@Transactional
	public boolean remove(String maNhanVien) {
		return nhanVienDAO.remove(maNhanVien);
	}

}
