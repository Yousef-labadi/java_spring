<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
<link rel="stylesheet" href="/css/show.css">
</head>
<body>
<div class="container">
<div class="header">
<h2> Create Project </h2>
<a href="/home"> Back</a>



</div>
<div class="information">
<h2> Project Title : ${p.title }</h2>
<h2> Project Title : ${p.description }</h2>
<h2> Project Title : ${p.duedate }</h2>


</div>
</div>
</body>
</html>