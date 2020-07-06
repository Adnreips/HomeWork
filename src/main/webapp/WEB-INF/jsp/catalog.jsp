<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Catalog list</h2>

<ul>
    <c:forEach items="${catalog}" var="catalog">
        <li><a href='showcatalog?id=${catalog.id}'>${catalog.nameProduct}</a></li>
    </c:forEach>
</ul>

</body>
</html>
