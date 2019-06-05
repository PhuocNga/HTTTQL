package com.cochau.services;

import java.util.List;

import com.cochau.model.Sanpham;

public interface SanPhamService {
	public List<Sanpham> getAll();

	public Sanpham getSanpham(String maSanpham);

	public boolean add(Sanpham sanpham);

	public boolean edit(Sanpham sanpham);

	public boolean remove(String maSanpham);

}
