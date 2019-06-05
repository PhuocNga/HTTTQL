package com.cochau.dao;

import java.util.List;

import com.cochau.model.KyluatNhanvien;

public interface KyLuat_NhanVienDAO {

	public List<KyluatNhanvien> getAll();

	public List<KyluatNhanvien> getKyluatNhanvien(String maNhanVien);

	public boolean add(KyluatNhanvien kyLuatNhanvien);

	public boolean edit(KyluatNhanvien kyLuatNhanvien);

	public boolean remove(String maNhanVien);

}
