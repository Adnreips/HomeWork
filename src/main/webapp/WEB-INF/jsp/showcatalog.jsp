
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<a href='catalog'> <- Go back to catalogs list</a>
<h2>${model.nameProduct}</h2>
<h3>params</h3>
<ul>
    <li>Price - ${model.price}</li>
    <li>Manufacturer - ${model.manufacturer}</li>
</ul>
</body>
</html>
