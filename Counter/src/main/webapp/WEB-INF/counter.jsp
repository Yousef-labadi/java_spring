<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>counter</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

<h1>You have visited <a href="/your_server" >http//your_server </a> <c:out value="${count}"/>  times </h1>
<a href="/your_server"> Test another Visit ? </a>



</body>
</html>