package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.SanPhamDuyetDao;
import com.cochau.model.Sanpham;
import com.cochau.services.SanPhamDuyetService;
@Service
public class SanPhamDuyetServiceImpl implements SanPhamDuyetService{
	@Autowired
	SanPhamDuyetDao spd;
	@Override
	public List<Sanpham> listSanPham() {
		// TODO Auto-generated method stub
		return spd.listSanPham();
	}
	@Override
	public Sanpham findSanPham(String id) {
		// TODO Auto-generated method stub
		return spd.findSanPham(id);
	}

}
