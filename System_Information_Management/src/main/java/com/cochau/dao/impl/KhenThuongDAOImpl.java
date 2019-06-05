package com.cochau.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cochau.dao.KhenThuongDAO;
import com.cochau.model.Khenthuong;

@Repository
@Transactional
public class KhenThuongDAOImpl implements KhenThuongDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Khenthuong> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Khenthuong").list();
	}

	@Override
	public Khenthuong getKhenThuong(String maKhenThuong) {
		List list = sessionFactory.getCurrentSession()
				.createQuery("from Khenthuong where makhenthuong='" + maKhenThuong + "'").list();
		return !list.isEmpty() ? (Khenthuong) list.get(0) : null;
	}

	@Override
	public boolean add(Khenthuong khenThuong) {
		try {
			sessionFactory.getCurrentSession().save(khenThuong);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(Khenthuong khenThuong) {
		try {
			sessionFactory.getCurrentSession().update(khenThuong);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(String maKhenThuong) {
		try {
			sessionFactory.getCurrentSession().delete(getKhenThuong(maKhenThuong));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
