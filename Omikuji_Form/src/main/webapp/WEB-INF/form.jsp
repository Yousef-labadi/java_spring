<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>Send an Omikuji!</h3>
    <form action='/handel' method='POST'>
   <p> <label>pICK Any number from 5 to 25 :</label>
        <input type="number" name='num'></p>
    <p><label>Enter the name of any city : </label>
        <input type='text' name='city'></p>
   <p> <label>Enter the name of any real person : </label>
        <input type='text' name='person'></p>
   <p> <label>Enter professional endeavor or hobby : </label>
        <input type='text' name='hobby'></p>
   <p> <label>Enter any type of living thing :  </label>
        <input type='text' name='living'></p>
   <p> <label>say something nice to someone :  </label>
        <textarea name="comm" rows="4" cols="50"></textarea></p>
    <p>  <label>send and show a friend   </label></p>
        <input type='submit' value='send'>
    </form>
    
</body>
</html>