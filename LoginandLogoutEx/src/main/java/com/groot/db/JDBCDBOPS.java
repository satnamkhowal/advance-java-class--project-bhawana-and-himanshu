package com.groot.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDBOPS {
	public static final String DB_URL="jdbc:mysql://127.0.0.1:3366/collage";
	public static final String DB_USER_NAME="root";
	public static final String DB_USER_PASSWORD="root";
	public static void loadDriverClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		loadDriverClass();
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(DB_URL,DB_USER_NAME,DB_USER_PASSWORD);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return conn;
	}
}
