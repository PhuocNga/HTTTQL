package com.cochau.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cochau.model.Donduyethang;
import com.cochau.model.DuyethangSanpham;
import com.cochau.model.Sanpham;
import com.cochau.services.DonDuyetHangService;
import com.cochau.services.SanPhamDuyetService;

@Controller
public class DuyetHangController {
	@Autowired
	SanPhamDuyetService sps;
	@Autowired
	DonDuyetHangService ddh;
	
	
	
	
	
	@RequestMapping(value="/XoaSPham/{id}",method=RequestMethod.GET)
	public String xoaSanPham(HttpServletRequest rq,@PathVariable("id") String id) {
		HttpSession ss=rq.getSession();
		ArrayList<Sanpham> listDuyet= (ArrayList<Sanpham>)ss.getAttribute("dssp"); 
		for(int i=0;i<listDuyet.size();i++) {
			if(listDuyet.get(i).getMasanpham().equals(id)) {
				listDuyet.remove(i);
				return "redirect:/DeNghiDuyetHang";
			}
			
		}
		
		return "";
		
	}
	
	private List<String> CatChuoi(String a){
		ArrayList<String> arr=new ArrayList<>();
		String[] chuoi=a.split("slsl");
		for(int i=0;i<chuoi.length;i++) {
			arr.add(chuoi[i]);
			
		}
	return arr;
		
	}
	@RequestMapping(value="/DeNghiNhapHangVe/{id}",method=RequestMethod.GET)
	
	public String themDonDuyetHang(@PathVariable("id") String tien,RedirectAttributes ra,HttpServletRequest rq) {
		System.out.println(tien);
		HttpSession ss=rq.getSession();
		String[] arr=tien.split("-");
		double giaTri=Double.parseDouble(arr[0]);
		Integer sl=Integer.parseInt(arr[1]);
		ArrayList<String> sol =(ArrayList<String>)CatChuoi(arr[2]);
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		Donduyethang dh=new Donduyethang();
		dh.setMadonduyethang(millis+"");
		dh.setNgaylap(date);
		dh.setManhanvien("NV1");
		dh.setTinhtrangduyethang(0);
		dh.setTonggiatri(giaTri);
		dh.setTongsoluong(sl);
		String thongbao="";
		if(ddh.themDonDuyetHang(dh)) {
			ss.setAttribute("madon", millis);
			ss.setAttribute("sol", sol);
			return "redirect:/ThemSanPhamLuon";
			
		}else {
			thongbao="thất bại";
		}
		
		ra.addFlashAttribute("dh", thongbao);
		
		return "redirect:/DeNghiDuyetHang";
		
		
	}
	
	@RequestMapping(value="/DeNghiDuyetHang",method=RequestMethod.GET)
	public String duyetHang(Model model) {
		model.addAttribute("sp", sps.listSanPham());
		
		return "QuanLyKho/GuiDeNghiDuyetHang";
	}
	
	
	
	@RequestMapping(value="/nhap/{id}",method=RequestMethod.GET)
	public String themVaoDonDuyetHang(@PathVariable("id") String id,HttpServletRequest request,HttpServletResponse response,RedirectAttributes ra) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession sesion=request.getSession();
		ArrayList<Sanpham> listDuyet;
		System.out.println(id);
		
		
		if(sesion.getAttribute("dssp")!=null){
			listDuyet= (ArrayList<Sanpham>)sesion.getAttribute("dssp"); 
			String thongBao="";
			for(int i=0;i<listDuyet.size();i++) {
				if(listDuyet.get(i).getMasanpham().equals(id)) {
					thongBao="Sản Phẩm đã tồn tại" ;
					ra.addFlashAttribute("error",thongBao);
					return "redirect:/DeNghiDuyetHang";
					
				}
			}
			
			if(listDuyet.size()<=5) {
			listDuyet.add(sps.findSanPham(id));
			sesion.removeAttribute("dssp");
			sesion.setAttribute("dssp", listDuyet);
			}if(listDuyet.size()>5) {
				
				
				ra.addFlashAttribute("error","Số lượng sản phẩm không vượt quá 6");
			}
			
		}
		
		if(sesion.getAttribute("dssp")==null) {
		 listDuyet=new ArrayList<>();
		Sanpham sp=sps.findSanPham(id);
		
			listDuyet.add(sp);
			
			sesion.setAttribute("dssp", listDuyet);
			
			
		
		}
		return "redirect:/DeNghiDuyetHang";
		
		
	}
	@RequestMapping(value="/danhSachDonDuyetHang",method=RequestMethod.GET)
	public String DanhSachDonDuyetHang(Model model) {
		
		model.addAttribute("dh", ddh.hienThiDonChuaDuyet());
		return "DuyetHang/duyetHang";
		
	}
}
