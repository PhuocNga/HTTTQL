package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.DuyetHangSanPhamDao;
import com.cochau.model.DuyethangSanpham;
import com.cochau.services.DuyetHangSanPhamService;
@Service
public class DuyetHangTheoSanPhamServiceImpl implements DuyetHangSanPhamService{
	@Autowired
	DuyetHangSanPhamDao dhspd;
	

	@Override
	public boolean themSanPhamVaoDon(DuyethangSanpham duyetHangSanPham) {
		// TODO Auto-generated method stub
		return dhspd.themSanPhamVaoDon(duyetHangSanPham);
	}

}
