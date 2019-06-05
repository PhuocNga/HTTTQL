package com.cochau.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cochau.dao.ChiTietHoaDonDAO;
import com.cochau.model.Chitiethoadon;

@Repository
@Transactional
public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Chitiethoadon> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Chitiethoadon").list();
	}

	@Override
	public List<Chitiethoadon> getChiTietHoaDon(String maHoaDon) {
		return sessionFactory.getCurrentSession().createQuery("from Chitiethoadon where mahoadon='" + maHoaDon + "'")
				.list();
	}

	@Override
	public boolean add(Chitiethoadon chitiethoadon) {
		try {
			sessionFactory.getCurrentSession().save(chitiethoadon);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(Chitiethoadon chitiethoadon) {
		try {
			sessionFactory.getCurrentSession().update(chitiethoadon);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(String maHoaDon) {
		try {
			sessionFactory.getCurrentSession().delete(getChiTietHoaDon(maHoaDon));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
