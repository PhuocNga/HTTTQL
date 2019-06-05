package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.ChucVuDAO;
import com.cochau.model.Chucvu;
import com.cochau.services.ChucVuService;

@Service
public class ChucVuServiceImpl implements ChucVuService {

	@Autowired
	ChucVuDAO chucVuDAO;

	@Override
	public List<Chucvu> getAll() {
		return chucVuDAO.getAll();
	}

	@Override
	public Chucvu getChucVu(String maChucVu) {
		return chucVuDAO.getChucVu(maChucVu);
	}

	@Override
	public boolean add(Chucvu chucVu) {
		return chucVuDAO.add(chucVu);
	}

	@Override
	public boolean edit(Chucvu chucvu) {
		return chucVuDAO.edit(chucvu);
	}

	@Override
	public boolean remove(String maChucVu) {
		return chucVuDAO.remove(maChucVu);
	}

	@Override
	public List<Chucvu> getCapBacChucVu(String capBac) {
		return chucVuDAO.getCapBacChucVu(capBac);
	}

}
