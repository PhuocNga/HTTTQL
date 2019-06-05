package com.cochau.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cochau.model.DuyethangSanpham;
import com.cochau.model.Sanpham;
import com.cochau.services.DuyetHangSanPhamService;

@Controller
public class testThoiController {
	@Autowired
DuyetHangSanPhamService dhspsv;
@RequestMapping(value="/ThemSanPhamLuon",method=RequestMethod.GET)
	
	public String xoaKhachHang(HttpServletRequest rq,RedirectAttributes ra) {
	DuyethangSanpham duyet=new DuyethangSanpham();
	duyet.setMadonduyethang("DH9");	
	duyet.setSoluong(12);
	duyet.setMasanpham("OP1");
		
		HttpSession ss=rq.getSession();
		ArrayList<Sanpham> listDuyet=(ArrayList<Sanpham>)ss.getAttribute("dssp");
		ArrayList<String> sol=(ArrayList<String>)ss.getAttribute("sol");
		String maDonHang =(Long)ss.getAttribute("madon")+"";
		String maSanPham;
		int soLuong;
		Integer sl;
		DuyethangSanpham dsp;
		for(int i=0;i<listDuyet.size();i++) {
			maSanPham=listDuyet.get(i).getMasanpham();
			
			soLuong=listDuyet.get(i).getSoluong();
			dsp=new DuyethangSanpham();
			dsp.setMasanpham(maSanPham);
			sl=Integer.parseInt(sol.get(i));
			dsp.setSoluong(sl);
			dsp.setMadonduyethang(maDonHang);
			dhspsv.themSanPhamVaoDon(dsp);
			
		}
		ra.addFlashAttribute("dh", "Thêm đơn hàng " +maDonHang+ " thành công");
		ss.removeAttribute("dssp");
		ss.removeAttribute("sol");
		ss.removeAttribute("madon");
		
		
		return "redirect:/DeNghiDuyetHang";

		
	}
}
