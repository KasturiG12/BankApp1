<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%out.println("<b>Hello</b> "+session.getAttribute("NAME")+"  ,<b>you have successfully logged in.</b>");%>
<table>
<tr><td><a href="Transfer.jsp">Third party transfer</a></br></td></tr>
<tr><td><a href="BalanceController">Check Balance</a></br></td></tr>
<tr><td><a href="Loan.jsp">Apply Loan</a></br></td></tr>
<tr><td><a href="ChangePassword.jsp">Change Password</a></br></td></tr>
<tr><td><a href="StatementController">Mini Statement</a></br></td></tr>
<tr><td><a href="">LOGOUT</a></br></td></tr>
</table>
</body>
</html>