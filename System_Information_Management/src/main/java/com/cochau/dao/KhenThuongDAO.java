package com.cochau.dao;

import java.util.List;

import com.cochau.model.Khenthuong;

public interface KhenThuongDAO {

	public List<Khenthuong> getAll();

	public Khenthuong getKhenThuong(String maKhenThuong);

	public boolean add(Khenthuong khenThuong);

	public boolean edit(Khenthuong khenThuong);

	public boolean remove(String maKhenThuong);

}
