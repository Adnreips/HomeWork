<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<html>
<body>
<h2>Catalog list</h2>
<a href='addcatalog'> <- Go back to catalogs list</a>
<ul>
    <c:forEach items="${catalog}" var="catalog">
        <li><a href='showcatalog?id=${catalog.id}'>${catalog.nameProduct} > ${catalog.manufacturer}</a></li>
    </c:forEach>
</ul>

</body>
</html>
