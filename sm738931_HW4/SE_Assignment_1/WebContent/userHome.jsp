<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8" />
<title>User Home</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />

<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Poppins%3A400%2C500%2C600%2C700%2C300&#038;ver=4.8.3'
	type='text/css' media='all' />
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Montserrat%3A400%2C700&#038;ver=4.8.3'
	type='text/css' media='all' />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>

<style type="text/css">
body {
	background: url('img/bodybg.png');
}
</style>
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
		<div class="row home_content_wrapper">
			<div class="feature_content col-md-12">
				<div class="two_col-div row">
					<div
						style="font-size: 50px; color: #609084; margin-top: 10%; margin-bottom: 10%; text-align: center">
						<b>Welcome User </b>
					</div>

				</div>

			</div>
		</div>
	</div>
	<a class = "btn btn-primary" href = "Profile_S.jsp"> Back </a>
<form action="LogoutSession" method="post">
        <input type="submit" value="Logout">
        </form>
</body>
</html>
