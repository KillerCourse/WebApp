<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

<h2>Product List</h2>
<p>Table</p>

<table class="table-warning table-bordered" style="width:50%">


  <tr class="table-warning table-bordered">
    <th>Product</th>
    <th>Id</th>
    <th>Diameter</th>
  </tr>
   <c:forEach var="product" items="${products}">
     <tr class="table-warning">
       <td><c:out value="${product.name}"/></td>
       <td><c:out value="${product.id}"/></td>
       <td><c:out value="${product.diameter}"/></td>
     </tr>
 </c:forEach>
</table>

</body>
</html>
