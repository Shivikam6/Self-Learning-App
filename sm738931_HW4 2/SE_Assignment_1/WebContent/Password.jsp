<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
</head>
<body>
<body background="cust2.jpeg">
	<% 
		out.println("<h1 align = \"center\"> Change Password!</b></h1>");
	%>
	<center>
	<form action="PasswordCheck" method="post">
    			 <h2>Please enter your previous password and the new password</h2>
    			<table>
		<tr><td align="right">
			<h3>Username:<input type="text" name="username" placeholder = "Enter Username"> <br/></h3>
    			<h3>Previous Password:<input type="password" name="password" placeholder = "Enter Password"> <br/></h3>
    			<h3>New Password:<input type="password" name="pass1" placeholder = "Enter new Password"> <br/></h3>
    			<h3>Confirm New Password:<input type="password" name="pass2" placeholder = "Confirm Password"> <br/></h3>
    			<input type="submit" value="SUBMIT" ">
    		</td></tr>
     </table>
     <h3 style="color: red;">
						 ${msg} 
					</h3>
					</form>
					<a class = "btn btn-primary" href = "Login.jsp"> Back </a>
   </center> 		
</body>
</html>