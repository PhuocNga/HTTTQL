package com.cochau.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.KhachhangDAO;
import com.cochau.model.Khachhang;
import com.cochau.services.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService{

	@Autowired
	KhachhangDAO khachhangDAO;
	
	@Override
	@Transactional
	public List<Khachhang> getAll() {
		return khachhangDAO.getAll();
	}

	@Override
	@Transactional
	public boolean CreateCustomer(Khachhang kh) {
		
		return khachhangDAO.CreateCustomer(kh);
	}

	@Override
	@Transactional
	public boolean DeleteCustomer(Khachhang kh) {
		
		return khachhangDAO.DeleteCustomer(kh);
	}

	@Override
	@Transactional
	public boolean EditCustomer(Khachhang kh) {
		
		return khachhangDAO.EditCustomer(kh);
	}

	@Override
	@Transactional
	public Khachhang listCustomer(String id) {
		return khachhangDAO.getCustomer(id);
	}

}
