package com.cochau.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cochau.dao.ChucVuDAO;
import com.cochau.model.Chucvu;
import com.cochau.model.Hoadon;

@Repository
@Transactional
public class ChucVuDAOImpl implements ChucVuDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Chucvu> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Chucvu").list();
	}

	@Override
	public Chucvu getChucVu(String maChucVu) {
		List list = sessionFactory.getCurrentSession().createQuery("from Chucvu where machucvu='" + maChucVu + "'")
				.list();
		return !list.isEmpty() ? (Chucvu) list.get(0) : null;
	}

	@Override
	public boolean add(Chucvu chucVu) {
		try {
			sessionFactory.getCurrentSession().save(chucVu);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(Chucvu chucvu) {
		try {
			sessionFactory.getCurrentSession().update(chucvu);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(String maChucVu) {
		try {
			sessionFactory.getCurrentSession().delete(getChucVu(maChucVu));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Chucvu> getCapBacChucVu(String capBac) {
		return sessionFactory.getCurrentSession().createQuery("from Chucvu where capbac='" + capBac + "'").list();
	}

}
