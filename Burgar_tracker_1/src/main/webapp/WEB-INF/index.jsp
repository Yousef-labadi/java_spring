<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h1>All Burger</h1>
<table>
    <thead>
        <tr>
            
            <th>Burger Name</th>
            <th>Resturant Name</th>
            <th>Rate</th>
            
        </tr>
    </thead>
    <tbody>
         <c:forEach var="br" items="${br}">
          <tr>
          
          
          <th><font ><c:out value="${br.burger_name}"/></font></th>
          <th><font ><c:out value="${br.rest_name}"/></font></th>
          <th><font ><c:out value="${br.rate}"/></font></th>
          
        
   </c:forEach>
    </tr>
    </tbody>
</table>
</div>
<h1>Add a Burger : </h1>
<form:form action="/burger" method="post" modelAttribute="burger">
    <p>
        <form:label path="burger_name">burger_name</form:label>
        <form:errors path="burger_name"/>
        <form:input path="burger_name"/>
    </p>
    <p>
        <form:label path="rest_name">rest_name</form:label>
        <form:errors path="rest_name"/>
        <form:textarea path="rest_name"/>
    </p>
     <p>
        <form:label path="rate">rate</form:label>
        <form:errors path="rate"/>     
        <form:input type="rate" path="rate"/>
    </p> 
    <p>
        <form:label path="note">note</form:label>
        <form:errors path="note"/>
        <form:input path="note"/>
    </p>
      
    <input type="submit" value="Submit"/>
</form:form>    

</body>
</html>