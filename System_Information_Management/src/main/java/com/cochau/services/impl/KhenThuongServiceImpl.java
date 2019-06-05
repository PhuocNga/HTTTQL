package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.KhenThuongDAO;
import com.cochau.model.Khenthuong;
import com.cochau.services.KhenThuongService;

@Service
public class KhenThuongServiceImpl implements KhenThuongService {

	@Autowired
	KhenThuongDAO khenThuongDAO;

	@Override
	public List<Khenthuong> getAll() {
		return khenThuongDAO.getAll();
	}

	@Override
	public Khenthuong getKhenThuong(String maKhenThuong) {
		return khenThuongDAO.getKhenThuong(maKhenThuong);
	}

	@Override
	public boolean add(Khenthuong khenThuong) {
		return khenThuongDAO.add(khenThuong);
	}

	@Override
	public boolean edit(Khenthuong khenThuong) {
		return khenThuongDAO.edit(khenThuong);
	}

	@Override
	public boolean remove(String maKhenThuong) {
		return khenThuongDAO.remove(maKhenThuong);
	}

}
