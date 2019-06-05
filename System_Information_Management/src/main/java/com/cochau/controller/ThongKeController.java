package com.cochau.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cochau.model.Nhanvien;
import com.cochau.services.ThongKeService;

@Controller
@RequestMapping(value = "/thongke")
public class ThongKeController {
	private static final Logger logger = Logger.getLogger(ThongKeController.class);
	@Autowired
	ThongKeService thongkeService;

	@RequestMapping(value = "/chonthongke/{condition}")
	public String thongke(@PathVariable("condition") String condition) {
		if (condition.equals("doanhthutheothang")) {
			return "thongke/thongkethangoption";
		} else if (condition.equals("doanhthutheoquy")) {
			return "thongke/thongkequyoption";
		} else if (condition.equals("thongkenhanvien")) {
			return "thongke/optionthongkenhanvien";
		}
		return "thongke/thongkeloinhuan";
	}

	@RequestMapping(value = "/doanhthutheothang/{condition}", method = RequestMethod.GET)
	public String thongkeDoanhThu(@PathVariable("condition") String condition, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// Get all month
		List<Integer> listMonth = thongkeService.getAllMonth();
		// Get all year
		List<Integer> listYear = thongkeService.getAllYear();
		// getMaxDate
		Object[] dateNew = thongkeService.getMaxDate();
		// Get month từ max date
		int month = Integer.parseInt(String.valueOf(dateNew[0]));
		// Get year từ max date
		int year = Integer.parseInt(String.valueOf(dateNew[1]));
		session.setAttribute("year", listYear);
		session.setAttribute("month", listMonth);
		if (condition.equals("thongke")) {
			session.setAttribute("columchart", getProduct_Profit(month, year));
			session.setAttribute("thongketong", thongkeService.thongkeTong(month, year));
			session.setAttribute("monthRequest", month);
			session.setAttribute("yearRequest", year);
			return "thongke/thongkedoanhthutheothang";
		} else {
			return "thongke/sosanhcacthang";
		}
	}

	@RequestMapping(value = "/doanhthutheoquy/{condition}")
	public String thongKeTheoQuy(@PathVariable("condition") String condition, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Integer> listMonth = thongkeService.getAllMonth();
		// Get all year
		List<Integer> listYear = thongkeService.getAllYear();
		// getMaxDate
		Object[] dateNew = thongkeService.getMaxDate();
		// Get month từ max date
		int month = Integer.parseInt(String.valueOf(dateNew[0]));
		// Get year từ max date
		int year = Integer.parseInt(String.valueOf(dateNew[1]));
		session.setAttribute("year", listYear);
		// Set quarter for session
		List<Integer> listQuarter = new ArrayList<>();
		for (int i = 0; i < listMonth.size(); i++) {
			if (!listQuarter.contains(getQuarter(listMonth.get(i)))) {
				listQuarter.add(getQuarter(listMonth.get(i)));
			}
		}
		session.setAttribute("quarter", listQuarter);
		if (condition.equals("thongke")) {
			int quy = getQuarter(month);
			List<Integer> getMonth_Quarter = getMonth(quy);
			session.setAttribute("yearRequest", year);
			session.setAttribute("quarterRequest", quy);
			session.setAttribute("thongketong_theoquy", thongkeService.thongKeTong_TheoQuy(getMonth_Quarter, year));
			session.setAttribute("columchart_quarter", getProduct_Profit_Quarter(getMonth_Quarter, year));
			return "thongke/thongkedoanhthutheoquy";
		} else {
			return "thongke/sosanhcacquy";
		}
	}

	// Hàm get tất cả sản phẩm cùng với lợi nhuận thu được theo tháng
	public List<Object[]> getProduct_Profit(int month, int year) {
		List<Object[]> listResult = new ArrayList<>();
		List<String> listString = thongkeService.getAllProduct();
		List<Object[]> listObject = thongkeService.getProduct_Profit(month, year);
		double gia;
		double soluong;

		for (int i = 0; i < listString.size(); i++) {
			soluong = 0.0;
			gia = 0.0;
			for (int j = 0; j < listObject.size(); j++) {
				if (listString.get(i).equals(listObject.get(j)[0])) {
					soluong = Double.parseDouble(listObject.get(j)[1] + "");
					gia = Double.parseDouble(listObject.get(j)[2] + "");
				}
			}
			Object[] object = { listString.get(i), soluong, gia };
			listResult.add(object);
		}
		return listResult;
	}

	// Hàm get tất cả sản phẩm cùng với lợi nhuận thu được theo quý
	public List<Object[]> getProduct_Profit_Quarter(List<Integer> listMonth, int year) {
		List<Object[]> listResult = new ArrayList<>();
		List<String> listString = thongkeService.getAllProduct();
		List<Object[]> listObject = thongkeService.getProduct_Quarter(listMonth, year);
		double gia;
		double soluong;

		for (int i = 0; i < listString.size(); i++) {
			soluong = 0.0;
			gia = 0.0;
			for (int j = 0; j < listObject.size(); j++) {
				if (listString.get(i).equals(listObject.get(j)[0])) {
					soluong = Double.parseDouble(listObject.get(j)[1] + "");
					gia = Double.parseDouble(listObject.get(j)[2] + "");
				}
			}
			Object[] object = { listString.get(i), soluong, gia };
			listResult.add(object);
		}
		return listResult;
	}

	// Hàm convert tháng thành quý
	public static int getQuarter(int month) {
		if (month == 1 || month == 2 || month == 3) {
			return 1;
		} else if (month == 4 || month == 5 || month == 6) {
			return 2;
		} else if (month == 7 || month == 8 || month == 9) {
			return 3;
		} else if (month == 10 || month == 11 || month == 12) {
			return 4;
		}
		return 0;
	}

	// Hàm convert quarter to month
	public static List<Integer> getMonth(int quarter) {
		List<Integer> listMonth = new ArrayList<>();
		if (quarter == 1) {
			listMonth.add(1);
			listMonth.add(2);
			listMonth.add(3);
		} else if (quarter == 2) {
			listMonth.add(4);
			listMonth.add(5);
			listMonth.add(6);
		} else if (quarter == 3) {
			listMonth.add(7);
			listMonth.add(8);
			listMonth.add(9);
		} else if (quarter == 4) {
			listMonth.add(10);
			listMonth.add(11);
			listMonth.add(12);
		}
		return listMonth;
	}

	@RequestMapping(value = "/thongketheothang")
	public String thongkeLoiNhuanTheoThang(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int month = Integer.parseInt(request.getParameter("month"));
		int year = Integer.parseInt(request.getParameter("year"));
		session.setAttribute("thongketong", thongkeService.thongkeTong(month, year));
		session.setAttribute("columchart", getProduct_Profit(month, year));
		session.setAttribute("monthRequest", month);
		session.setAttribute("yearRequest", year);

		return "thongke/thongkedoanhthutheothang";
	}

	@RequestMapping(value = "/thongketheoquy")
	public String thongkeLoiNhuanTheoQuy(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int quarter = Integer.parseInt(request.getParameter("quarter"));
		int year = Integer.parseInt(request.getParameter("year"));
		List<Integer> getMonthQuarter = getMonth(quarter);
		session.setAttribute("thongketong_theoquy", thongkeService.thongKeTong_TheoQuy(getMonthQuarter, year));
		session.setAttribute("columchart_quarter", getProduct_Profit_Quarter(getMonthQuarter, year));
		session.setAttribute("yearRequest", year);
		session.setAttribute("quarterRequest", quarter);

		return "thongke/thongkedoanhthutheoquy";
	}

	// So sánh doanh thu
	@RequestMapping(value = "/sosanhdoanhthuthang")
	public String soSanhDoanhThuThang(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String year1 = request.getParameter("yearcompare1");
		String year2 = request.getParameter("yearcompare2");
		String month1 = request.getParameter("monthcompare1");
		String month2 = request.getParameter("monthcompare2");
		List<String> listMonthYear = new ArrayList<>();
		listMonthYear.add(month1);
		listMonthYear.add(year1);
		listMonthYear.add(month2);
		listMonthYear.add(year2);
		session.setAttribute("compare1", getProduct_Profit(Integer.parseInt(month1), Integer.parseInt(year1)));
		session.setAttribute("compare2", getProduct_Profit(Integer.parseInt(month2), Integer.parseInt(year2)));
		session.setAttribute("listMonthYear", listMonthYear);
		return "thongke/sosanhcacthang";
	}

	// Get all nhanvien_doanhthu
	public List<Object[]> getAllNhanVien_DoanhThu(int month, int year) {
		double tongSL;
		double tongDT;
		List<Object[]> listResult = new ArrayList<>();
		List<Nhanvien> listNhanvien = thongkeService.getAllNhanVien();
		List<Object[]> listNhanVien_DT = thongkeService.getNhanvien_Doanhthu(month, year);
		for (int i = 0; i < listNhanvien.size(); i++) {
			tongSL = 0.0;
			tongDT = 0.0;
			for (int j = 0; j < listNhanVien_DT.size(); j++) {
				if (listNhanVien_DT.get(j)[0].equals(listNhanvien.get(i).getTennhanvien())) {
					tongSL=Double.parseDouble(listNhanVien_DT.get(j)[1]+"");
					tongDT=Double.parseDouble(listNhanVien_DT.get(j)[2]+"");
				}
			}
			Object[]ob={listNhanvien.get(i).getTennhanvien(),tongSL,tongDT};
			listResult.add(ob);
		}
		return listResult;
	}
	public List<Object[]>getAllNhanVien_Doanhthu_Theoquy(List<Integer>listMonth,int year){
		double tongSL;
		double tongDT;
		List<Object[]> listResult = new ArrayList<>();
		List<Nhanvien> listNhanvien = thongkeService.getAllNhanVien();
		List<Object[]> listNhanVien_DT = thongkeService.getNhanVien_DoanhThu(listMonth, year);
		for (int i = 0; i < listNhanvien.size(); i++) {
			tongSL = 0.0;
			tongDT = 0.0;
			for (int j = 0; j < listNhanVien_DT.size(); j++) {
				if (listNhanVien_DT.get(j)[0].equals(listNhanvien.get(i).getTennhanvien())) {
					tongSL=Double.parseDouble(listNhanVien_DT.get(j)[1]+"");
					tongDT=Double.parseDouble(listNhanVien_DT.get(j)[2]+"");
				}
			}
			Object[]ob={listNhanvien.get(i).getTennhanvien(),tongSL,tongDT};
			listResult.add(ob);
		}
		return listResult;
	}

	@RequestMapping(value = "/soasanhdoanhthuquy")
	public String soSanhDoanhThuQuy(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String year1 = request.getParameter("yearcompare1");
		String year2 = request.getParameter("yearcompare2");
		String quarter1 = request.getParameter("quartercompare1");
		String quarter2 = request.getParameter("quartercompare2");
		List<Integer> getMonthQuarter1 = getMonth(Integer.parseInt(quarter1));
		List<Integer> getMonthQuarter2 = getMonth(Integer.parseInt(quarter2));
		List<String> quarter_Year = new ArrayList<>();
		quarter_Year.add(quarter1);
		quarter_Year.add(year1);
		quarter_Year.add(quarter2);
		quarter_Year.add(year2);
		session.setAttribute("quarter_year", quarter_Year);
		session.setAttribute("stackchart1", getProduct_Profit_Quarter(getMonthQuarter1, Integer.parseInt(year1)));
		session.setAttribute("stackchart2", getProduct_Profit_Quarter(getMonthQuarter2, Integer.parseInt(year2)));
		return "thongke/sosanhcacquy";
	}

	// Thống kê nhân viên
	@RequestMapping(value = "/thongkenhanvien/{condition}")
	public String chonThongKeNhanVien(@PathVariable("condition") String condition, HttpServletRequest request) {
		Object[] dateNew = thongkeService.getMaxDate();
		// Get month từ max date
		int maxMonth = Integer.parseInt(String.valueOf(dateNew[0]));
		// Get year từ max date
		int maxYear = Integer.parseInt(String.valueOf(dateNew[1]));
		HttpSession session = request.getSession();
		List<Integer> listMonth = thongkeService.getAllMonth();
		List<Integer> listYear = thongkeService.getAllYear();
		session.setAttribute("month", listMonth);
		session.setAttribute("year", listYear);
		if (condition.equals("thongketheothang")) {
			session.setAttribute("chart_thongke_theothang", getAllNhanVien_DoanhThu(maxMonth, maxYear));
			session.setAttribute("monthRequest", maxMonth);
			session.setAttribute("yearRequest", maxYear);
			return "thongke/thongkenhanvientheothang";
		} else {
			List<Integer> listQuarter = new ArrayList<>();
			for (int i = 0; i < listMonth.size(); i++) {
				if (!listQuarter.contains(getQuarter(listMonth.get(i)))) {
					listQuarter.add(getQuarter(listMonth.get(i)));
				}
			}
			int quy = getQuarter(maxMonth);
			List<Integer> getMonth_Quarter = getMonth(quy);
			session.setAttribute("columchart_quarter", getAllNhanVien_Doanhthu_Theoquy(getMonth_Quarter, maxYear));
			session.setAttribute("quarter", listQuarter);
			session.setAttribute("quarterRequest", quy);
			session.setAttribute("yearRequest", maxYear);
			return "thongke/thongkenhanvientheoquy";
		}
	}
	@RequestMapping("/thongkenhanvientheothang")
	public String thongKeNhanVienTheoThang(HttpServletRequest request){
		HttpSession sesion=request.getSession();
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		sesion.setAttribute("chart_thongke_theothang", getAllNhanVien_DoanhThu(Integer.parseInt(month), Integer.parseInt(year)));
		sesion.setAttribute("monthRequest", month);
		sesion.setAttribute("yearRequest", year);
		return "thongke/thongkenhanvientheothang";
	}
	@RequestMapping("/thongkenhanvientheoquy")
	public String thongKeNhanVienTheoQuy(HttpServletRequest request){
		HttpSession sesion=request.getSession();
		String quarter=request.getParameter("quarter");
		String year=request.getParameter("year");
		sesion.setAttribute("quarterRequest", quarter);
		sesion.setAttribute("yearRequest", year);
		List<Integer> getMonth_Quarter = getMonth(Integer.parseInt(quarter));
		sesion.setAttribute("columchart_quarter", getAllNhanVien_Doanhthu_Theoquy(getMonth_Quarter, Integer.parseInt(year)));
		return "thongke/thongkenhanvientheoquy";
	}
}
