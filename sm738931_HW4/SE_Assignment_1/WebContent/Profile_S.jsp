<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Welcome Page</title>
<script> 
				history.forward();
		</script>
</head>
<body background="cust2.jpeg">

<%
if (session.getAttribute("username") == null){
	request.setAttribute("msg", "Session has ended.  Please login.");
	response.sendRedirect("Login.jsp");
	
}
%>
<center>
<br><br><br>
<h1 align = "center"> Welcome <%= session.getAttribute("username") %> </h1>

<form action="LogoutSession" method="post">
        <input type="submit" value="Logout">
        </form>

<h1 align="center">Update Profile</h1>
<form action="Update.jsp" method="post">
        <input type="submit" value="Edit Profile">
        </form>
        <h1 align="center">Create Questions</h1>
        <form action="AddQuestion.jsp" method="post">
<input type="submit" value="Create Questions">
</form><br><h1 align="center">To View Questions</h1>
<a class = "btn btn-primary" href = "ViewQuestionServlet"> View Questions </a>
</center>
</body>
</html>