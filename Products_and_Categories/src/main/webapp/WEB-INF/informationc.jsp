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
<title>Catogery Page </title>
<link rel="stylesheet" href="/css/info.css">
</head>
<body>
<h1> ${onecatogry.name} </h1>
<a href="/">Home</a>

<h1>Add Products :  </h1>
<c:forEach var="c" items="${onecatogry.products}">
<li><c:out value="${c.name}"/></li>


</c:forEach>
<form:form action="/add_category_to_product/${onecatogry.id}" method="post" modelAttribute="categoryp">
 
     <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:select path="name" name="cat">
        <c:forEach items="${allcat}" var="p" >
            <option value="${p.id}" >${p.name}</option>
        </c:forEach>
    </form:select>
    </p>
    
    
    
    <input type="submit" value="Add"/>
</form:form> 
</body>
</html>