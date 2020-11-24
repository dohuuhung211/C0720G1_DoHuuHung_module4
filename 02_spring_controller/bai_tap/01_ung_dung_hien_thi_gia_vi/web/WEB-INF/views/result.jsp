<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/23/2020
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="giaVi" items="${giaViList}">
        <p>${giaVi}</p>
    </c:forEach>
</body>
</html>
