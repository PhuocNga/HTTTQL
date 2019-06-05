package com.cochau.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cochau.dao.DuyetTheoSanPhamDao;
import com.cochau.model.Donduyethang;
import com.cochau.model.DuyethangSanpham;
@Repository
@Transactional
public class DuyetTheoSanPhamDaoImp implements DuyetTheoSanPhamDao {
	@Autowired
	SessionFactory sf;
	@Override
	public List<Object[]> hienThiChiTietHoaDon(String id) {
		String hql="select e.madonduyethang,e.ngaylap,e.manhanvien,e.tongsoluong,e.tonggiatri,a.masanpham,a.soluong from Donduyethang e "
				+ "INNER JOIN e.duyethangSanphamsByMadonduyethang a Where e.madonduyethang=:id"
				;
		Query query= sf.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		List<Object[]> list = query.list();

		return list;
		
	}

}
