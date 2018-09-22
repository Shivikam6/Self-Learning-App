package com.mvc.dao;

import java.sql.*;
import com.mvc.bean.*;
import com.mvc.util.*;

public class LoginDao {
	public String authenticateUser(LoginBean loginBean) {
		String userName = loginBean.getUsername(); // Keeping user entered values in temporary variables.
		String password = loginBean.getPassword();
		//String role = loginBean.getRole();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String userNameDB = "";
		String passwordDB = "";
		//String roleDB = "";
		try {
			con = DBConnection.createConnection(); // establishing connection
			statement = con.createStatement(); // Statement is used to write queries. Read more about it.
			String query = "select username, password from users where username='" + userName + "'&&password='"+ password + "'";
			System.out.println(query);
			resultSet = statement.executeQuery(query) ; // Here table name is users and userName,password are columns.
														// fetching all the records and storing in a resultSet.
			while (resultSet.next()) // Until next row is present otherwise it return false
			{
				userNameDB = resultSet.getString("username"); // fetch the values present in database
				passwordDB = resultSet.getString("password");
				//roleDB = resultSet.getString("role");
				System.out.println("data from bean"+userName+password);
				System.out.println("Data from Database"+userNameDB+passwordDB);
				if (userName.equals(userNameDB) && password.equals(passwordDB)) {
					return "SUCCESS"; //// If the user entered values are already present in database, which means
										//// user has already registered so I will return SUCCESS message.
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials"; // Just returning appropriate message otherwise
	}
}
