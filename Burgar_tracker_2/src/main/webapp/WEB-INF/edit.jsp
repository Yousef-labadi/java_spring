<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Burger</title>
</head>
<body>
<h1>Edit Burger</h1>
<form:form action="/edit/${br1.id}" method="post" modelAttribute="br1">
    <input type="hidden" name="_method" value="put">
     <p>
        <form:label path="burger_name">burger_name</form:label>
        <form:errors path="burger_name"/>
        <form:input path="burger_name"/>
    </p>
    <p>
        <form:label path="rest_name">rest_name</form:label>
        <form:errors path="rest_name"/>
        <form:textarea path="rest_name"/>
    </p>
     <p>
        <form:label path="rate">rate</form:label>
        <form:errors path="rate"/>     
        <form:input type="rate" path="rate"/>
    </p> 
    <p>
        <form:label path="note">note</form:label>
        <form:errors path="note"/>
        <form:input path="note"/>
    </p>
      
    <input type="submit" value="Submit"/>
</form:form>    
    
</body>
</html>