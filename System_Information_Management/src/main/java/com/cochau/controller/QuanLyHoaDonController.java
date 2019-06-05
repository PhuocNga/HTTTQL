package com.cochau.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cochau.model.Chitiethoadon;
import com.cochau.model.Hoadon;
import com.cochau.model.Khachhang;
import com.cochau.model.Nhanvien;
import com.cochau.model.Sanpham;
import com.cochau.services.ChiTietHoaDonService;
import com.cochau.services.HoaDonService;
import com.cochau.services.KhachHangService;
import com.cochau.services.NhanVienService;
import com.cochau.services.SanPhamDuyetService;

@Controller
@RequestMapping(value = "/HoaDon")
public class QuanLyHoaDonController {
	Logger log=Logger.getLogger(QuanLyHoaDonController.class);
	@Autowired
	HoaDonService hoaDonService;
	@Autowired
	KhachHangService khachhangService;
	@Autowired
	NhanVienService nhanvienService;
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;
	@Autowired
	SanPhamDuyetService sanphamService;

	@RequestMapping(value = "/QuanLyHoaDon")
	public String quanLyNhanVien(HttpSession session) {
		List<Hoadon> listHoaDon = hoaDonService.getAll();
		session.setAttribute("quanLyHoaDon", listHoaDon);
		session.setAttribute("listKhachHang", khachhangService.getAll());
		session.setAttribute("listNhanVien", nhanvienService.getAll());
		return "QuanLyHoaDon/quanLyHoaDon";
	}

	@RequestMapping(value = "/ThongTinHoaDon")
	public String thongTinHoaDon(HttpServletRequest request, HttpSession session) {
		String maHD = request.getParameter("MaHD");
		Hoadon hoadon = hoaDonService.getHoaDon(maHD);
		session.setAttribute("thongTinHoaDon", hoadon);
		session.setAttribute("listSanPham", sanphamService.listSanPham());
		return "QuanLyHoaDon/thongTinHoaDon";
	}
	

	@RequestMapping(value = "/XoaHoaDon")
	public String xoaHoaDon(HttpServletRequest request) {
		String maHD = request.getParameter("MaHD");
		hoaDonService.remove(maHD);
		return "redirect:/HoaDon/QuanLyHoaDon";
	}
	@RequestMapping(value="/Themhoadon",method=RequestMethod.POST)
	public String themHoaDon(HttpServletRequest request,HttpSession session) {
		String mahd=request.getParameter("mahoadon");
		String ngaylaphd=request.getParameter("ngaylaphoadon");
		String manhanvien=request.getParameter("manhanvien").trim();
		String makhachhang=request.getParameter("makhachhang").trim();
		
		Hoadon hoadon=new Hoadon();
		
		hoadon.setMahoadon(mahd);
		hoadon.setMakhachhang(makhachhang);;;
		hoadon.setManhanvien(manhanvien);;
		hoadon.setTongsoluong(0);
		hoadon.setTongtien(0.0);
		
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		Date ngaylap = null;
		try {
			ngaylap=simple.parse(ngaylaphd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hoadon.setNgaylaphoadon(ngaylap);
		
		hoadon.setExits(true);
		log.info("Ma nv"+manhanvien);log.info("Ma kh"+makhachhang);
		if(hoaDonService.add(hoadon)) {
			session.setAttribute("ssHoaDon", "Thêm hóa đơn thành công!");
		}else{
			session.setAttribute("Lỗi", "Thêm hóa đơn thành công!");
		};
		return "redirect:/HoaDon/QuanLyHoaDon";
	}
	@RequestMapping(value="/XoaSanPham/Mahoadon/{Mahoadon}/Masanpham/{Masanpham}",method=RequestMethod.GET)
	public String xoaSanPhamOrder(@PathVariable("Mahoadon")String mahd,@PathVariable("Masanpham")String masp,HttpSession session) {
		if(hoaDonService.removeProductOrder(mahd, masp)) {
			Hoadon hoadon = hoaDonService.getHoaDon(mahd);
			session.setAttribute("thongTinHoaDon", hoadon);
		}
		
		return "QuanLyHoaDon/thongTinHoaDon";
	}
	@RequestMapping(value="/Themsanpham")
	public String themSanPham(HttpServletRequest request,HttpSession session) {
		String masp=request.getParameter("masanpham").trim();
		String mahd=request.getParameter("mahoadon").trim();
		String soluong=request.getParameter("soluong").trim();
		Chitiethoadon cthd=new Chitiethoadon();
		cthd.setMahoadon(mahd);
		cthd.setMasanpham(masp);
		cthd.setSoluong(Integer.parseInt(soluong));
		
		Sanpham sanpham=sanphamService.findSanPham(masp);
		hoaDonService.addOrderDetail(cthd,sanpham);
		

		Hoadon hoadon = hoaDonService.getHoaDon(mahd);
		session.setAttribute("thongTinHoaDon", hoadon);
		return "QuanLyHoaDon/thongTinHoaDon";
	}
	@RequestMapping(value="/Suacthoadon",method=RequestMethod.POST)
	public String suaCHiTietHD(HttpServletRequest request,HttpSession session) {
		String mahd=request.getParameter("mahoadonsua").trim();
		String masp=request.getParameter("masanphamsua").trim();
		int soluong=Integer.parseInt(request.getParameter("soluongsua").trim());
		Chitiethoadon cthoadon=new Chitiethoadon();
		cthoadon.setMahoadon(mahd);
		cthoadon.setMasanpham(masp);
		cthoadon.setSoluong(soluong);
		hoaDonService.suaCTHD(cthoadon);
		Hoadon hoadon=hoaDonService.getHoaDon(mahd);
		session.setAttribute("thongTinHoaDon", hoadon);
		return "QuanLyHoaDon/thongTinHoaDon";
	}

}

