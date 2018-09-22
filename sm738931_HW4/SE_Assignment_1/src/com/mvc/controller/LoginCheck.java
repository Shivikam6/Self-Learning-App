package com.mvc.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;
import com.mvc.util.EncryptPassword;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public String username, password, role; 

	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session = null;
			username = request.getParameter("username");
			password = EncryptPassword.encryption(request.getParameter("password"));
			role = request.getParameter("role");
			
			LoginBean lb = new LoginBean();
			lb.setUsername(username);
			lb.setPassword(password);
			//lb.setRole(role);
				
			//Login by user from the Database
			LoginBean loginbean=new LoginBean();
			loginbean.setUsername(username);
			loginbean.setPassword(password);
			//loginbean.setRole(role);
			
			LoginDao logindao=new LoginDao();
			String validateUser=logindao.authenticateUser(loginbean);
			
			//Checking the validation of user and error messages
			
			if (validateUser.equals("SUCCESS"))
			{
					session=request.getSession();
					session.setAttribute("role", role);
					session.setAttribute("username", username);
					request.getRequestDispatcher("/Profile_S.jsp").forward(request, response);
			}
			
			else {
				if (username.equals("ICSI518") && password.equals("Spring2018")) 
				{
					System.out.println(username+""+password);
					if(role.equals("Customer")){
						session=request.getSession();
						session.setAttribute("role", role);
						session.setAttribute("username", username);
						request.getRequestDispatcher("/Profile_C.jsp").forward(request, response);
					}
					else if(role.equals("Supplier")) {
						session=request.getSession();
						session.setAttribute("role", role);
						session.setAttribute("username", username);
						request.getRequestDispatcher("/Profile_S.jsp").forward(request, response);
					}
					System.out.println("correct details");
					
				}
				
				else if (username.equals("") && password.equals("")) {
					request.setAttribute("msg", "Please enter Username & password");
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.include(request, response);
					return;
				}
				else if (username.equals("")) {
					request.setAttribute("msg", "Please enter Username");
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.include(request, response);
					return;
					}
				else if (password.equals("")) {
					request.setAttribute("msg", "Please enter Password");
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.include(request, response);
					return;
					}
				else {
					request.setAttribute("msg", "Incorrect Credentials");
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.include(request, response);
					return;
				}
			}
	}

}
