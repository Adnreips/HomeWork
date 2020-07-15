<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="product" class="project1.lesson15.catalog.Catalog" />
    <c:set target="${product}" property="nameProduct" value="FIRST" />
    <c:set target="${product}" property="price" value="0"/>
<%--    <jsp:setProperty name="product" property="price" value="0" />--%>


<h1>Adding a new product</h1>
<form method="post" action="${pageContext.request.contextPath}/catalog/addproduct" autocomplete="off">
    <div class="form-group">
        <label for="product">NameProduct</label>
        <input name="nameProduct" type="text" class="form-control" id="product" value="<jsp:getProperty name="product" property="nameProduct" />">
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <input name="price" type="text" class="form-control" id="price" value="<jsp:getProperty name="product" property="price" />">
    </div>
    <div class="form-group">
        <label for="manufacturer">Manufacturer</label>
        <input name="manufacturer" type="text" class="form-control" id="manufacturer" value="<jsp:getProperty name="product" property="manufacturer" />">
    </div>
<%--<table cellspacing="5" cellpadding="5" border="1">--%>
<%--    <tr>--%>
<%--        <td align="right">Name Product:</td>--%>
<%--        <td>${product.nameProduct}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td align="right">Price:</td>--%>
<%--        <td>${product.price}</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td align="right">Manufacturer:</td>--%>
<%--        <td>${product.manufacturer}</td>--%>
<%--    </tr>--%>
<%--</table>--%>
    <button type="submit" class="btn btn-primary">Submit</button>

</form>
