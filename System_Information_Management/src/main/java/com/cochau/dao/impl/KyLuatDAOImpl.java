package com.cochau.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cochau.dao.KyLuatDAO;
import com.cochau.model.Khenthuong;
import com.cochau.model.Kyluat;

@Repository
@Transactional
public class KyLuatDAOImpl implements KyLuatDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Kyluat> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Kyluat").list();
	}

	@Override
	public Kyluat getKyLuat(String maKyLuat) {
		List list = sessionFactory.getCurrentSession().createQuery("from Kyluat where makyluat='" + maKyLuat + "'")
				.list();
		return !list.isEmpty() ? (Kyluat) list.get(0) : null;
	}

	@Override
	public boolean add(Kyluat kyLuat) {
		try {
			sessionFactory.getCurrentSession().save(kyLuat);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(Kyluat kyLuat) {
		try {
			sessionFactory.getCurrentSession().update(kyLuat);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(String maKyLuat) {
		try {
			sessionFactory.getCurrentSession().delete(getKyLuat(maKyLuat));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
