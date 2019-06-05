package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.SanPhamDAO;
import com.cochau.model.Sanpham;
import com.cochau.services.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	SanPhamDAO sanPhamDAO;

	@Override
	public List<Sanpham> getAll() {
		return sanPhamDAO.getAll();
	}

	@Override
	public Sanpham getSanpham(String maSanpham) {
		return sanPhamDAO.getSanpham(maSanpham);
	}

	@Override
	public boolean add(Sanpham sanpham) {
		return sanPhamDAO.add(sanpham);
	}

	@Override
	public boolean edit(Sanpham sanpham) {
		return sanPhamDAO.edit(sanpham);
	}

	@Override
	public boolean remove(String maSanpham) {
		return sanPhamDAO.remove(maSanpham);
	}

}
