<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
</head>
<body>
<h1>WELCOME TO FUND TRANSFER</h1>
<%String id = (String)session.getAttribute("sid");
if(id==null){
	response.sendRedirect("index.jsp");
}%>
<form method="get" action="FundTransfer">
<b>Reciever ID: 		</b><input type="text" placeholder="Unique ID" name="receiverid"><br><br>
<b>Balance to transfer: </b> <input type="text" placeholder="Transfer money" name="balancetransfer"><br>
<input type="submit" value="Transfer" name="transferbutton">
</form>
</body>
</html>