<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Multiple Choice Question</title>
<script>
    history.forward();
</script>
</head>
<body><center><table>
<%
		if (session.getAttribute("username") == null) {	
			response.sendRedirect("Login.jsp");
		}
	%>
               			
               		
<form action="AddQuestionServlet" method="post" class="form-horizontal">
													<div class="login-fields">

					<p style="color: black;">Please enter the details</p>
					<div class="field">
						<label for="question">Question</label> <input type="text"
							id="question" name="ques" value="" placeholder="Question"
							class="login username-field" style="width:400px;" required />
					</div>

					<div class="field">
					<label for="options">Options</label><br>
						<label for="ch1">Choice A</label> <input type="text"
							id="ch1" name="ch1" value="" placeholder="Choice 1"
							class="login username-field" style="width:400px;" required />
					</div>

					<div class="field">
						<label for="ch2">Choice B</label> <input type="text"
							id="ch2" name="ch2" value="" placeholder="Choice 2"
							class="login username-field" style="width:400px;" required />
					</div>
					
					<div class="field">
						<label for="ch3">Choice C</label> <input type="text"
							id="ch3" name="ch3" value="" placeholder="Choice 3"
							class="login username-field" style="width:400px;" required />
					</div>
					
					<div class="field">
						<label for="ch4">Choice D</label> <input type="text"
							id="ch4" name="ch4" value="" placeholder="Choice 4"
							class="login username-field" style="width:400px;" required />
					</div>
					<div class="field">
						<label for="answer">Answer</label> 
						<select	name="ans" class="select-input">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
						</select>
					</div>
					
					<div class="field">
						<label for="hint">Hint</label> <input type="text"
							id="hint" name="hint" value="" placeholder="Hint"
							class="login username-field" style="width:400px;" required />
					</div>				
					
					<!-- /select -->
				</div>
				<!-- /login-fields -->

				<div class="login-actions" style="margin-top: 15px; margin-bottom: 0px;">
					<button type="submit" class="btn btn-success" value="submit">Add</button>
					
					<br/>
					<c:remove var="message" scope="session" />
				</div>
												</form>
												<br><a class = "btn btn-primary" href = "AddQuestion.jsp"> Back </a><br><br>
												<a class = "btn btn-primary" href = "Profile_S.jsp"> Main Page </a><br><br>
		<form action="LogoutSession" method="post">
        <input type="submit" value="Logout">
        </form>
        </center>
</body>
</html>