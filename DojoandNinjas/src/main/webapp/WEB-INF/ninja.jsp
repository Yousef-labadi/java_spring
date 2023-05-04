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
<title>Add Ninjas</title>
<link rel="stylesheet" type="text/css" href="/css/ninja.css">
</head>
<body>
<h1>New Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
    <p>
        <form:label path="dojo">Dojo</form:label>
        <form:errors path="dojo"/>
        <form:select path="dojo">
        <c:forEach items="${alldojo}" var="ad">
            <option value="${ad.id}">${ad.name}</option>
        </c:forEach>
    </form:select>
    </p>
    <p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:textarea path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">Pages</form:label>
        <form:errors path="age"/>     
        <form:input type="number" path="age"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    

</body>
</html>