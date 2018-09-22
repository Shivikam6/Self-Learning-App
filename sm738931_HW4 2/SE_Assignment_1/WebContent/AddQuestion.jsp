<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8" />
<title>Add New</title>
<script>
    history.forward();
</script>
</head>

<body class="home blog">

	<%
		if (session.getAttribute("username") == null) {	
			response.sendRedirect("Login.jsp");
		}
	%>

		
			<h5 style="color: red;">
						 ${msg1} 
					</h5>
			
				<div class="two_col-div row">
				
					<div class="tabbable">
							<ul class="nav nav-tabs">
								<li class="active"><a href="AddMCQuestion.jsp" data-toggle="tab">Multi-Choice Question</a></li>
								<li><a href="AddNumQuestion.jsp" data-toggle="tab">Numerical Question</a></li>
							</ul>
						<br>
					
				</div>
			</div>
			<a class = "btn btn-primary" href = "Profile_S.jsp"> Main Page</a><br><br>
<form action="LogoutSession" method="post">
        <input type="submit" value="Logout">
        </form>
</body>
</html>
