<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Profile</title>
</head>
<body background="signup.jpg">
<center>
<h1 align = "center"> Welcome <%= session.getAttribute("username") %> </h1>
<br> <h1> Please update your details</h1>

<form action="EditProfile" method="post">

	<h3>First Name:<input type="text" name="firstname" placeholder="Enter First Name" required> <br/></h3>
	<h3>Last Name:<input type="text" name="lastname" placeholder="Enter Last Name" required> <br/></h3>
    <h3>Current Password:<input type="password" name="password" placeholder="Current Password" required> <br/></h3>
    <input type="submit" value="Update">
    <h3 style="color: red;">
						 ${msg} 
					</h3>
   </form>
   <a class = "btn btn-primary" href = "Login.jsp"> Back </a>
</center>
</body>
</html>