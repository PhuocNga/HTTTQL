package com.cochau.dao;

import java.util.List;

import com.cochau.model.Chitiethoadon;

public interface ChiTietHoaDonDAO {

	public List<Chitiethoadon> getAll();

	public List<Chitiethoadon> getChiTietHoaDon(String maHoaDon);

	public boolean add(Chitiethoadon chitiethoadon);

	public boolean edit(Chitiethoadon chitiethoadon);

	public boolean remove(String maHoaDon);

}
