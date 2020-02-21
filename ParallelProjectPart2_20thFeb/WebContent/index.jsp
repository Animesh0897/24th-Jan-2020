<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>WELCOME TO MAIN MENU</h1>
<%String id = (String)session.getAttribute("sid");
if(id!=null){
	response.sendRedirect("Menu.jsp");
}%>
<form method="get" action="StartIndex">
<b>Create account:			 </b><input type="submit" name="addAccount" value="Create Account"><br><br>
<b>Login to existing account:</b><input type="submit" name="loginAccount" value="Login"><br><br>
<b>View all users: 			 </b><input type="submit" name="viewUsers" value="View All Users"><br><br>
<b>Exit	</b><input type="submit" name="exit" value="Exit"><br>
</form>
<p>${message}</p>
</body>
</html>