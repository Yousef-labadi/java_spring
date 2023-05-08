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
<title>Home Page</title>
<link rel="stylesheet" href="/css/home.css">
</head>
<body>
<div>
<h1>welcome :  ${this_user.userName} !</h1>
<a href="/logout">Log out</a>
</div>
<div >
<p>Book from everyone's shelves : </p>
<a href="/book/new/${this_user.id}"> + Add a to my shelf!</a>
</div>

	
<table>
  <thead>
    <tr>
      <th>Title</th>
      <th>Author</th>
      <th>User</th>
     
    </tr>
  </thead>
  <tbody>
    <c:forEach var="book" items="${allBooks}">
      <tr>
        <td><a href="/book/${book.id}">${book.title }</td>
        <td>${book.authername }</td>
        <td>${book.user.userName}</td>
      </tr>
    </c:forEach>
      </tbody>
</table>
</body>
</html>