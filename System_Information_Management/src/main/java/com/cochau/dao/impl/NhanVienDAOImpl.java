package com.cochau.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cochau.dao.NhanVienDAO;
import com.cochau.model.Hoadon;
import com.cochau.model.Nhanvien;

@Repository
@Transactional
public class NhanVienDAOImpl implements NhanVienDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Nhanvien> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Nhanvien where isExit='" + 1 + "'").list();
	}

	@Override
	public Nhanvien getNhanVien(String maNhanVien) {
		List list = sessionFactory.getCurrentSession()
				.createQuery("from Nhanvien where manhanvien='" + maNhanVien + "'").list();
		return !list.isEmpty() ? (Nhanvien) list.get(0) : null;
	}

	@Override
	public boolean add(Nhanvien nhanvien) {
		try {
			sessionFactory.getCurrentSession().save(nhanvien);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(Nhanvien nhanvien) {
		try {
			sessionFactory.getCurrentSession().update(nhanvien);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(String maNhanVien) {
		try {
			sessionFactory.getCurrentSession()
					.createQuery("update Nhanvien set isExit='" + 0 + "' where manhanvien='" + maNhanVien + "'")
					.executeUpdate();
			/*
			 * sessionFactory.getCurrentSession() .createSQLQuery(
			 * "delete from Nhanvien where manhanvien='" + maNhanVien +
			 * "'").executeUpdate();
			 */
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
