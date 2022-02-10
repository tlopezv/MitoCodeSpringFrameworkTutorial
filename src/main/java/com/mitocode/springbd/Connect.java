package com.mitocode.springbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static Connection connect() {
		
		Connection conn = null;
		String dbFile = System.getProperties().getProperty("basedir")+"src/main/resources/db/springbd.db";
		try {
			// When you connect to an SQLite database that does not exist, it automatically creates a new database. 
			// Therefore, to create a new database, you just need to specify the database name and connect to it.
			String url ="jdbc:sqlite:"+dbFile;
			// use the DriverManager class to get a database connection based on the connection string.
			conn = DriverManager.getConnection(url);
			
			System.out.println("Connection to SQLite has been established.");
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		
		return conn;
	}
	
	public static void disConnect(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
	}
}
