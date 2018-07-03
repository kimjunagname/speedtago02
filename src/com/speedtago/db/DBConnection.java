package com.speedtago.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static {
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection makeConnection() throws SQLException {
		Connection conn = null;
		//my
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "speedtago", "speedtago");
		//����PC DB
		//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.43:1521:xe", "kitri", "kitri"); 
		
		return conn; 					  
	}
}
