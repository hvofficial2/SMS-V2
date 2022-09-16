<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<style>
img {
   height: 80%;
   width: 80%;
   object-fit: cover;
  }
.jumbotron {
  padding-top: 35px !important;
  padding-bottom: 35px !important;
}
.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
  
</style>
</head>
<body>
<%@include file="header.jsp" %>
<div class= "container">
<div class="center">
<h3>Sorry, Something Went Wrong! Please Try Again</h3>
<img src="opps.png" />
<h5><center><a href="login">Login Again</a></center></h5>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>