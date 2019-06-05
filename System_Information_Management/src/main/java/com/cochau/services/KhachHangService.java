package com.cochau.services;

import java.util.List;

import com.cochau.model.Khachhang;

public interface KhachHangService {
	public List<Khachhang> getAll();
	public boolean CreateCustomer(Khachhang kh);
	public boolean DeleteCustomer(Khachhang kh);
	public boolean EditCustomer(Khachhang kh);
	public Khachhang listCustomer(String id);
}
