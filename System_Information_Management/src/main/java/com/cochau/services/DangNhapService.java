package com.cochau.services;

import com.cochau.model.Role;
import com.cochau.model.TaiKhoan;

public interface DangNhapService {
	public boolean kiemtraDangNhap(TaiKhoan taikhoan);
	public TaiKhoan getThongTin(String user,String pass);
	public Role getRole(String roleId);
}
