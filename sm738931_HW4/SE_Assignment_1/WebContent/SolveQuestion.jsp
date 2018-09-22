<%@ page
	import="com.mvc.controller.*, com.mvc.bean.*, java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8" />
<title>Solve!</title>

</style>
</head>

<body class="home blog">
<%
		if (session.getAttribute("username") == null) {	
			response.sendRedirect("Login.jsp");
		}

	%>
		<div class="row home_content_wrapper">
			<div class="feature_content col-md-12">
			<h5 style="color: red;">
						 ${msg1} 
					</h5>
			<center><table>
               			<tr><td align="right">
				<div class="two_col-div row">
				<div><h4 style="color: red;">
						 ${msg1} 
					</h4></div>
					<div style="width: 90%; margin-right: 5%; margin-left: 5%; text-align: center;">											
							<div id="questions">
							<%
							QuestionBean ques = (QuestionBean) request.getSession().getAttribute("ques");
							int flag=0;
							if(ques.getCh1()== null || ques.getCh2()==null)
							{
								flag=1;
							}
							%>
								<form action="AnswerFeedbackServlet" method="post">
								<div class="login-fields">
								<%
								if(flag==0)
								{
								%>
									<div class="field">
									<label for="question">Question</label> <input type="text" class="login username-field" name="question" 
									value="<%=ques.getQues_name()%>" readonly="readonly" required />
									</div>
									<div class="field">
									<label for="question">Choice A</label> <input type="text" class="login username-field" name="question" 
									value="<%=ques.getCh1()%>" readonly="readonly" required />
									</div>
									<div class="field">
									<label for="question">Choice B</label> <input type="text" class="login username-field" name="question" 
									value="<%=ques.getCh2()%>" readonly="readonly" required />
									</div>
									<div class="field">
									<label for="question">Choice C</label> <input type="text" class="login username-field" name="question" 
									value="<%=ques.getCh3()%>" readonly="readonly" required />
									</div>
									<div class="field">
									<label for="question">Choice D</label> <input type="text" class="login username-field" name="question" 
									value="<%=ques.getCh4()%>" readonly="readonly" required />
									</div>
									<div class="field">
									<label for="answer">Answer</label> 
									<select	name="answer" class="select-input">
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									</select>
									</div>
									<div class="login-actions" style="margin-top: 15px; margin-bottom: 0px;">
									<a href="ViewQuestionServlet" class="btn btn-sm btn-primary">Back</a>
									<button type="submit" class="btn btn-success" value="submit">Submit</button>
									</div>
								<%
								}
								else
								{
								%>
									<div class="field">
									<label for="question">Question</label> <input type="text" class="login username-field" name="question" 
									value="<%=ques.getQues_name()%>" readonly="readonly" required />
									</div>
									<div class="field">
									<label for="answer">Answer</label> <input type="text" class="login username-field" name="answer" 
									placeholder="Enter the answer" required />
									</div>
									<div class="login-actions" style="margin-top: 15px; margin-bottom: 0px;">
									<a href="ViewQuestionServlet" class="btn btn-sm btn-primary">Back</a>
									<button type="submit" class="btn btn-success" value="submit">Submit</button>
									</div>					
								
								<%
								}
       							%>
					</div>
				</form>
							</div>
            		</div>

			</div>
<a class = "btn btn-primary" href = "Profile_S.jsp"> Main Page </a>
			</div>
<form action="LogoutSession" method="post">
        <input type="submit" value="Logout">
        </form><center><table>
               			<tr><td align="right">
</body>
</html>
