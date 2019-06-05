package com.cochau.dao.impl;

import java.util.List;

import javax.management.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cochau.dao.NhaCungCapDAO;
import com.cochau.model.Nhacungcap;

@Repository
public class NhaCungCapDAOImpl implements NhaCungCapDAO {
	@Autowired
	SessionFactory ssFactory;

	@Override
	public List<Nhacungcap> getNhaCungCap() {
		org.hibernate.Session session = ssFactory.getCurrentSession();
		List<Nhacungcap> listNhacc = session.createQuery("from Nhacungcap").list();
		return listNhacc;
	}

	@Override
	public Nhacungcap getNhaCungCap(String manhacc) {
		org.hibernate.Session session = ssFactory.getCurrentSession();
		org.hibernate.Query query = session.createQuery("from Nhacungcap ncc where ncc.manhacungcap=:manhacc");
		query.setParameter("manhacc", manhacc);
		List<Nhacungcap> nhacc = query.list();
		return nhacc.get(nhacc.size() - 1);
	}

	@Override
	public boolean themNhaCungCap(Nhacungcap nhacungcap) {
		org.hibernate.Session session = ssFactory.getCurrentSession();
		nhacungcap.setExit(true);
		try {
			session.persist(nhacungcap);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void suaNhaCungCap(Nhacungcap nhacc) {
		nhacc.setExit(true);
		org.hibernate.Session session = ssFactory.getCurrentSession();
		session.update(nhacc);

	}

	@Override
	public boolean xoaNhaCungCap(String manhacc) {
		org.hibernate.Session session = ssFactory.getCurrentSession();
		Nhacungcap nhacc = (Nhacungcap) session.get(Nhacungcap.class, manhacc);
		nhacc.setExit(false);
		try {
			session.update(nhacc);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
