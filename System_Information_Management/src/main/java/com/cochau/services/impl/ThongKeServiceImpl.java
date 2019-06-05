package com.cochau.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cochau.dao.ThongKeDao;
import com.cochau.model.Nhanvien;
import com.cochau.services.ThongKeService;

@Service
public class ThongKeServiceImpl implements ThongKeService {
	@Autowired
	ThongKeDao thongkeDao;

	@Override
	@Transactional
	public List<Integer> getAllMonth() {
		return thongkeDao.getAllMonth();
	}

	@Override
	@Transactional
	public List<Integer> getAllYear() {
		// TODO Auto-generated method stub
		return thongkeDao.getAllYear();
	}

	@Override
	@Transactional
	public Object[] getMaxDate() {
		return thongkeDao.getMaxDate();
	}

	@Override
	@Transactional
	public Object[] thongkeTong(int month, int year) {
		return thongkeDao.thongkeTong(month, year);
	}

	@Override
	@Transactional
	public List<String> getAllProduct() {
		return thongkeDao.getAllProduct();
	}

	@Override
	@Transactional
	public List<Object[]> getProduct_Profit(int month, int year) {
		;
		return thongkeDao.getProduct_Profit(month, year);
	}

	@Override
	@Transactional
	public List<Object[]> getProduct_Quarter(List<Integer> listMonth, int year) {
		return thongkeDao.getProduct_Quarter(listMonth, year);
	}

	@Override
	@Transactional
	public Object[] thongKeTong_TheoQuy(List<Integer> listMonth, int year) {
		return thongkeDao.thongKeTong_TheoQuy(listMonth, year);
	}

	@Override
	@Transactional
	public List<Object[]> getNhanvien_Doanhthu(int month, int year) {
		return thongkeDao.getNhanvien_Doanhthu(month, year);
	}

	@Override
	@Transactional
	public List<Nhanvien> getAllNhanVien() {
		return thongkeDao.getAllNhanVien();
	}

	@Override
	@Transactional
	public List<Object[]> getNhanVien_DoanhThu(List<Integer> month, int year) {
		return thongkeDao.getNhanVien_DoanhThu(month, year);
	}
}
