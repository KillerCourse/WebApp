<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println(request);
    System.out.println(request.getAttribute("asd"));

 %>


<html>
  <head>
  </head>
  <body>
    <h2>Red Ball</h2>
    <p>Diameter ##</p>
    <p>Weight ##</p>
    <p>Quantity In Stock ##</p>
    <p>Price Per Unit ##</p>
    <h3> Product information: </h3>
    <p> Id: ${product.id} </p>
    <p> smth: ${requestScope.asd} </p>


  </body>
</html>
