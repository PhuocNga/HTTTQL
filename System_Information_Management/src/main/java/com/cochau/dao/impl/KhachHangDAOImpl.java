package com.cochau.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cochau.dao.KhachhangDAO;
import com.cochau.model.Khachhang;

@Transactional
@Repository
public class KhachHangDAOImpl implements KhachhangDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Khachhang> getAll() {
		String hql="from Khachhang where isExit=:exit";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		query.setParameter("exit", 1);
		return query.list();
	}

	@Override
	public boolean CreateCustomer(Khachhang kh) {
		try {
		sessionFactory.getCurrentSession().save(kh);
		return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean DeleteCustomer(Khachhang kh) {
		
		try {
		 sessionFactory.getCurrentSession().delete(kh);
		 return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
		}
		
	

	@Override
	public boolean EditCustomer(Khachhang kh) {
		try { 
			sessionFactory.getCurrentSession().update(kh);
			return true;
			}catch (Exception e) {
				return false;
			}

}

	@Override
	public Khachhang getCustomer(String id) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Khachhang kh where kh.makhachhang=:makh";
		Query query=session.createQuery(hql);
		query.setParameter("makh", id);
		return (Khachhang) query.list().get(0);
	}
}