package com.cochau.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cochau.dao.ThongKeDao;
import com.cochau.model.Nhanvien;

@Repository
public class ThongKeDaoImpl implements ThongKeDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Integer> getAllMonth() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "Select month(hd.ngaylaphoadon) from Hoadon hd group by month(hd.ngaylaphoadon)";
		List<Integer> list = session.createQuery(sql).list();
		return list;
	}

	@Override
	public List<Integer> getAllYear() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "Select year(hd.ngaylaphoadon) from Hoadon hd group by year(hd.ngaylaphoadon)";
		List<Integer> list = session.createQuery(sql).list();
		return list;
	}

	@Override
	public Object[] getMaxDate() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"select month(hd.ngaylaphoadon),year(hd.ngaylaphoadon) from Hoadon hd where hd.ngaylaphoadon=(select max(hd1.ngaylaphoadon) from Hoadon hd1)");
		List<Object[]> listResult = query.list();
		return listResult.get(0);
	}

	@Override
	public Object[] thongkeTong(int month, int year) {
		List<Long>listSLBD=null;
		List<Double>listLNTD=null;
		Session session = sessionFactory.getCurrentSession();
		// Get so luong sp
		Query query = session.createQuery("select sum(sp.soluong) from Sanpham sp)");
		long tongSP = (long) query.list().get(0);

		// Get tong so luong ban duoc
		query = session.createQuery(
				"select sum(cthd.soluong) from Hoadon hd join hd.chitiethoadonsByMahoadon cthd where month(hd.ngaylaphoadon)=:month and year(hd.ngaylaphoadon)=:year group by month(hd.ngaylaphoadon),year(hd.ngaylaphoadon)");
		query.setParameter("month", month);
		query.setParameter("year", year);
		listSLBD=query.list();
		long tongSLBD=0;
		if(listSLBD.size()>0){
			tongSLBD = listSLBD.get(0); 
		}

		// Get tong loi nhuan thu duoc
		query = session.createQuery(
				"select sum(cthd.soluong*sp.giaban) from Hoadon hd join hd.chitiethoadonsByMahoadon cthd join cthd.sanphamByMasanpham sp  where month(hd.ngaylaphoadon)=:month and year(hd.ngaylaphoadon)=:year group by month(hd.ngaylaphoadon),year(hd.ngaylaphoadon)");
		query.setParameter("month", month);
		query.setParameter("year", year);
		listLNTD=query.list();
		double loinhuanthuduoc=0;
		if(listLNTD.size()>0){
			loinhuanthuduoc=listLNTD.get(0);
		}
		return new Object[] { tongSP, tongSLBD, loinhuanthuduoc };
	}

	@Override
	public List<String> getAllProduct() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select sp.tensanpham from Sanpham sp");
		return query.list();
	}

	@Override
	public List<Object[]> getProduct_Profit(int month, int year) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"select sanpham.tensanpham,sum(cthd.soluong)as tongsl,sum(cthd.soluong*sanpham.giaban)as gia from Chitiethoadon cthd join cthd.hoadonByMahoadon hd join cthd.sanphamByMasanpham sanpham where month(hd.ngaylaphoadon)=:month and year(hd.ngaylaphoadon)=:year group by sanpham.tensanpham");
		query.setParameter("month", month);
		query.setParameter("year", year);
		return query.list();
	}

	@Override
	public List<Object[]> getProduct_Quarter(List<Integer> listMonth, int year) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"select sanpham.tensanpham,sum(cthd.soluong)as tongsl,sum(cthd.soluong*sanpham.giaban)as gia from Chitiethoadon cthd join cthd.hoadonByMahoadon hd join cthd.sanphamByMasanpham sanpham where month(hd.ngaylaphoadon)in(:listMonth) and year(hd.ngaylaphoadon)=:year group by sanpham.tensanpham");
		query.setParameterList("listMonth", listMonth);
		query.setParameter("year", year);
		return query.list();
	}

	@Override
	public Object[] thongKeTong_TheoQuy(List<Integer> listMonth, int year) {
		Session session = sessionFactory.getCurrentSession();
		long tongSL = 0;
		double tongLoiNhuan = 0;
		List<Long> listTongSL=null;
		List<Double> listTongLN=null;
		// Get so luong sp
		Query query = session.createQuery("select sum(sp.soluong) from Sanpham sp)");
		long tongSP = (long) query.list().get(0);

		// Get tong so luong ban duoc
		query = session.createQuery(
				"select sum(cthd.soluong) from Hoadon hd join hd.chitiethoadonsByMahoadon cthd where month(hd.ngaylaphoadon)=:month and year(hd.ngaylaphoadon)=:year group by month(hd.ngaylaphoadon),year(hd.ngaylaphoadon)");
		query.setParameter("month", listMonth.get(0));
		query.setParameter("year", year);
		listTongSL = query.list();
		if (listTongSL.size()>0) {
			tongSL += (long) listTongSL.get(0);
		}

		query = session.createQuery(
				"select sum(cthd.soluong) from Hoadon hd join hd.chitiethoadonsByMahoadon cthd where month(hd.ngaylaphoadon)=:month and year(hd.ngaylaphoadon)=:year group by month(hd.ngaylaphoadon),year(hd.ngaylaphoadon)");
		query.setParameter("month", listMonth.get(1));
		query.setParameter("year", year);
		listTongSL = query.list();
		if (listTongSL.size()>0) {
			tongSL += (long) listTongSL.get(0);
		}

		query = session.createQuery(
				"select sum(cthd.soluong) from Hoadon hd join hd.chitiethoadonsByMahoadon cthd where month(hd.ngaylaphoadon)=:month and year(hd.ngaylaphoadon)=:year group by month(hd.ngaylaphoadon),year(hd.ngaylaphoadon)");
		query.setParameter("month", listMonth.get(2));
		query.setParameter("year", year);
		listTongSL = query.list();
		if (listTongSL.size()>0) {
			tongSL += (long) listTongSL.get(0);
		}

		// Get tong loi nhuan thu duoc
		query = session.createQuery(
				"select sum(cthd.soluong*sp.giaban) from Hoadon hd join hd.chitiethoadonsByMahoadon cthd join cthd.sanphamByMasanpham sp  where month(hd.ngaylaphoadon)=:month and year(hd.ngaylaphoadon)=:year group by month(hd.ngaylaphoadon),year(hd.ngaylaphoadon)");
		query.setParameter("month", listMonth.get(0));
		query.setParameter("year", year);
		listTongLN = query.list();
		if (listTongLN.size()>0) {
			tongLoiNhuan += listTongLN.get(0);
		}

		query = session.createQuery(
				"select sum(cthd.soluong*sp.giaban) from Hoadon hd join hd.chitiethoadonsByMahoadon cthd join cthd.sanphamByMasanpham sp  where month(hd.ngaylaphoadon)=:month and year(hd.ngaylaphoadon)=:year group by month(hd.ngaylaphoadon),year(hd.ngaylaphoadon)");
		query.setParameter("month", listMonth.get(1));
		query.setParameter("year", year);
		listTongLN = query.list();
		if (listTongLN.size()>0) {
			tongLoiNhuan += listTongLN.get(0);
		}

		query = session.createQuery(
				"select sum(cthd.soluong*sp.giaban) from Hoadon hd join hd.chitiethoadonsByMahoadon cthd join cthd.sanphamByMasanpham sp  where month(hd.ngaylaphoadon)=:month and year(hd.ngaylaphoadon)=:year group by month(hd.ngaylaphoadon),year(hd.ngaylaphoadon)");
		query.setParameter("month", listMonth.get(2));
		query.setParameter("year", year);
		listTongLN = query.list();
		if (listTongLN.size()>0) {
			tongLoiNhuan += listTongLN.get(0);
		}
		return new Object[] { tongSP, tongSL, tongLoiNhuan };
	}

	@Override
	public List<Object[]> getNhanvien_Doanhthu(int month, int year) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select nhanvien.tennhanvien,sum(cthd.soluong),sum(cthd.soluong*sanpham.giaban) from Chitiethoadon cthd join cthd.hoadonByMahoadon hoadon join cthd.sanphamByMasanpham sanpham join hoadon.nhanvienByManhanvien nhanvien where month(hoadon.ngaylaphoadon)=:month and year(hoadon.ngaylaphoadon)=:year group by nhanvien.tennhanvien,month(hoadon.ngaylaphoadon),year(hoadon.ngaylaphoadon)");
		query.setParameter("month", month);
		query.setParameter("year", year);
		List<Object[]>listResult=query.list();
		return listResult;
	}

	@Override
	public List<Nhanvien> getAllNhanVien() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Nhanvien nv");
		return query.list();
	}

	@Override
	public List<Object[]> getNhanVien_DoanhThu(List<Integer> month, int year) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("select nhanvien.tennhanvien,sum(cthd.soluong),sum(cthd.soluong*sanpham.giaban) from Chitiethoadon cthd join cthd.hoadonByMahoadon hoadon join cthd.sanphamByMasanpham sanpham join hoadon.nhanvienByManhanvien nhanvien where month(hoadon.ngaylaphoadon)in(:listMonth) and year(hoadon.ngaylaphoadon)=:year group by nhanvien.tennhanvien,month(hoadon.ngaylaphoadon),year(hoadon.ngaylaphoadon)");
		query.setParameterList("listMonth", month);
		query.setParameter("year", year);
		return query.list();
	}

}
