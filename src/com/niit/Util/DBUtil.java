package com.niit.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String JDBC_URL="jdbc:h2:tcp://localhost/~/test";
	private static final String DRIVER_CLASS="org.h2.Driver";
	private static final String JDBC_USERNAME="sa";
	private static final String JDBC_PASSWORD="";
	
	private static Connection con = null;
	
	private DBUtil() {}
	
	public static Connection getConnection() {
		if(con==null) {
			try {
				//1. Load the driver
				Class.forName(DRIVER_CLASS);
				System.out.println("Driver loaded successfully!");
				//2. Get the connection object
				con = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
				System.out.println("Connection Established!");
			} catch (ClassNotFoundException | SQLException ex) {
				System.out.println("Driver loading/Connection failed" + ex.getMessage());
			}
		}
		
		return con;
	}

}
