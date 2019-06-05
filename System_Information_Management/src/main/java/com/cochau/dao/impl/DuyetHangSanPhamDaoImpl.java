package com.cochau.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.DuyetHangSanPhamDao;
import com.cochau.model.DuyethangSanpham;
@Service
@Transactional
public class DuyetHangSanPhamDaoImpl implements DuyetHangSanPhamDao{
@Autowired
SessionFactory sf;
	@Override
	public boolean themSanPhamVaoDon(DuyethangSanpham duyetHangSanPham) {
		try {
			sf.getCurrentSession().save(duyetHangSanPham);
			return true;
		} catch (Exception e) {
			return false;
		}
		
			
			
		
		
	}

}
