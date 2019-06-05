package com.cochau.dao;

import java.util.List;

import com.cochau.model.Sanpham;

public interface SanPhamDuyetDao {
	public List<Sanpham> listSanPham();
	public Sanpham findSanPham(String id);

}
