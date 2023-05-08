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
<title>Book Share </title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="h">
<h1>Change Your Entry </h1>
<a href="/home">Back to the shelves</a>

</div>

<div >

<form:form action="/edit/${bk.id}" method="post" modelAttribute="bk">
<input type="hidden" name="_method" value="put">
    <p>
        <form:label path="title">Title: </form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="authername">Auther name</form:label>
        <form:errors path="authername"/>
        <form:textarea path="authername"/>
    </p>
     
    <p>
        <form:label path="thought">My Thought</form:label>
        <form:errors path="thought"/>     
        <form:input  path="thought"/>
    </p>   
    <form:input type="hidden" value="${user_id}" path="user"/>
    
    <input type="submit" value="Add Book"/>
</form:form> 
</div>  

</body>
</html>