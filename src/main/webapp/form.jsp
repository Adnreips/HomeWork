<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="product" class="project1.lesson15.catalog.Catalog" />
    <c:set target="${product}" property="nameProduct" value="FIRST" />
    <jsp:setProperty name="product" property="price" value="0" />


<h1>Adding a new product</h1>
<form method="post" action="${pageContext.request.contextPath}/addproduct" autocomplete="off">
    <div class="form-group">
        <label for="model">NameProduct</label>
        <input name="nameProduct" type="text" class="form-control" id="model" value="<jsp:getProperty name="product" property="nameProduct" />">
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <input name="price" type="text" class="form-control" id="price" value="<jsp:getProperty name="product" property="price" />">
    </div>
    <div class="form-group">
        <label for="manufacturer">Manufacturer</label>
        <input name="manufacturer" type="text" class="form-control" id="manufacturer" value="<jsp:getProperty name="product" property="manufacturer" />">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

