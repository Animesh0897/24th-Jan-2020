<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body>
<h1>WELCOME TO CREATE ACCOUNT PAGE</h1>
<%String id = (String)session.getAttribute("sid");
if(id!=null){
	response.sendRedirect("Menu.jsp");
}%>
<form method="post" action="CreateAccount">
Name: 			  <input type="text" placeholder="Enter your name" name="name"><br><br>
Password: 		  <input type="text" placeholder="Enter your password" name="password"><br><br>
Pin: 			  <input type="text" placeholder="Enter your Pin" name="uniqueid"><br><br>
Starting Balance: <input type="text" placeholder="Enter your starting balance" name="startingbalance"><br>
			<input type="submit" value="Create Account" name="createaccount">
</form>
</body>
</html>