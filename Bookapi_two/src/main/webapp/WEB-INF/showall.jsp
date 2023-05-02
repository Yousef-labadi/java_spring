<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>
        </tr>
    </thead>
    <tbody>
          <c:forEach var="bk" items="${books}">
          <tr>
          <th><font ><c:out value="${bk.id}"/></font></th>
          <th><font ><a href="/books/${bk.id}"><c:out value="${bk.title}"/></a></font></th>
          <th><font ><c:out value="${bk.language}"/></font></th>
          <th><font ><c:out value="${bk.numberOfPages}"/></font></th>
        
   </c:forEach>
    </tr>
    </tbody>
</table>
</body>
</html>