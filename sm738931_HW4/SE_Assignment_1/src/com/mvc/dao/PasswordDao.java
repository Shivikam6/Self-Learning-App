package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mvc.util.DBConnection;
import com.mvc.util.EncryptPassword;

public class PasswordDao {
public String updatePassword(String username,String old_password,String new_password,String confirm_password) {
		
		Connection conn=null;
		ResultSet res=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		String old=EncryptPassword.encryption(confirm_password);
		System.out.println(old);
		String result="";
		
		try
		{
			conn=DBConnection.createConnection();
			String query1="select password from users where username='"+username+"'";
			String query2="update users set password=? where username='"+username+"'";
			
			stmt=conn.createStatement();
			res=stmt.executeQuery(query1);
			res.next();
			if(old.equals(res.getString("password")))
			{
				if(new_password.equals(confirm_password))
				{
					String new_ps=EncryptPassword.encryption(new_password);
					String retype=EncryptPassword.encryption(confirm_password);
					
					pstmt=conn.prepareStatement(query2);
					pstmt.setString(1, new_ps);
					int i=pstmt.executeUpdate();
					if(i!=0)
						result="Password updated successfully!";
					else
						result="Something went wrong!";
				}
				else
				{
					result="password and retype password fields do not match";
				}
			}
			else
			{
				result="Current password doesn't match!!";
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		return result;
	}
}
