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
<link rel="stylesheet" href="/css/dashbord.css">
</head>
<body>
  <div class="flex-container">
    <div class="flex-item">
      <div class="header">
        <h1>${onebk.title}</h1>
        <a href="/home">Back to the shelves</a>
      </div>
      <div class="information">
        <c:if test="${onebk.user.id==this_user.id }">
          <p>You read ${onebk.title} and here are your thoughts:</p>
        </c:if>
        <c:if test="${onebk.user.id!=this_user.id }">
          <p>${this_user.userName} read ${onebk.title} by ${onebk.authername}</p>
        </c:if>
      </div>
      <hr>
      <div class="bottom">
        <p>${onebk.thought}</p>
        <hr>
        <c:if test="${onebk.user.id==this_user.id }">
          <a href="/edit/${onebk.id}">Edit</a> |
          <a href="/delete/${onebk.id}">Delete</a>
        </c:if>
      </div>
    </div>
  </div>
</body>


</body>
</html>