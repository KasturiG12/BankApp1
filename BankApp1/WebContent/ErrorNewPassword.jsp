<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>NewPassword and Confirm-New Password are not matching.Please try again!!!</h1>
<form action="NPController">
<table>
<tr>
<td>New Password</td>
<td><input type="password" name="newpassword" required/></td>
</tr>
<tr>
<td>Confirm New Password</td>
<td><input type="password" name="confirmnewpassword" required/></td>
</tr>
<tr>
<td><input type="submit" value="SUBMIT"/></td>
</tr>
</table>
</form>
</body>
</html>