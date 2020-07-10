<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%--<html>--%>
<%--<body>--%>
<a href='catalog'> <- Go back to catalogs list</a>
<%--<h2>${model.nameProduct}</h2>--%>
<%--<h3>params</h3>--%>
<%--<ul>--%>
<%--    <li>Price - ${model.price}</li>--%>
<%--    <li>Manufacturer - ${model.manufacturer}</li>--%>
<%--</ul>    --%>
<ul class="list-group">
    <li class="list-group-item">${product.id}</li>
    <li class="list-group-item">${product.nameProduct}</li>
    <li class="list-group-item">${product.price}</li>
    <li class="list-group-item">${product.manufacturer}</li>
</ul>

<%--</body>--%>
<%--</html>--%>
