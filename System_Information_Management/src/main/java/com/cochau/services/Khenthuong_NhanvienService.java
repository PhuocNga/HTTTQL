package com.cochau.services;

import java.util.List;

import com.cochau.model.KhenthuongNhanvien;

public interface Khenthuong_NhanvienService {

	public List<KhenthuongNhanvien> getAll();

	public List<KhenthuongNhanvien> getKhenthuongNhanvien(String maNhanVien);

	public boolean add(KhenthuongNhanvien khenThuongNhanvien);

	public boolean edit(KhenthuongNhanvien khenThuongNhanvien);

	public boolean remove(String maNhanVien);

}
