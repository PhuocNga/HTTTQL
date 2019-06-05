package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.DuyetTheoSanPhamDao;
import com.cochau.services.DuyetTheoSanPhamService;
@Service
public class DuyetTheoSanPhamServiceImpl implements DuyetTheoSanPhamService{
@Autowired
DuyetTheoSanPhamDao dtspd;
	@Override
	public List<Object[]> hienThiChiTietHoaDon(String id) {
		
		return dtspd.hienThiChiTietHoaDon(id);
	}

}
