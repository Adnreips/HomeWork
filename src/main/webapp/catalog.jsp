<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<link href="/css/styles.css" rel="stylesheet" type="text/css">

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
            <td><a href="${pageContext.request.contextPath}catalog/showcatalog?id=${catalog.id}">Link</a></td>
            <td><a href="${pageContext.request.contextPath}catalog/deletproduct?id=${catalog.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Go add new product!
    </div>
    <form  action="/catalog/addproduct">
                <input type="submit" value="Add new product">
    </form>
</div>
<%--    <a href='/addproduct'> <- Go add new product</a>--%>
