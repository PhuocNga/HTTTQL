package com.cochau.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cochau.model.TaiKhoan;
import com.cochau.services.DangNhapService;
import com.cochau.services.KhachHangService;
import com.cochau.services.NhaCungCapService;
import com.cochau.services.ThongKeService;

@Controller
@RequestMapping(value = "/Home")
public class HomeController {
	Logger log=Logger.getLogger(HomeController.class);
	@Autowired
	KhachHangService khachHangService;
	@Autowired
	NhaCungCapService nhaCungCapService;
	@Autowired
	DangNhapService dangnhapService;
	
	@Autowired
	ThongKeService thongke;
	// B1 chuyển trang dang nhap
	@RequestMapping(value = "/dangnhap")
	public String dangnhap() {
		log.info("hi");
		return "dangnhap";
	}

	// B2 kiểm tra đăng nhập
	@RequestMapping(value = "/ktradangnhap", method = RequestMethod.POST)
	public String ktraDangNhap(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String matkhau = request.getParameter("pass");
		TaiKhoan taikhoan = new TaiKhoan();
		TaiKhoan taikhoan1 = new TaiKhoan();
		taikhoan.setTentaikhoan(email);
		taikhoan.setMatkhau(matkhau);
		if (dangnhapService.kiemtraDangNhap(taikhoan)) {
			session.removeAttribute("user_error");
			taikhoan1 = dangnhapService.getThongTin(email, matkhau);
			session.setAttribute("user", taikhoan1);
			session.setAttribute("role", dangnhapService.getRole(taikhoan1.getRoleId()));
			return "trangquanly";
		} else {
			session.setAttribute("user_error", taikhoan);
			return "dangnhap";
		}
	}
	@RequestMapping(value = "/quanly")
	public String trangquanly(){
		return "trangquanly";
	}
	
	@RequestMapping(value = "/dangxuat")
	public String dangxuat(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "dangnhap";
	}

}
