package com.cochau.dao;

import java.util.List;

import com.cochau.model.Chitiethoadon;
import com.cochau.model.Hoadon;
import com.cochau.model.Sanpham;

public interface HoaDonDAO {

	public List<Hoadon> getAll();

	public Hoadon getHoaDon(String maHoaDon);

	public boolean add(Hoadon maHoaDon);

	public boolean edit(Hoadon hoadon);

	public boolean remove(String maHoaDon);
	
	public boolean deleteDetailOrder(String mahd,String masp);
	public void addOrderDetail(Chitiethoadon cthd,Sanpham sanpham);
	public void suaCTHD(Chitiethoadon cthd);
}
