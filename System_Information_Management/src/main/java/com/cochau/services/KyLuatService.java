package com.cochau.services;

import java.util.List;

import com.cochau.model.Kyluat;

public interface KyLuatService {

	public List<Kyluat> getAll();

	public Kyluat getKyLuat(String maKyLuat);

	public boolean add(Kyluat kyLuat);

	public boolean edit(Kyluat kyLuat);

	public boolean remove(String maKyLuat);

}
