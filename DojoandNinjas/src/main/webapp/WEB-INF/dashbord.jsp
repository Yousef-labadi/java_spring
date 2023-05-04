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
<title>Dashbord </title>
<link rel="stylesheet" type="text/css" href="/css/dashbord.css">
</head>
<body>
<h1>${dojo.name} Location Ninjas</h1>

        <table>
  <thead>
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
    </tr>
  </thead>
   <tbody>
    <c:forEach items="${dojo.ninjas}" var="n">
      <tr>
        <td><c:out value="${ n.firstName}" > </c:out></td>
        <td><c:out value="${ n.lastName}" > </c:out></td>
        <td><c:out value="${ n.age}" > </c:out></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>