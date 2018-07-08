<%@ page import="myObjects.Message" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Market
  Date: 06.07.2018
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forum</title>
</head>
<body>
<h1>Сообщеньки </h1>


<c:forEach items="${chat}" var="item">
    ${item}<br>
    </c:forEach>

<form action="/forum" method="post">
    ${sessionScope.get("forumLogin")}
    <input type="text" name="text">
    <input type="submit" value="отправить">
    <p>тут будет дата</p>
</form>
</body>
</html>
