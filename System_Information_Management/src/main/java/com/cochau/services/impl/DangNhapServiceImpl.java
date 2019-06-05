package com.cochau.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.DangNhapDAO;
import com.cochau.model.Role;
import com.cochau.model.TaiKhoan;
import com.cochau.services.DangNhapService;
@Service
public class DangNhapServiceImpl implements DangNhapService{
	@Autowired
	DangNhapDAO dangnhapdao;
	@Transactional
	@Override
	public boolean kiemtraDangNhap(TaiKhoan taikhoan) {
		return dangnhapdao.kiemtraDangNhap(taikhoan);
	}
	@Transactional
	@Override
	public TaiKhoan getThongTin(String user, String pass) {
		// TODO Auto-generated method stub
		return dangnhapdao.getThongTin(user, pass);
	}
	@Transactional
	@Override
	public Role getRole(String roleId) {
		// TODO Auto-generated method stub
		return dangnhapdao.getRole(roleId);
	}

}
