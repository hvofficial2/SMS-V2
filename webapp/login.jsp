<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Student Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<style>
.jumbotron {
  padding-top: 35px !important;
  padding-bottom: 35px !important;
}
  
</style>
</head>
<body>
<%@include file="header.jsp" %>
<div class= "container">
<h3>Login</h3>
<form action="loginServlet" method="post" class="card">
<table class="table">
	<tr>
		<td><b>User Name</b></td>
		<td><input type="text" name="username" placeholder="Enter Username"></td>
	</tr>
	<tr>
		<td><b>Password</b></td>
		<td><input type="password" name="password" placeholder="Enter Password"></td>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit">Submit</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset">Reset</button>
		</td>
	</tr>
</table>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>