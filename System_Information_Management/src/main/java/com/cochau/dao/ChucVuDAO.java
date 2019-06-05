package com.cochau.dao;

import java.util.List;

import com.cochau.model.Chucvu;

public interface ChucVuDAO {

	public List<Chucvu> getAll();

	public Chucvu getChucVu(String maChucVu);

	public boolean add(Chucvu chucVu);

	public boolean edit(Chucvu Chucvu);

	public boolean remove(String maChucVu);

	public List<Chucvu> getCapBacChucVu(String capBac);

}
