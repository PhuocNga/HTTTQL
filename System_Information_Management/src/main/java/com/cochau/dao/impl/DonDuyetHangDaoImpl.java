package com.cochau.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cochau.dao.DonDuyetHangDao;
import com.cochau.model.Donduyethang;
import com.cochau.model.Khachhang;
@Repository
@Transactional
public class DonDuyetHangDaoImpl implements DonDuyetHangDao{
	@Autowired
	SessionFactory sf;
	@Override
	public boolean themDonDuyetHang(Donduyethang ddh) {
		// TODO Auto-generated method stub
		try {
			sf.getCurrentSession().save(ddh);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	@Override
	public List<Donduyethang> hienThiDonChuaDuyet() {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from Donduyethang where tinhtrangduyethang=0").list();
	}
	@Override
	public Donduyethang findTheoMaDon(String id) {
		try {
			Donduyethang ddh=(Donduyethang) sf.getCurrentSession().get(Donduyethang.class, id);
			return ddh;
			}catch (Exception e) {
				// TODO: handle exception
			}
			return null;
			
		

	}
	
	@Override
	public boolean checkDuyetHayChua(Donduyethang ddh) {
		try { 
			sf.getCurrentSession().update(ddh);
			return true;
			}catch (Exception e) {
				return false;
			}
	}

}
