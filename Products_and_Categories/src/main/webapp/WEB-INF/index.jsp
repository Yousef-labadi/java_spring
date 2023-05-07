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
<title>Home</title>
<link rel="stylesheet" href="/css/home.css">
</head>
<body>
<div><h1>Home Page</h1></div>
<div class="a">
<a href="/products/new" >New Product</a>
<a href="/category/new" >New Category</a>
</div>
<div class="box">
<div >
<h2>Products</h2>
<c:forEach var="p" items="${allproduct}">
<li><a href="/showp/${p.id }"><c:out value="${p.name}"/></a></li>
</c:forEach>
</div>
<div >
<h2>Categorys</h2>
<c:forEach var="c" items="${allcategory}">
<li><a href="/showc/${c.id }"><c:out value="${c.name}"/></a> </li>
</c:forEach>
</div>
</div>



</body>
</html>