<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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
    <p> Diameter: ${product.diameter} </p>
    <p> Weight: ${product.weight} </p>
    <p> Quantity: ${product.quantity} </p>
    <p> Price: ${product.price} </p>
    <p> Name: ${product.name} </p>
    <p> Description: ${product.description} </p>

  </body>
</html>
