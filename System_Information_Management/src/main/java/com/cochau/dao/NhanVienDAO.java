package com.cochau.dao;

import java.util.List;

import com.cochau.model.Nhanvien;

public interface NhanVienDAO {

	public List<Nhanvien> getAll();

	public Nhanvien getNhanVien(String maNhanVien);

	public boolean add(Nhanvien nhanvien);

	public boolean edit(Nhanvien nhanvien);

	public boolean remove(String maNhanVien);

}
