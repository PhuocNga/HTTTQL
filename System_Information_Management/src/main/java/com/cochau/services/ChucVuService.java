package com.cochau.services;

import java.util.List;

import com.cochau.model.Chucvu;

public interface ChucVuService {

	public List<Chucvu> getAll();

	public Chucvu getChucVu(String maChucVu);

	public boolean add(Chucvu chucVu);

	public boolean edit(Chucvu chucvu);

	public boolean remove(String maChucVu);

	public List<Chucvu> getCapBacChucVu(String capBac);
}
