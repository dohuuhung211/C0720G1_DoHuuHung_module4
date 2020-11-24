<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/23/2020
  Time: 9:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h2>Calculator</h2>
    <form action="/calculator">
      <input type="number" name="num1">
      <input type="number" name="num2">
      <button type="submit" value="add" name="operator">Addition(+)</button>
      <button type="submit" value="sub" name="operator">Subtraction(-)</button>
      <button type="submit" value="mul" name="operator">Multiplication(*)</button>
      <button type="submit" value="div" name="operator">Division(/)</button>
    </form>
    <p>${result}</p>
  </body>
</html>
