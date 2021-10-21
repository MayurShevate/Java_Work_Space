package com.ecart.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	private static Connection conn = null;

	public static Connection getConnection() {

		if (conn == null) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_demo", "root", "Root1234");
			//	System.out.println("connection succesfully");
				return conn;
       
			} catch (Exception e) {
				System.out.println("Issue while connecting to DB: " + e);
				e.printStackTrace();
			}

		}

		return conn;

	}

	public static void closeConnection() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		System.out.println("...........");
		getConnection();
	}

}
