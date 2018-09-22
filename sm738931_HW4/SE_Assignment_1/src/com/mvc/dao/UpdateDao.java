package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.signupBean;
import com.mvc.util.DBConnection;
import com.mvc.util.EncryptPassword;

public class UpdateDao {
	public String saveProfile(signupBean user)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		int i=0;
		String pass=EncryptPassword.encryption(user.getPassword());
		String sql="select password from users where username='"+user.getUsername()+"'";
		String query="update users set f_name=?,l_name=? where user_id=?";
		String result="";
		try
		{
			conn=DBConnection.createConnection();
		Statement stmt=conn.createStatement();
		ResultSet res=stmt.executeQuery(sql);
		res.next();
		if(pass.equals(res.getString("passwd")))
		{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getUsername());
			i=pstmt.executeUpdate();
			result="Profile updated successfully.";	
		}
		else
		{
			result="Profile passwrd doesn't match!! Please enter correct password.";
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
