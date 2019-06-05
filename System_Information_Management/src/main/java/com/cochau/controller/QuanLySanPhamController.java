package com.cochau.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cochau.model.Nhacungcap;
import com.cochau.model.Sanpham;
import com.cochau.services.NhaCungCapService;
import com.cochau.services.SanPhamService;

@Controller
@RequestMapping(value = "/SanPham")
public class QuanLySanPhamController {

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	NhaCungCapService nhaCungCapService;

	@RequestMapping(value = "/QuanLySanPham")
	public String quanLySanPham(HttpSession session) {

		List<Sanpham> listSanPham = sanPhamService.getAll();
		session.setAttribute("listSanPham", listSanPham);

		List<Nhacungcap> listNhaCungCap = nhaCungCapService.getNhaCungCap();
		session.setAttribute("listNhaCungCap", listNhaCungCap);

		return "QuanLySanPham/quanLySanPham";
	}

	@RequestMapping(value = "/ThongTinSanPham")
	public String thongTinNhanVien(HttpServletRequest request, HttpSession session) {
		String maSP = request.getParameter("MaSP");
		Sanpham sanpham = sanPhamService.getSanpham(maSP);
		session.setAttribute("listThongTin", sanpham);
		return "QuanLySanPham/thongTinSanPham";
	}

	@RequestMapping(value = "/ThemSanPham")
	public String themNhanVien(HttpServletRequest request, ModelMap modelmap) throws ParseException {
		String maSP = request.getParameter("masanpham");
		String tenSP = request.getParameter("tensanpham");
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		String mauSac = request.getParameter("mausac");
		String cameraTruoc = request.getParameter("cameratruoc") + " MP";
		String cameraSau = request.getParameter("camerasau") + " MP";
		String boNho = request.getParameter("bonho") + " GB";
		String heDieuHanh = request.getParameter("hedieuhanh");
		String pin = request.getParameter("pin") + " mAh";
		double giaBan = Double.parseDouble(request.getParameter("giaban"));
		String thoiGianBaoHanh = request.getParameter("thoigianbaohanh") + " năm";
		String maNhaCungCap = request.getParameter("nhacungcap");
		Boolean isExit = true;

		Sanpham sanpham = new Sanpham();
		sanpham.setMasanpham(maSP);
		sanpham.setTensanpham(tenSP);
		sanpham.setSoluong(soluong);
		sanpham.setMausac(mauSac);
		sanpham.setCamaratruoc(cameraTruoc);
		sanpham.setCamarasau(cameraSau);
		sanpham.setBonho(boNho);
		sanpham.setHedieuhanh(heDieuHanh);
		sanpham.setPin(pin);
		sanpham.setGiaban(giaBan);
		sanpham.setThoigianbaohanh(thoiGianBaoHanh);
		sanpham.setManhacungcap(maNhaCungCap);
		sanpham.setExit(isExit);

		sanPhamService.add(sanpham);

		return "redirect:/SanPham/QuanLySanPham";
	}

	@RequestMapping(value = "/SuaSanPham")
	public String suaNhanVien(HttpServletRequest request, HttpSession session) {
		String maSP = request.getParameter("MaSP");
		Sanpham sanpham = sanPhamService.getSanpham(maSP);
		session.setAttribute("suasanpham", sanpham);

		List<Nhacungcap> listNhaCungCap = nhaCungCapService.getNhaCungCap();
		session.setAttribute("listNhaCungCap", listNhaCungCap);

		return "QuanLySanPham/suaSanPham";
	}

	@RequestMapping(value = "/XuLySuaSanPham")
	public String XuLySuaNhanaVien(HttpServletRequest request, HttpSession session) {
		String maSP = request.getParameter("masanpham");
		String tenSP = request.getParameter("tensanpham");
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		String mauSac = request.getParameter("mausac");
		String cameraTruoc = request.getParameter("cameratruoc") + " MP";
		String cameraSau = request.getParameter("camerasau") + " MP";
		String boNho = request.getParameter("bonho") + " GB";
		String heDieuHanh = request.getParameter("hedieuhanh");
		String pin = request.getParameter("pin") + " mAh";
		double giaBan = Double.parseDouble(request.getParameter("giaban"));
		String thoiGianBaoHanh = request.getParameter("thoigianbaohanh") + " năm";
		String maNhaCungCap = request.getParameter("nhacungcap");
		Boolean isExit = true;

		Sanpham sanpham = new Sanpham();
		sanpham.setMasanpham(maSP);
		sanpham.setTensanpham(tenSP);
		sanpham.setSoluong(soluong);
		sanpham.setMausac(mauSac);
		sanpham.setCamaratruoc(cameraTruoc);
		sanpham.setCamarasau(cameraSau);
		sanpham.setBonho(boNho);
		sanpham.setHedieuhanh(heDieuHanh);
		sanpham.setPin(pin);
		sanpham.setGiaban(giaBan);
		sanpham.setThoigianbaohanh(thoiGianBaoHanh);
		sanpham.setManhacungcap(maNhaCungCap);
		sanpham.setExit(isExit);

		sanPhamService.edit(sanpham);

		return "redirect:/SanPham/QuanLySanPham";
	}

	@RequestMapping(value = "/XoaSanPham")
	public String xoaNhanVien(HttpServletRequest request) {
		String maSP = request.getParameter("MaSP");
		sanPhamService.remove(maSP);
		return "redirect:/SanPham/QuanLySanPham";
	}

}

