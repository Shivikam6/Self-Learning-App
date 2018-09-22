<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Numeric Question</title>
<script>
    history.forward();
</script>
</head>
<body><%
		if (session.getAttribute("username") == null) {	
			response.sendRedirect("Login.jsp");
		}
	%>
<table>
               <center>		<tr><td align="right">
	<form action="AddQuestionServlet" method="get" class="form-horizontal">
													<div class="login-fields">

					<p style="color: black;">Please enter the details</p>
					<div class="field">
						<label for="question">Question</label> <input type="text"
							id="question" name="ques1" value="" placeholder="Question"
							class="login username-field" style="width:400px;" required />
					</div>

					<div class="field">
						<label for="answer">Answer</label> <input type="text"
							id="ans" name="ans1" value="" placeholder="Answer"
							class="login username-field" style="width:400px;" required />
					</div>

					<div class="field">
						<label for="hint">Hint</label> <input type="text"
							id="hint" name="hint1" value="" placeholder="Hint"
							class="login username-field" style="width:400px;" required />
					</div>
										
					<!-- /select -->
				</div>
				<!-- /login-fields -->

				<div class="login-actions" style="margin-top: 15px; margin-bottom: 0px;">
					<button type="submit" class="btn btn-success" value="submit">Add</button>
					
					<br/>
				</div>
			</form>
			<br><a class = "btn btn-primary" href = "AddQuestion.jsp"> Back </a><br>
			<a class = "btn btn-primary" href = "Profile_S.jsp"> Main Page </a>
			<form action="LogoutSession" method="post">
        <input type="submit" value="Logout">
        </form></td></tr></table>
        </center>
</body>
</html>