package com.cochau.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.HoaDonDAO;
import com.cochau.model.Chitiethoadon;
import com.cochau.model.Hoadon;
import com.cochau.model.Sanpham;
import com.cochau.services.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService {

	@Autowired
	HoaDonDAO hoaDonDAO;

	@Transactional
	@Override
	public List<Hoadon> getAll() {
		return hoaDonDAO.getAll();
	}

	@Override
	public Hoadon getHoaDon(String maHoaDon) {
		return hoaDonDAO.getHoaDon(maHoaDon);
	}

	@Override
	public boolean add(Hoadon hoadon) {
		return hoaDonDAO.add(hoadon);
	}

	@Override
	public boolean edit(Hoadon hoadon) {
		return hoaDonDAO.edit(hoadon);
	}

	@Override
	public boolean remove(String maHoaDon) {
		return hoaDonDAO.remove(maHoaDon);
	}

	@Override
	@Transactional
	public boolean removeProductOrder(String mahd, String masp) {
		// TODO Auto-generated method stub
		return hoaDonDAO.deleteDetailOrder(mahd, masp);
	}

	@Override
	@Transactional
	public void addOrderDetail(Chitiethoadon cthd,Sanpham sanpham) {
		hoaDonDAO.addOrderDetail(cthd,sanpham);
		
	}

	@Override
	@Transactional
	public void suaCTHD(Chitiethoadon cthd) {
		hoaDonDAO.suaCTHD(cthd);
	}

	/*
	 * @Override public List<DanhsachsanphamHD> dsSP(String maHoaDon) {
	 * 
	 * List<DanhsachsanphamHD> danhSSP = new ArrayList<>(); String dsSPHD =
	 * hoaDonDAO.getHoaDon(maHoaDon).getDanhsachsanpham(); StringTokenizer st =
	 * new StringTokenizer(dsSPHD, ","); while (st.hasMoreTokens()) { String
	 * sanpham = st.nextToken(); StringTokenizer st2 = new
	 * StringTokenizer(sanpham, "-"); while (st2.hasMoreTokens()) {
	 * 
	 * String maSP = st2.nextToken(); int soLuong =
	 * Integer.parseInt(st2.nextToken()); String tenSP =
	 * sanPhamDAO.getSanpham(maSP).getTensanpham(); double giaBan =
	 * sanPhamDAO.getSanpham(maSP).getGiaban();
	 * 
	 * DanhsachsanphamHD danhsachsanphamHD = new
	 * DanhsachsanphamHD(maSP,tenSP,soLuong,giaBan);
	 * 
	 * danhSSP.add(danhsachsanphamHD); }
	 * 
	 * } return danhSSP;
	 * 
	 * }
	 */

}
