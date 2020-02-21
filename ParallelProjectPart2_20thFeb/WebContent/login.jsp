<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>WELCOME TO PAYMENTS BANK LOGIN PAGE</h1>
<%String id = (String)session.getAttribute("sid");
if(id!=null){
	response.sendRedirect("Menu.jsp");
}%>
<form method="post" action="login">
<b>Enter Pin:	</b> <input type="text" placeholder="Enter your pin" name="uniqueid"><br><br>
<b>Password:	</b> <input type="text" placeholder="Enter your password" name="password"><br>
<input type="submit" value="Login" name="loginaccount">
</form>
<p>${message}</p>
</body>
</html>