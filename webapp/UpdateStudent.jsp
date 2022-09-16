<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page errorPage="Error.jsp" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<style>
.jumbotron {
  padding-top: 35px !important;
  padding-bottom: 35px !important;
}
  
</style>
</head>
<body>
<a href="logoutServlet" style="float: right;">Logout</a>
<%@include file="header.jsp" %>
<div class= "container">
<h3>Update Student</h3>
<form action="StudentController" method="post" class="card">
<input type="hidden" name="command" value="UPDATE">
<input type="hidden" name="id" value="${student.getId()}">
<table class="table">
	<tr>
		<td><b>First Name</b></td>
		<td><input type="text" name="first_name" value="${student.getFirst_name()}"></td>
	</tr>
	<tr>
		<td><b>Last Name</b></td>
		<td><input type="text" name="last_name" value="${student.getLast_name()}"></td>
	</tr>
	<tr>
		<td><b>Email Address</b></td>
		<td><input type="email" name="email" value="${student.getEmail()}"></td>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit">Submit</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	</tr>
</table>
</form>
<a href="StudentController">All Student List</a>
</div>
<%@include file="footer.jsp" %>
</body>
</html>