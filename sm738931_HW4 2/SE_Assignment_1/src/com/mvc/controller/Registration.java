package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.signupBean;
import com.mvc.dao.signupDao;
import com.mvc.util.EncryptPassword;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public String username, firstname, lastname, emailid, role, password, pass;
       public String userDB;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		username = request.getParameter("username");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		//emailid = request.getParameter("emailid");
		//role = request.getParameter("role");
		
		password = EncryptPassword.encryption(request.getParameter("password"));
		pass = EncryptPassword.encryption(request.getParameter("pass2"));
		
		signupBean sb = new signupBean();
		sb.setUsername(username);
		sb.setFirstname(firstname);
		sb.setLastname(lastname);
		//sb.setEmailid(emailid);
		//sb.setRole(role);
		sb.setPassword(password);
		sb.setPass2(pass);
		
		signupDao sd = new signupDao();
		userDB = sd.checkUserNameAvailable(sb);
		System.out.println("Encrypted password" + password);
		System.out.println("Encrypted pass" + password);
		
		if(userDB.equals("DUPLICATE"))
		{
			System.out.println("I'm duplicate");
			request.setAttribute("msg", "User Already Exist");
			RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
			rd.include(request, response);
			return;
		}
		else {	
				if (!password.equals(pass)) {
			request.setAttribute("msg", "Please enter same password");
			RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
			rd.include(request, response);
			return;
				}
				else {
					sd.userRegister(username, firstname, lastname, password);
					request.getRequestDispatcher("/Login.jsp").forward(request, response);
					}
			}
		 
		
	}

}
