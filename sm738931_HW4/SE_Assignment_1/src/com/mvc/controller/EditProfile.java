package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.signupBean;
import com.mvc.dao.UpdateDao;
import com.mvc.util.DBConnection;
import com.mvc.util.EncryptPassword;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet(description = "Profile edit", urlPatterns = { "/EditProfile" })
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public String username, password, cusername;
	 public Connection conn = null;
	 public Statement stmt = null;
	 public PreparedStatement st = null;
	 public String firstname, lastname, cpassword;
	 public ResultSet res = null;
	 public int user_id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = null;
		System.out.println("in update profile");
		try {
			firstname = request.getParameter("firstname");
			lastname = request.getParameter("lastname");
			cpassword = EncryptPassword.encryption(request.getParameter("password"));
			
			// Getting the username from session to update the values in database according the username in database
			session=request.getSession();
			cusername = (String) session.getAttribute("username");
	
			System.out.println("C Username: "+cusername);
			System.out.println("current password: " + cpassword);

			conn = DBConnection.createConnection();
			
			stmt = conn.createStatement();
	        res = stmt.executeQuery("select * from users where username= '"+ cusername + "'");
	        
	        String sql ="Update users set firstname=?,lastname=? where username=? and password=?";
	        res.next();
	        username = res.getString("username");
			password = res.getString("password");
			System.out.println("username from database: "+username);
			System.out.println("password from database: "+password);
			
			if (password.equals(cpassword)) {
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setString(3, username);
				ps.setString(4, password);
				ps.executeUpdate();
				
				request.setAttribute("msg", "Profile Updated Successfully!");
		        RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");    
		        rd.include(request,response);
		        stmt.close();
		        conn.close();
			} 
			else if(!(password.equals(cpassword))) {
 
				request.setAttribute("msg", "Password does not match!!");
		        RequestDispatcher rd=request.getRequestDispatcher("/Update.jsp");    
		        rd.include(request,response);
			}else {
				
				//out.print("<p style=\"color:red\">**Password doesnot Change.. Try Again! **</p>");   
				request.setAttribute("msg", "Try Again!");
		        RequestDispatcher rd=request.getRequestDispatcher("/Update.jsp");    
		        rd.include(request,response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
