<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2020
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form:form action="/email" modelAttribute="emailObj" method="post">
      <label>Languages:</label>
      <form:select path="languages" items="${listLang}"></form:select>
      <label>Page size:</label>
      <form:select path="pageSize" items="${listPage}"></form:select>
      <label>Spams Filter:</label>
      <input type="checkbox">emails per page<br>
      <label>Signature:</label>
      <textarea name="signature"></textarea>
      <input type="submit" value="Update">
    </form:form>
  </body>
</html>
