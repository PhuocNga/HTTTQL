package com.cochau.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cochau.dao.Khenthuong_NhanvienDAO;
import com.cochau.model.KhenthuongNhanvien;

@Repository
@Transactional
public class Khenthuong_NhanvienDAOImpl implements Khenthuong_NhanvienDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<KhenthuongNhanvien> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from KhenthuongNhanvien").list();
	}

	@Override
	public List<KhenthuongNhanvien> getKhenthuongNhanvien(String maNhanVien) {
		return sessionFactory.getCurrentSession()
				.createQuery("from KhenthuongNhanvien where manhanvien='" + maNhanVien + "'").list();

	}

	@Override
	public boolean add(KhenthuongNhanvien khenThuongNhanvien) {
		try {
			sessionFactory.getCurrentSession().save(khenThuongNhanvien);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(KhenthuongNhanvien khenThuongNhanvien) {
		try {
			sessionFactory.getCurrentSession().update(khenThuongNhanvien);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(String maNhanVien) {
		try {
			sessionFactory.getCurrentSession().delete(getKhenthuongNhanvien(maNhanVien));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
