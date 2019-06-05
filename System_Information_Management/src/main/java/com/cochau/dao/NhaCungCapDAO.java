package com.cochau.dao;

import java.util.List;

import com.cochau.model.Nhacungcap;

public interface NhaCungCapDAO {
	public List<Nhacungcap>getNhaCungCap();
	public Nhacungcap getNhaCungCap(String manhacc);
	public boolean themNhaCungCap(Nhacungcap nhacungcap);
	public void suaNhaCungCap(Nhacungcap nhacc);
	public boolean xoaNhaCungCap(String manhacc);
}
