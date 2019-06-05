package com.cochau.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class C {
public static void main(String...a){
	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection s =	DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +  
         "databaseName=QuanLyCuaHangDT;user=sa;password=nga");
	System.out.println(s);
// ko ra lỗi: ok ok sao nữa
	
	}catch(Exception e){
		System.err.println(e.getMessage());
	}
}
}

