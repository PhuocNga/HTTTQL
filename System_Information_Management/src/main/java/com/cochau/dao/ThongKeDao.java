package com.cochau.dao;

import java.util.List;

import com.cochau.model.Nhanvien;

public interface ThongKeDao {
	//Thống kê lợi nhuận theo tháng
	public List<Integer> getAllMonth();

	public List<Integer> getAllYear();

	public Object[] getMaxDate();

	public Object[] thongkeTong(int month, int year);

	public List<String> getAllProduct();

	public List<Object[]> getProduct_Profit(int month, int year);
	//Thống kê lợi nhuận theo quý
	//Method statistic sum
	public Object[]thongKeTong_TheoQuy(List<Integer>listMonth,int year);
	//Method get all profit in quarter
	public List<Object[]>getProduct_Quarter(List<Integer>listMonth,int year);
	
	public List<Object[]>getNhanvien_Doanhthu(int month,int year);
	
	public List<Nhanvien>getAllNhanVien();
	
	public List<Object[]>getNhanVien_DoanhThu(List<Integer>month,int year);

}
