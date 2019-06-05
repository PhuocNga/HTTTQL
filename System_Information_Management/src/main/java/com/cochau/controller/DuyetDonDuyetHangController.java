package com.cochau.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cochau.model.Donduyethang;
import com.cochau.services.DonDuyetHangService;
import com.cochau.services.DuyetTheoSanPhamService;

@Controller
public class DuyetDonDuyetHangController {
	@Autowired 
	DuyetTheoSanPhamService dtspd;
	@Autowired
	DonDuyetHangService ddhsv;
	
	
	@RequestMapping(value="chiTietDuyetDon/{id}",method=RequestMethod.GET)
	
	public String xoaKhachHang(Model model,@PathVariable("id") String maHoaDon) {
		List<Object[]> list=dtspd.hienThiChiTietHoaDon(maHoaDon);
		model.addAttribute("listChiTiet",list );
		
		return "DuyetHang/chiTietNhapHang";

		
	}
	@RequestMapping(value="DuyetSanPham/{id}",method=RequestMethod.GET)
	public String DuyetSanPhamThanhCong(HttpServletRequest request,HttpServletResponse response,Model model,@PathVariable("id") String maHoaDon,RedirectAttributes ra) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		String thongbao="";
		Donduyethang DonDuyetHang=ddhsv.findTheoMaDon(maHoaDon);
		DonDuyetHang.setTinhtrangduyethang(1);
		if(ddhsv.checkDuyetHayChua(DonDuyetHang)) {
			thongbao="Duyệt đơn thành công ";
			
		}else {
			thongbao="Không thành công ";
			
		}
		ra.addFlashAttribute("thongBao", thongbao);
		return "redirect:/danhSachDonDuyetHang";
		
	}
}
