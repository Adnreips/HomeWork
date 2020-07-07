<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>nameProduct</th>
        <th>price</th>
        <th>manufacturer</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="catalog" items="${catalog}">
        <tr>
            <td scope="row">${catalog.id}</td>
            <td>${catalog.nameProduct}</td>
            <td>${catalog.price}</td>
            <td>${catalog.manufacturer}</td>
            <td><a href="${pageContext.request.contextPath}/showcatalog?id=${catalog.id}">Link</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>

<a href='/'> <- Go back to catalogs list</a>
