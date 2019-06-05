package com.cochau.services;

import java.util.List;

import com.cochau.model.Sanpham;

public interface SanPhamDuyetService {
	public List<Sanpham> listSanPham();
	public Sanpham findSanPham(String id);
}
