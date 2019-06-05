package com.cochau.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cochau.dao.DangNhapDAO;
import com.cochau.model.Role;
import com.cochau.model.TaiKhoan;
@Repository
public class DangNhapDAOImpl implements DangNhapDAO{
	@Autowired
	SessionFactory ssFactory;
	@Override
	public boolean kiemtraDangNhap(TaiKhoan taikhoan) {
		Session session=ssFactory.getCurrentSession();
		String hql="from TaiKhoan tk where tk.tentaikhoan= :tentk and tk.matkhau= :matkhau";
		Query query=session.createQuery(hql);
		query.setParameter("tentk", taikhoan.getTentaikhoan());
		query.setParameter("matkhau", taikhoan.getMatkhau());
		List<TaiKhoan>list=query.list();
		if(list.size()>0){
			return true;
		}
		return false;
	}
	@Override
	public TaiKhoan getThongTin(String user, String pass) {
		Session session=ssFactory.getCurrentSession();
		String hql="from TaiKhoan tk where tk.tentaikhoan= :tentk and tk.matkhau= :mk";
		Query query=session.createQuery(hql);
		query.setParameter("tentk", user);
		query.setParameter("mk", pass);
		List<TaiKhoan>list=query.list();
		return list.get(0);
	}
	@Override
	public Role getRole(String roleId) {
		Session session=ssFactory.getCurrentSession();
		String hql="from Role role where role.roleId= :roleId";
		Query query=session.createQuery(hql);
		query.setParameter("roleId", roleId);
		List<Role>list=query.list();
		return list.get(0);
	}

}
