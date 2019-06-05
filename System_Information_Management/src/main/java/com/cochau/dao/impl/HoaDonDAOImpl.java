package com.cochau.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cochau.dao.HoaDonDAO;
import com.cochau.model.Chitiethoadon;
import com.cochau.model.ChitiethoadonPK;
import com.cochau.model.Hoadon;
import com.cochau.model.Sanpham;

@Repository
@Transactional
public class HoaDonDAOImpl implements HoaDonDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Hoadon> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Hoadon where isExits='" + 1 + "'").list();
	}

	@Override
	public Hoadon getHoaDon(String maHoaDon) {
		List list = sessionFactory.getCurrentSession().createQuery("from Hoadon where mahoadon='" + maHoaDon + "'")
				.list();
		return !list.isEmpty() ? (Hoadon) list.get(0) : null;
	}

	@Override
	public boolean add(Hoadon hoadon) {
		try {
			sessionFactory.getCurrentSession().persist(hoadon);
			;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(Hoadon hoadon) {
		try {
			sessionFactory.getCurrentSession().update(hoadon);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(String maHoaDon) {
		try {
			sessionFactory.getCurrentSession()
					.createQuery("update Hoadon set isExits='" + 0 + "' where mahoadon='" + maHoaDon + "'")
					.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDetailOrder(String mahd, String masp) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Chitiethoadon where mahoadon=:mahdIP and masanpham=:maspIP");
		Hoadon hoadon = (Hoadon) session.get(Hoadon.class, mahd);
		Chitiethoadon cthd = (Chitiethoadon) session.get(Chitiethoadon.class, new ChitiethoadonPK(mahd, masp));
		double gia = cthd.getSoluong() * cthd.getSanphamByMasanpham().getGiaban();
		hoadon.setTongsoluong(hoadon.getTongsoluong() - cthd.getSoluong());
		hoadon.setTongtien(hoadon.getTongtien() - gia);
		query.setParameter("mahdIP", mahd);
		query.setParameter("maspIP", masp);
		session.saveOrUpdate(hoadon);
		if (query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void addOrderDetail(Chitiethoadon cthd, Sanpham sanpham) {
		Session session = sessionFactory.getCurrentSession();
		Hoadon hoadon = (Hoadon) session.get(Hoadon.class, cthd.getMahoadon());
		hoadon.setTongsoluong(hoadon.getTongsoluong() + cthd.getSoluong());
		double giaban = sanpham.getGiaban();
		double tongtien = cthd.getSoluong() * giaban;
		hoadon.setTongtien(hoadon.getTongtien() + tongtien);
		session.saveOrUpdate(hoadon);
		Chitiethoadon cthd1 = (Chitiethoadon) session.get(Chitiethoadon.class,
				new ChitiethoadonPK(cthd.getMahoadon(), cthd.getMasanpham()));
		if (cthd1 != null) {
			cthd1.setSoluong(cthd1.getSoluong() + cthd.getSoluong());
			session.saveOrUpdate(cthd1);
		} else {
			session.persist(cthd);
		}
	}

	@Override
	public void suaCTHD(Chitiethoadon cthd) {
		Session session = sessionFactory.getCurrentSession();
		Hoadon hoadon = (Hoadon) session.get(Hoadon.class, cthd.getMahoadon());
		Chitiethoadon cthd1 = (Chitiethoadon) session.get(Chitiethoadon.class,
				new ChitiethoadonPK(cthd.getMahoadon(), cthd.getMasanpham()));
		int tongsoluong = cthd1.getSoluong() - cthd.getSoluong();
		double tonggiatri = (cthd1.getSoluong() * cthd1.getSanphamByMasanpham().getGiaban())
				- (cthd.getSoluong() * cthd1.getSanphamByMasanpham().getGiaban());
		cthd1.setSoluong(cthd.getSoluong());
		hoadon.setTongsoluong(hoadon.getTongsoluong() - tongsoluong);
		hoadon.setTongtien(hoadon.getTongtien() - tonggiatri);

		session.update(hoadon);
		session.update(cthd1);
	}

}
