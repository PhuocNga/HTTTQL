package com.cochau.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cochau.model.Nhacungcap;
import com.cochau.services.NhaCungCapService;

@Controller
@RequestMapping(value = "/nhacungcap")
public class QuanLyNhaCungCapController {
	@Autowired
	NhaCungCapService nhaCungCapService;

	//B1:chuyển tới trang nhà cung cấp
	
	@RequestMapping(value = "/quanlynhacungcap")
	public String quanlyNhaCungCap(Model model) {
		model.addAttribute("list_nhacc", nhaCungCapService.getNhaCungCap());
		return "quanlynhacungcap/quanlynhacc";
	}
	
	@RequestMapping(value = "/xemthongtinnhacc/{manhacc}", method = RequestMethod.GET)
	public String xemThongTinNhaCC(@PathVariable("manhacc") String manhacc, Model model) {
		Nhacungcap nhacc = nhaCungCapService.getNhaCungCap(manhacc);
		model.addAttribute("infonhacc", nhacc);
		return "quanlynhacungcap/thongtinnhacc";
	}

	@RequestMapping(value = "/suanhacungcap/{manhacc}", method = RequestMethod.GET)
	public String suaNhaCungCap(@PathVariable("manhacc") String manhacc, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Nhacungcap nhacungcap = nhaCungCapService.getNhaCungCap(manhacc);
		session.setAttribute("suanhacc", nhacungcap);
		return "quanlynhacungcap/suanhacungcap";
	}

	@RequestMapping(value = "/ktra")
	public String suaNhaCungCap(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String manhacungcap = request.getParameter("manhacungcap");
		String tennhacungcap = request.getParameter("tennhacungcap");
		String sodienthoai = request.getParameter("sodienthoainhacungcap");
		String diachinhacc = request.getParameter("diachinhacungcap");
		Nhacungcap nhacungcap = new Nhacungcap();
		nhacungcap.setManhacungcap(manhacungcap);
		nhacungcap.setTennhacungcap(tennhacungcap);
		nhacungcap.setDiachi(diachinhacc);
		nhacungcap.setSodienthoai(sodienthoai);
		nhacungcap.setSanphamsByManhacungcap(new ArrayList<>());
		String regexStr = "^[0-9]{10,11}$";
		boolean submit = true;
		if (!sodienthoai.matches(regexStr)) {
			session.setAttribute("error_sdt", "số điện thoại phải từ 10-11 số!");
			session.setAttribute("suanhacc", nhacungcap);
			submit = false;
		}
		if (submit) {
			session.removeAttribute("error_sdt");
			nhaCungCapService.suaNhaCungCap(nhacungcap);
			return "redirect:/nhacungcap/quanlynhacungcap";
		} else {
			return "quanlynhacungcap/suanhacungcap";
		}

	}

	@RequestMapping(value = "/xoanhacungcap/{manhacungcap}")
	public String xoaNhaCungCap(@PathVariable("manhacungcap") String manhacc) {
		nhaCungCapService.xoaNhaCungCap(manhacc);
		return "redirect:/nhacungcap/quanlynhacungcap";
	}

	@RequestMapping(value = "/themnhacungcap")
	public String themNhaCungCap(HttpServletRequest request) {
		String manhacungcap = request.getParameter("manhacungcap");
		String tennhacungcap = request.getParameter("tennhacungcap");
		String diachinhacungcap = request.getParameter("diachinhacungcap");
		String sodienthaoinhacungcap = request.getParameter("sdtnhacungcap");
		Nhacungcap nhacungcap = new Nhacungcap();
		nhacungcap.setManhacungcap(manhacungcap);
		nhacungcap.setTennhacungcap(tennhacungcap);
		nhacungcap.setDiachi(diachinhacungcap);
		nhacungcap.setSodienthoai(sodienthaoinhacungcap);
		if (nhaCungCapService.themNhaCungCap(nhacungcap)) {
			return "redirect:/nhacungcap/quanlynhacungcap";
		} else {
			return "page500";
		}
	}
}
