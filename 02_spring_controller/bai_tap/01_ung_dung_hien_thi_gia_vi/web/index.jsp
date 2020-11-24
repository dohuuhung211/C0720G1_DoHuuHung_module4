<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/23/2020
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h2>Sandwich Condiments</h2>
  <form action="/sandwich">
    <label>Lettuce</label>
    <input type="checkbox" name="check" value="lettuce">
    <label>Tomato</label>
    <input type="checkbox" name="check" value="tomato">
    <label>Mustard</label>
    <input type="checkbox" name="check" value="mustard">
    <label>Sprouts</label>
    <input type="checkbox" name="check" value="sprouts">
    <hr>
    <button type="submit">Save</button>
  </form>
  </body>
</html>
