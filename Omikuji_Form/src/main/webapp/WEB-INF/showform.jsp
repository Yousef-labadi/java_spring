<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>In <c:out value="${num}"/>years ,you will live in<c:out value="${city}"/> with <c:out value="${person}"/>as your roommate, <c:out value="${hobby}"/> for a living .</p>
<p> The next time you see a <c:out value="${living}"/> , you will have a good luck.</p>
<p>also <c:out value="${comm}"/> </p>

</body>
</html>