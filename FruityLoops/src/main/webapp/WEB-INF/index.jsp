<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Loops</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

 
    
    <table>
  <tr>
    <th>name</th>
    <th>price</th>
    
  </tr>
  <c:forEach var="i" items="${fruits}">
  <tr>
    <td><p><c:out value="${i.name}"></c:out></p></td>
    <td><p><c:out value="${i.price}"></c:out></p></td>
    
  </tr>
      </c:forEach>

</table>
</body>
</html>