package com.techdog.model.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class CameraDataAccess {
	/**
	 * Open DB connection
	 * */
	Connection conn = null;
	public CameraDataAccess() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/Techdog?"
                            + "user=kiba&password=123456");
	}
	/**
	 * Close DB
	 * */
	public void CloseConnection() throws Exception {
		if(conn != null) {
			conn.close();
		}
	}
	
}
