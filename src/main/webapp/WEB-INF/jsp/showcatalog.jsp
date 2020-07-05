<%--
  Created by IntelliJ IDEA.
  User: "Andrei Prokofiev"
  Date: 04.07.2020
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<body>
<a href='catalog'> <- Go back to catalogs list</a>
<h2>${model.nameProduct}</h2>
<h3>params</h3>
<ul>
    <li>Price - ${model.price}</li>
    <li>Manufacturer country - ${model.prodСountry}</li>
</ul>

</body>
</html>
