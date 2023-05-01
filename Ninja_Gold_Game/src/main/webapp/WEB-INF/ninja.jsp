<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="head">
<h1>Your Gold :<c:out value="${sum}"/> </h1>

<h1><a href="/reset"> Play Again</a></h1>
</div>


<div class="form">
<div class="form1"><form action="/gold_handel" method="POST">
<p>Farm</p>
 <input type="hidden" name="which_form" value="farm">
       
 <p>(earns 10-20 gold)</p>       
        
 <input type="submit" value="Find Gold!">
    </form></div>
<div class="form1"><form action="/gold_handel" method="POST">
<p>Cave</p>
 <input type="hidden" name="which_form" value="cave">
       
 <p>(earns 5-10 gold)</p>       
        
 <input type="submit" value="Find Gold!">
    </form></div>
<div class="form1">     <form action="/gold_handel" method="POST">
<p>House</p>
 <input type="hidden" name="which_form" value="house">
       
 <p>(earns 5-10 gold)</p>       
        
 <input type="submit" value="Find Gold!">
    </form></div>
<div class="form1">          <form action="/gold_handel" method="POST">
<p>Quest</p>
 <input type="hidden" name="which_form" value="quest">
       
 <p>(earns/takes 0-50 gold)</p>       
        
 <input type="submit" value="Find Gold!">
    </form></div>
    
 



</div>
<div class="activity">
<h2>activity:</h2>
 <c:forEach var="a" items="${myactivity}">
<p> <c:out value="${a}"/> </p>
</c:forEach>
</div>
</body>
</html>