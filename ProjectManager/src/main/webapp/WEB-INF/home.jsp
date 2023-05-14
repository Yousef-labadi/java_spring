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
<title>Project Manager Dashbord</title>
<link rel="stylesheet" href="/css/dashbord.css">
</head>
<body>
<div class="container">
<h1>welcome  ${this_user.first_name }</h1>
<a href="/logout">LogOut</a>
</div>
<hr>
<div class="container">
<h2>All Projects</h2>
<a href="/projects/new">+ new project</a>

</div>
<hr>
<div class="tabel">
<table>
  <thead>
    <tr>
      <th>Project </th>
      <th>Team Lead</th>
      <th>Due Date</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach items="${notcontain}" var="p">
  
   <tr>
   <th><a href="/show/${p.id }"><c:out value="${p.title }" /></a></th>
  <th> <c:out value="${p.lead.first_name }" /></th>
   
   <th><fmt:formatDate value="${p.duedate}" pattern="MMM dd" /></th>
    <th><a href="/join/${ p.id}">Join</a></th>
   
    </tr>
  

</c:forEach>

 </tbody>
</table>
</div>
<div class="tabel">
<table>
  <thead>
    <tr>
      <th>Project </th>
      <th>Team Lead</th>
      <th>Due Date</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach items="${contain}" var="p">
  
   <tr>
   <th><a href="/show/${p.id }"><c:out value="${p.title }" /></a></th>
  <th> <c:out value="${p.lead.first_name }" /></th>
   
   <th><fmt:formatDate value="${p.duedate}" pattern="MMM dd" /></th>
   <c:if test="${p.lead.id==this_user.id }">
    <th><a href="/edit/${p.id}">Edit</a></th>
   </c:if>
   <c:if test="${p.lead.id!=this_user.id }">
    <th><a href="/leave/${ p.id}">leave</a></th>
   </c:if>
    </tr>
  

</c:forEach>

 </tbody>
</table>
</div>

</body>
</html>