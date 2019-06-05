package com.cochau.dao;

import java.util.List;

import com.cochau.model.Khachhang;

public interface KhachhangDAO {
	public List<Khachhang> getAll();
	public boolean CreateCustomer(Khachhang kh);
	public boolean DeleteCustomer(Khachhang kh);
	public boolean EditCustomer(Khachhang kh);
	public Khachhang getCustomer(String id);
	
}
