package com.cochau.dao;

import com.cochau.model.Role;
import com.cochau.model.TaiKhoan;

public interface DangNhapDAO {
	public boolean kiemtraDangNhap(TaiKhoan taikhoan);
	public TaiKhoan getThongTin(String user,String pass);
	public Role getRole(String roleId);
}
