package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.util.DBConnection;
import com.mvc.util.EncryptPassword;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import java.sql.*;

/**
 * Servlet implementation class PasswordCheck
 */
@WebServlet("/PasswordCheck")
public class PasswordCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String username, password;
	public Statement stmt;
	public java.sql.ResultSet res = null;
	public java.sql.Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordCheck() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			PrintWriter out = response.getWriter();
		
		try {
			
			String cpassword = EncryptPassword.encryption(request.getParameter("password"));
			String password1 = EncryptPassword.encryption(request.getParameter("pass1"));
			String password2 = EncryptPassword.encryption(request.getParameter("pass2"));
			String password = null;
			request.getSession();
			String username = request.getParameter("username");
			System.out.println(username);
			System.out.println("confirm password" + cpassword);
			System.out.println("new pass" + password1);
			System.out.println("confirm new password" + password2);
			
	        conn = DBConnection.createConnection();
			
	        stmt = conn.createStatement();
	        res = stmt.executeQuery("select * from users where username= '"+ username + "'");
			
			String sql = "Update users set password= ? WHERE username=? and password=?";
			res.next();
			password = res.getString("password");
			System.out.println(password);
			if (cpassword.isEmpty() || password1.isEmpty() || password2.isEmpty()){
				 
		        RequestDispatcher rd=request.getRequestDispatcher("/Password.jsp");    
		        rd.include(request,response);
			}
			
			if (cpassword!= null && password1 != null && password2!= null) {
				
				if(password1.equals(password2)) {
					
					if (password.equals(cpassword)) {
						
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, password1);
						ps.setString(2, username);
						ps.setString(3, cpassword);
						ps.executeUpdate();
						
						out.print("<p style=\"color:Green\">Password Changed Successfully!!</p>");
						request.setAttribute("msg", "Password Changed Successfully!");
				        RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");    
				        rd.include(request,response);
				        stmt.close();
				        conn.close();
						
					}
				    
					else {
						out.println("<p style=\"color:red\">Old Password doesn't match</p>");
						request.setAttribute("msg", "Old Password doesn't match");
						RequestDispatcher rd=request.getRequestDispatcher("/Password.jsp");    
				        rd.include(request,response);
					}
				
				}else {
					out.println("<p style=\"color:red\">New password and confirm new password is not matching</p>");
					request.setAttribute("msg", "New password and confirm new password is not matching");
					RequestDispatcher rd=request.getRequestDispatcher("/Password.jsp");    
			        rd.include(request,response);
				}
			} else {
				
				out.print("<p style=\"color:red\">**Password doesnot Change.. Try Again! **</p>");   
				request.setAttribute("msg", "Password doesnot Change.. Try Again!");
		        RequestDispatcher rd=request.getRequestDispatcher("/Password.jsp");    
		        rd.include(request,response);
				
				
			}
			
			
		} catch (SQLException se ) {
			se.printStackTrace();
		}
	}

}
