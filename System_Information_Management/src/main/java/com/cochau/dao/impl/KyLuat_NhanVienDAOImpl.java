package com.cochau.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cochau.dao.KyLuat_NhanVienDAO;
import com.cochau.model.KyluatNhanvien;

@Repository
@Transactional
public class KyLuat_NhanVienDAOImpl implements KyLuat_NhanVienDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<KyluatNhanvien> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from KyluatNhanvien").list();
	}

	@Override
	public List<KyluatNhanvien> getKyluatNhanvien(String maNhanVien) {
		return sessionFactory.getCurrentSession()
				.createQuery("from KyluatNhanvien where manhanvien='" + maNhanVien + "'").list();
	}

	@Override
	public boolean add(KyluatNhanvien kyLuatNhanvien) {
		try {
			sessionFactory.getCurrentSession().save(kyLuatNhanvien);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(KyluatNhanvien kyLuatNhanvien) {
		try {
			sessionFactory.getCurrentSession().update(kyLuatNhanvien);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(String maNhanVien) {
		try {
			sessionFactory.getCurrentSession().delete(getKyluatNhanvien(maNhanVien));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
