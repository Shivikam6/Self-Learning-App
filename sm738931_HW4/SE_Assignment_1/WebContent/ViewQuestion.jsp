<%@ page
	import="com.mvc.controller.*, com.mvc.bean.*, java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8" />
<title>View Question</title>

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
								<a href="ClearHistoryServlet" class="btn btn-sm btn-primary">Clear History</a>				
								<table class="table table-striped table-list" style="border:5px;">
									<thead>
               							<tr>
                						<th></th>
                  						<th>ID</th>
                  						<th>Question</th>
                  						<th>Status</th>
                  						<th>Action</th>
                						</tr>
              						</thead>	
									<tbody>
									<%
										ArrayList<QuestionBean> questions = (ArrayList<QuestionBean>)request.getSession().getAttribute("all_questions");
        								int loopIndex = -1;
          								for (QuestionBean question : questions){
          								loopIndex++;
       								%>
									<%
									if(question.getStatus().equalsIgnoreCase("solved"))
									{
									%>
									<tr>
									<td><input type="checkbox" checked="checked" style='width:20px; height:20px;' id="chk" onclick="return false;"></td>
									<td><%=question.getQues_id()%></td>
									<td><%=question.getQues_name()%></td>
									<td><%=question.getStatus()%></td>
									<td><a href="#" class="btn btn-sm btn-primary" onclick="return false;">Solve</a></td>
									</tr>
									<%
									}
									else if(question.getStatus().equalsIgnoreCase("unsolved"))
									{
									%>
									<tr>
									<td><input type="checkbox" style='width:20px; height:20px;' id="chk" onclick="return false;"></td>
									<td><%=question.getQues_id()%></td>
									<td><%=question.getQues_name()%></td>
									<td><%=question.getStatus()%></td>
									<td>
									<a href="SolveQuestionServlet?qid=<%=question.getQues_id()%>" class="btn btn-sm btn-primary" 
									onclick="check(<%=question.getQues_id() %>);">Solve</a>
									</td>
									</tr>
									<%
									}
          						}
									%>
									</tbody>
							
								</table>
							</div>
            		</div>

			</div>
<a class = "btn btn-primary" href = "Profile_S.jsp"> Main Page </a>
			</div>
		</div>
<script type="text/javascript">
function check(q)
{
	console.log(q);
}
</script>
<form action="LogoutSession" method="post">
        <input type="submit" value="Logout">
        </form></td></tr></table>
        </center>
</body>
</html>
