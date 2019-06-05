package com.cochau.services.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.NhaCungCapDAO;
import com.cochau.model.Nhacungcap;
import com.cochau.services.NhaCungCapService;
@Service
public class NhaCungCaoServiceImpl implements NhaCungCapService{
	@Autowired
	NhaCungCapDAO nhaccdao;
	@Override
	@Transactional
	public List<Nhacungcap> getNhaCungCap() {
		// TODO Auto-generated method stub
		return nhaccdao.getNhaCungCap();
	}

	@Override
	@Transactional
	public Nhacungcap getNhaCungCap(String manhacc) {
		return nhaccdao.getNhaCungCap(manhacc);
	}

	@Override
	@Transactional
	public boolean themNhaCungCap(Nhacungcap nhacungcap) {
		return nhaccdao.themNhaCungCap(nhacungcap);
	}

	@Override
	@Transactional
	public void suaNhaCungCap(Nhacungcap nhacc) {
		 nhaccdao.suaNhaCungCap(nhacc);
	}

	@Override
	@Transactional
	public boolean xoaNhaCungCap(String manhacc) {
		return nhaccdao.xoaNhaCungCap(manhacc);
	}

	
}
