package com.cochau.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cochau.model.Khachhang;
import com.cochau.services.KhachHangService;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;

@Controller
public class KhachHangController {
	@Autowired
	KhachHangService khs;
	@RequestMapping(value="/QuanLyKhachHang",method=RequestMethod.GET)
	public String quanLyKhachHang(Model model) {
		 model.addAttribute("kh", khs.getAll());
		return "KhachHang/QuanLyKhachHang";
		
	}
	@RequestMapping(value="xoaKhachHang/{makhachhang}",method=RequestMethod.GET)
	public String xoaKhachHang(@PathVariable("makhachhang") String id,RedirectAttributes rAttributes) {
		String thongBao;
		Khachhang kh=khs.listCustomer(id);
		if(khs.DeleteCustomer(kh)){
			thongBao="Báº¡n vá»«a xÃ³a khÃ¡ch hÃ ng cÃ³ id "+id+" thÃ nh cÃ´ng";
		}else {
		thongBao="Há»‡ thá»‘ng Ä‘ang Ä‘Æ°á»£c nÃ¢ng cáº¥p ,vui lÃ²ng xÃ³a láº¡i sau";
		}
		rAttributes.addFlashAttribute("createSuccess", thongBao);
		return "redirect:/QuanLyKhachHang";
	}
	
	@RequestMapping(value="suaKhachHang/{makhachhang}",method=RequestMethod.GET)
	public String suaKhachHang(HttpServletRequest rq,@PathVariable("makhachhang") String id,RedirectAttributes rAttributes) {
		
		String makhachhang=id;
		String tenkhachhang=rq.getParameter("name"+id);
		String diachi=rq.getParameter("diachi"+id);
		String sodienthoai=rq.getParameter("sdt"+id);
		String sochungminh=rq.getParameter("cmnd"+id);
		String ngaysinh=rq.getParameter("ngaysinh"+id);
		Khachhang kh=new Khachhang();
		kh.setDiachi(diachi);
		kh.setTenkhachhang(tenkhachhang);
		kh.setMakhachhang(makhachhang);
		kh.setNgaysinh(new Date(2012, 12, 12));
		kh.setSochungminh(sochungminh);
		kh.setSodienthoai(sodienthoai);
		kh.setSochungminh(sochungminh);
		
		String thongBao;
		if(khs.EditCustomer(kh)){
			thongBao="Sữa khách hàng thành công";
		}else {
		
		thongBao="lỗi";
		}
		rAttributes.addFlashAttribute("createSuccess", thongBao);
		return "redirect:/QuanLyKhachHang";
		
	}
	
	@RequestMapping(value="themKhachHang",method=RequestMethod.GET)
	public String themKhachHang(HttpServletRequest rq,RedirectAttributes rAttributes) {
		String thongBao=null;
		long ramDomMa=System.currentTimeMillis();
		String makhachhang="KH"+ramDomMa;
		String tenkhachhang=rq.getParameter("name");
		String diachi=rq.getParameter("diachi");
		String sodienthoai=rq.getParameter("sdt");
		String sochungminh=rq.getParameter("cmnd");
		String ngaysinh=rq.getParameter("ngaysinh");
		System.out.println(makhachhang);
		Khachhang kh=new Khachhang();
		kh.setMakhachhang(makhachhang);
		kh.setTenkhachhang(tenkhachhang);
		kh.setDiachi(diachi);
		kh.setSodienthoai(sodienthoai);
		kh.setNgaysinh(new Date(12, 12, 2001));
		kh.setSochungminh(sochungminh);
		if(khs.CreateCustomer(kh)) {
			thongBao="ThÃªm khÃ¡ch hÃ ng thÃ nh cÃ´ng";
		}else {
		thongBao="MÃ£ khÃ¡ch hÃ ng Ä‘Ã£ tá»“n táº¡i";
		}
		rAttributes.addFlashAttribute("createSuccess", thongBao);
		return "redirect:/QuanLyKhachHang";
	}
}
