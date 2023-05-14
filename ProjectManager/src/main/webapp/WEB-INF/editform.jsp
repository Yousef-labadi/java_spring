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
<link rel="stylesheet" href="/css/projectform.css">
</head>
<body>
<h2> Create Project</h2>
<form:form action="/edit/${editproj.id }" method="post" modelAttribute="editproj">
<input type="hidden" name="_method" value="put">
    <p>
        <form:label path="title">title : </form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
   
    <p>
        <form:label path="description">description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
     
    <p>
        <form:label path="duedate">password</form:label>
        <form:errors path="duedate"/>     
        <form:input type="date" path="duedate"/>
    </p>   
     <form:input type="hidden" path="lead" value="${user.id }"/>
     <form:input type="hidden" path="users" value="${user.id }"/>
    <input type="submit" value="Edit Project"/>
</form:form> 
  

<hr>
<a href ="/delete/${editproj.id }">Delete</a>
</body>
</html>