package com.cochau.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cochau.dao.KyLuatDAO;
import com.cochau.model.Kyluat;
import com.cochau.services.KyLuatService;

@Service
public class KyLuatServiceImpl implements KyLuatService {

	@Autowired
	KyLuatDAO kyLuatDAO;

	@Override
	public List<Kyluat> getAll() {
		return kyLuatDAO.getAll();
	}

	@Override
	public Kyluat getKyLuat(String maKyLuat) {
		return kyLuatDAO.getKyLuat(maKyLuat);
	}

	@Override
	public boolean add(Kyluat kyLuat) {
		return kyLuatDAO.add(kyLuat);
	}

	@Override
	public boolean edit(Kyluat kyLuat) {
		return kyLuatDAO.edit(kyLuat);
	}

	@Override
	public boolean remove(String maKyLuat) {
		return kyLuatDAO.remove(maKyLuat);
	}

}
