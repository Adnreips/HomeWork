<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: "Andrei Prokofiev"
  Date: 04.07.2020
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<%--<head>--%>
<%--    <title>Catalog</title>--%>
<%--</head>--%>
<body>
<h2>Catalog list</h2>

<ul>
    <c:forEach items="${catalog}" var="catalog">
        <li><a href='showcatalog?id=${catalog.id}'>${catalog.nameProduct}</a></li>
    </c:forEach>
</ul>
</body>
</html>
