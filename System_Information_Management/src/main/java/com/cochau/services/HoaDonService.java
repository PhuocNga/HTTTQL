package com.cochau.services;

import java.util.List;

import com.cochau.model.Chitiethoadon;
import com.cochau.model.Hoadon;
import com.cochau.model.Sanpham;

public interface HoaDonService {

	public List<Hoadon> getAll();

	public Hoadon getHoaDon(String maHoaDon);

	public boolean add(Hoadon hoadon);

	public boolean edit(Hoadon hoadon);

	public boolean remove(String maHoaDon);
	public boolean removeProductOrder(String mahd,String masp);
	public void addOrderDetail(Chitiethoadon cthd,Sanpham sanpham);
	public void suaCTHD(Chitiethoadon cthd);
}
