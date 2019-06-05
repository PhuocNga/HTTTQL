package com.cochau.services;

import java.util.List;

import com.cochau.model.Khenthuong;

public interface KhenThuongService {

	public List<Khenthuong> getAll();

	public Khenthuong getKhenThuong(String maKhenThuong);

	public boolean add(Khenthuong khenThuong);

	public boolean edit(Khenthuong khenThuong);

	public boolean remove(String maKhenThuong);
}
