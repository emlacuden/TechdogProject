package com.techdog.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class CameraDataAccess {
	/**
	 * Open DB connection
	 */
	Connection conn = null;

	public CameraDataAccess() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/Techdog?" + "user=kiba&password=123456");
	}

	/**
	 * Close DB
	 */
	public void CloseConnection() throws Exception {
		if (conn != null) {
			conn.close();
		}
	}

	// get information of all persons
	public ResultSet GetAllPersons() throws Exception {
		String sql = "select * from person";
		java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	// get person name from id
	public ResultSet GetPersonNameFromId(int id) throws Exception {
		String sql = "select person_Name from person where person_Id = ?";
		java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeQuery();
	}

	// get id from person name
	public ResultSet GetIdFromPersonName(String name) throws Exception {
		String sql = "select person_Id from person where person_name = ?";
		java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		return ps.executeQuery();
	}

	// update person information
	public int updatePerson(int id, String name) throws Exception {
		String sql = "update person set person_Name = ? where person_Id = ?";
		java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, id);
		return ps.executeUpdate();
	}

	// insert person
	public int addNewPerson(int id, String name) throws Exception {
		String sql = "insert into person(person_Id, person_Name)" + " values (?,?) ";
		java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		return ps.executeUpdate();
	}

	// get information of all images
	public ResultSet GetAllImages() throws Exception {
		String sql = "select * from image";
		java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}
}
