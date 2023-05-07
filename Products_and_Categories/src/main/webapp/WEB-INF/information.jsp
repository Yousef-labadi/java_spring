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
<title>Product Page </title>
<link rel="stylesheet" href="/css/info.css">
</head>
<body>
<h1> ${oneproduct.name}</h1>
<a href="/">Home</a>
<h1>Add Category :  </h1>
<c:forEach var="p" items="${oneproduct.categories}">
<li><c:out value="${p.name}"/></li>

</c:forEach>
<form:form action="/add_prod_to_category/${oneproduct.id}" method="post" modelAttribute="productc">
 
     <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:select path="name">
        <c:forEach items="${allcat}" var="a">
            <option value="${a.id}">${a.name}</option>
        </c:forEach>
    </form:select>
    </p>
    
    <input type="submit" value="Add"/>
</form:form> 
</body>
</html>