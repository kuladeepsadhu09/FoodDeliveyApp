package com.tap.connec;

import java.sql.Connection;
import java.sql.DriverManager;

public final class dbutil {
	private static Connection con=null;
	private static String url="jdbc:mysql://localhost:3306/project";
	private static String username="root";
	private static String password="Swamy@5033";
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}