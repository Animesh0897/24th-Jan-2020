<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Debit Balance</title>
</head>
<body>
<h1>WELCOME TO DEBIT PAGE</h1>
<%String id = (String)session.getAttribute("sid");
if(id==null){
	response.sendRedirect("index.jsp");
}%>
<form method="get" action="DebitBalance">
<b>Enter the balance to DEBIT: </b><input type="text" placeholder="Debit balance" name="debitholder"><br>
<input type="submit" value="Debit" name="debitbutton">

</form>
</body>
</html>