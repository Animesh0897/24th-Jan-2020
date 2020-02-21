<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Home</title>
</head>
<body>
<h1>WELCOME TO MENU</h1>
<%String id = (String)session.getAttribute("sid");
if(id==null && request.getSession()==null){
	response.sendRedirect("index.jsp");
}%>
<form method="get" action="Menu">
<b>click to debit balance :		</b><input type="submit" name="debitbalance" value="Debit Balance"><br><br>
<b>click to credit balance :	</b><input type="submit" name="creditbalance" value="Credit Balance"><br><br>
<b>click to view balance :		</b><input type="submit" name="viewbalance" value="View balance"><br><br>
<b>click to transfer balance :	</b><input type="submit" name="fundtransfer" value="Fund Transfer"><br><br>
<b>click to view transactions:	</b><input type="submit" name="viewtransactions" value="View all transactions"><br><br>
<b>click to logout :			</b><input type="submit" name="logout" value="Log out"><br>
</form>
<p>${message}</p>
</body>
</html>