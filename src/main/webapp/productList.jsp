<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>

<h2>Product List</h2>
<p>Table</p>

<table style="width:50%">


  <tr>
    <th>Product</th>
    <th>Id</th>
    <th>Diameter</th>
  </tr>
   <c:forEach var="product" items="${products}">
     <tr>
       <td><c:out value="${product.name}"/></td>
       <td><c:out value="${product.id}"/></td>
       <td><c:out value="${product.diameter}"/></td>
     </tr>
 </c:forEach>
</table>

</body>
</html>
