package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.signupBean;
import com.mvc.util.DBConnection;

public class ProfileDao {
	public String ProfileEdit(signupBean sb) {
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String userNameDB = "";
	String passwordDB = "";
	
		try {
		con = DBConnection.createConnection(); // establishing connection
		statement = con.createStatement(); // Statement is used to write queries. Read more about it.
		//sString query = 
		} 
		catch (SQLException e) {
		e.printStackTrace();
		}
		return "Invalid user credentials"; // Just returning appropriate message otherwise
	}
}
