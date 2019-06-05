package com.cochau.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cochau.dao.SanPhamDAO;
import com.cochau.model.Hoadon;
import com.cochau.model.Sanpham;

@Repository
@Transactional
public class SanPhamDAOImpl implements SanPhamDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Sanpham> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Sanpham where isExit='" + 1 + "'").list();
	}

	@Override
	public Sanpham getSanpham(String maSanpham) {
		List list = sessionFactory.getCurrentSession().createQuery("from Sanpham where masanpham='" + maSanpham + "'")
				.list();
		return !list.isEmpty() ? (Sanpham) list.get(0) : null;
	}

	@Override
	public boolean add(Sanpham sanpham) {
		try {
			sessionFactory.getCurrentSession().save(sanpham);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(Sanpham sanpham) {
		try {
			sessionFactory.getCurrentSession().update(sanpham);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(String maSanpham) {
		try {
			sessionFactory.getCurrentSession()
					.createQuery("update Sanpham set isExit='" + 0 + "' where masanpham='" + maSanpham + "'")
					.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
