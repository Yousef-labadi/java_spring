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
<link rel="stylesheet" href="/css/userform.css">
</head>
<body>
<div class="container"><div class="box">
<h1>register</h1>
<form:form action="/register" method="post" modelAttribute="newUser">
    <p>
        <form:label path="first_name">First Name : </form:label>
        <form:errors path="first_name"/>
        <form:input path="first_name"/>
    </p>
      <p>
        <form:label path="last_name">Last Name : </form:label>
        <form:errors path="last_name"/>
        <form:input path="last_name"/>
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:errors path="email"/>
        <form:textarea path="email"/>
    </p>
     
    <p>
        <form:label path="password">password</form:label>
        <form:errors path="password"/>     
        <form:input type="password" path="password"/>
    </p>   
    <p>
        <form:label path="confirm">Confirm PW </form:label>
        <form:errors path="confirm"/>     
        <form:input type="password" path="confirm"/>
    </p>  
    <input type="submit" value="Registration"/>
</form:form> 
</div>   
<div class="box">
<h1>log in</h1>
<form:form action="/login" method="post" modelAttribute="newLogin">
    <p>
        <form:label path="email">User email : </form:label>
        <form:errors path="email"/>
        <form:input path="email"/>
    </p>
     <p>
        <form:label path="password">password</form:label>
        <form:errors path="password"/>     
        <form:input type="password" path="password"/>
    </p>   
        <input type="submit" value="login"/>
</form:form>  
</div></div>

</body>
</html>