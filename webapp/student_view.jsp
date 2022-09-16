<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page errorPage="Error.jsp" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
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
<form action="StudentController" method="post">
	<input type="hidden" name="command" value="SEARCH">
	<input type="text" name="name" placeholder="Search Student by Name">
	<button type="submit">Search</button>
	<input type="button" value="Add Student" onclick="window.location.href='AddStudent'" style="float: right;"/>
</form>
</br>
<div class="card">
<table class="table table-hover">
	<tr>
		<th>Id</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Action</th>
	</tr>
	<c:forEach var="student" items="${students}">
		<c:url var="tempLink1" value="StudentController">
			<c:param name="id" value="${student.getId()}"/>
			<c:param name="command" value="LOAD"/>
		</c:url>
		<c:url var="tempLink2" value="StudentController">
			<c:param name="id" value="${student.getId()}"/>
			<c:param name="command" value="DELETE"/>
		</c:url>
		<tr>
			<td>${student.getId()}</td>
			<td>${student.getFirst_name()}</td>
			<td>${student.getLast_name()}</td>
			<td>${student.getEmail()}</td>
			<td><a href="${tempLink1}">Edit</a> |
				<a href="${tempLink2}" onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>
</div>
<a href="StudentController">All Student List</a>
</div>
<%@include file="footer.jsp" %>
</body>
</html>