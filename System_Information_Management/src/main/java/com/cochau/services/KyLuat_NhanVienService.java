package com.cochau.services;

import java.util.List;

import com.cochau.model.KyluatNhanvien;

public interface KyLuat_NhanVienService {

	public List<KyluatNhanvien> getAll();

	public List<KyluatNhanvien> getKyluatNhanvien(String maNhanVien);

	public boolean add(KyluatNhanvien kyLuatNhanvien);

	public boolean edit(KyluatNhanvien kyLuatNhanvien);

	public boolean remove(String maNhanVien);
}
