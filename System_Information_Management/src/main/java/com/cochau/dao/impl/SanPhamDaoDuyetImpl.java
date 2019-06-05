package com.cochau.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cochau.dao.SanPhamDuyetDao;
import com.cochau.model.Khachhang;
import com.cochau.model.Sanpham;
@Repository
@Transactional
public class SanPhamDaoDuyetImpl implements SanPhamDuyetDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Sanpham> listSanPham() {
		
		return sessionFactory.getCurrentSession().createQuery("from Sanpham").list();
	}

	@Override
	public Sanpham findSanPham(String id) {
		try {
			Sanpham sp=(Sanpham) sessionFactory.getCurrentSession().get(Sanpham.class, id);
			return sp;
			}catch (Exception e) {
				return null;
			}
	}
}
