package com.cochau.controller;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cochau.model.Chucvu;
import com.cochau.model.Khenthuong;
import com.cochau.model.KhenthuongNhanvien;
import com.cochau.model.Kyluat;
import com.cochau.model.KyluatNhanvien;
import com.cochau.model.Nhanvien;
import com.cochau.services.ChucVuService;
import com.cochau.services.KhenThuongService;
import com.cochau.services.Khenthuong_NhanvienService;
import com.cochau.services.KyLuatService;
import com.cochau.services.KyLuat_NhanVienService;
import com.cochau.services.NhanVienService;

@Controller
@RequestMapping(value = "/NhanVien")
public class QuanLyNhanVienController {

	@Autowired
	NhanVienService nhanVienService;

	@Autowired
	ChucVuService chucVuService;

	@Autowired
	KhenThuongService khenThuongService;

	@Autowired
	Khenthuong_NhanvienService khenThuong_NhanVienService;

	@Autowired
	KyLuatService kyLuatService;

	@Autowired
	KyLuat_NhanVienService kyLuat_NhanVienService;

	@RequestMapping(value = "/QuanLyNhanVien")
	public String quanLyNhanVien(HttpSession session) {
		List<Nhanvien> listNhanVien = nhanVienService.getAll();
		session.setAttribute("quanLyNhanVien", listNhanVien);
		
		String capBac = "1";
		List<Chucvu> listChucVuSelect = chucVuService.getCapBacChucVu(capBac);
		session.setAttribute("danhSachTenChucVu", listChucVuSelect);
		
		return "QuanLyNhanVien/quanLyNhanVien";
	}

	@RequestMapping(value = "/ThongTinNhanVien")
	public String thongTinNhanVien(HttpServletRequest request, HttpSession session) {
		String maNV = request.getParameter("MaNV");

		Nhanvien listThongTin = nhanVienService.getNhanVien(maNV);
		session.setAttribute("thongTinNhanVien", listThongTin);

		List<KhenthuongNhanvien> listKhenThuong_NhanVien = khenThuong_NhanVienService.getKhenthuongNhanvien(maNV);
		session.setAttribute("listKhenThuong_Nhanvien", listKhenThuong_NhanVien);

		List<KyluatNhanvien> listKyLuat_NhanVien = kyLuat_NhanVienService.getKyluatNhanvien(maNV);
		session.setAttribute("listKyLuat_NhanVien", listKyLuat_NhanVien);

		List<Khenthuong> listKhenThuong = khenThuongService.getAll();
		session.setAttribute("listKhenThuong", listKhenThuong);

		List<Kyluat> listKyLuat = kyLuatService.getAll();
		session.setAttribute("listKyLuat", listKyLuat);

		return "QuanLyNhanVien/thongTinNhanVien";
	}

	@RequestMapping(value = "/KhenThuongNhanVien")
	public String xuLyKhenThuongNhanVien(HttpServletRequest request) {

		String maNV = request.getParameter("manhanvien");
		String maKhenThuong = request.getParameter("khenthuong");
		Date ngayKhenThuong = Date.valueOf(request.getParameter("ngaykhenthuong"));

		KhenthuongNhanvien khenThuongNhanVien = new KhenthuongNhanvien();

		khenThuongNhanVien.setManhanvien(maNV);
		khenThuongNhanVien.setMakhenthuong(maKhenThuong);
		khenThuongNhanVien.setNgaykhenthuong(ngayKhenThuong);

		khenThuong_NhanVienService.add(khenThuongNhanVien);

		return "redirect:/NhanVien/ThongTinNhanVien?MaNV=" + maNV + "";
	}

	@RequestMapping(value = "/KyLuatNhanVien")
	public String xuLyKyLuatNhanVien(HttpServletRequest request) {
		String maNV = request.getParameter("manhanvien");
		String maKyLuat = request.getParameter("kyluat");
		Date ngayKyLuat = Date.valueOf(request.getParameter("ngaykyluat"));

		KyluatNhanvien kyluatNhanvien = new KyluatNhanvien();

		kyluatNhanvien.setManhanvien(maNV);
		kyluatNhanvien.setMakyluat(maKyLuat);
		kyluatNhanvien.setNgaykyluat(ngayKyLuat);

		kyLuat_NhanVienService.add(kyluatNhanvien);

		return "redirect:/NhanVien/ThongTinNhanVien?MaNV=" + maNV + "";
	}

	@RequestMapping(value = "/ThemNhanVien")
	public String themNhanVien(HttpServletRequest request, ModelMap modelmap) throws ParseException {

		String maNhanVien = request.getParameter("manhanvien");
		String tenNhanVien = request.getParameter("tennhanvien");
		Date ngaySinh = Date.valueOf(request.getParameter("ngaysinh"));
		String gioiTinh = request.getParameter("gioitinh");
		String diaChi = request.getParameter("diachi");
		String soDienThoai = request.getParameter("sodienthoai");
		String maChucVu = request.getParameter("chucvu");
		Boolean isExit = true;

		Nhanvien nhanvien = new Nhanvien();
		nhanvien.setManhanvien(maNhanVien);
		nhanvien.setTennhanvien(tenNhanVien);
		nhanvien.setNgaysinh(ngaySinh);
		nhanvien.setGioitinh(gioiTinh);
		nhanvien.setDiachi(diaChi);
		nhanvien.setSodienthoai(soDienThoai);
		nhanvien.setMachucvu(maChucVu);
		nhanvien.setExit(isExit);

		nhanVienService.add(nhanvien);
		return "redirect:/NhanVien/QuanLyNhanVien";
	}

	@RequestMapping(value = "/SuaNhanVien")
	public String suaNhanVien(HttpServletRequest request, HttpSession session) {
		String maNV = request.getParameter("MaNV");
		Nhanvien suaNhanVien = nhanVienService.getNhanVien(maNV);
		session.setAttribute("suanhanvien", suaNhanVien);
		
		String capBac = "1";
		List<Chucvu> listChucVuSelect = chucVuService.getCapBacChucVu(capBac);
		session.setAttribute("danhSachTenChucVu", listChucVuSelect);
		return "QuanLyNhanVien/suaNhanVien";
	}

	@RequestMapping(value = "/XuLySuaNhanVien")
	public String XuLySuaNhanaVien(HttpServletRequest request, HttpSession session) {

		String maNV = request.getParameter("manhanvien");
		String tenNhanVien = request.getParameter("tennhanvien");
		Date ngaySinh = Date.valueOf(request.getParameter("ngaysinh"));
		String gioiTinh = request.getParameter("gioitinh");
		String soDienThoai = request.getParameter("sodienthoai");
		String maChucVu = request.getParameter("chucvu");
		String diaChi = request.getParameter("diachi");
		Boolean isExit = true;

		Nhanvien nhanvien = new Nhanvien();
		nhanvien.setManhanvien(maNV);
		nhanvien.setTennhanvien(tenNhanVien);
		nhanvien.setNgaysinh(ngaySinh);
		nhanvien.setGioitinh(gioiTinh);
		nhanvien.setSodienthoai(soDienThoai);
		nhanvien.setDiachi(diaChi);
		nhanvien.setMachucvu(maChucVu);
		nhanvien.setExit(isExit);

		nhanVienService.edit(nhanvien);

		return "redirect:/NhanVien/QuanLyNhanVien";
	}

	@RequestMapping(value = "/XoaNhanVien")
	public String xoaNhanVien(HttpServletRequest request) {
		String maNV = request.getParameter("MaNV");
		nhanVienService.remove(maNV);
		return "redirect:/NhanVien/QuanLyNhanVien";
	}

}
