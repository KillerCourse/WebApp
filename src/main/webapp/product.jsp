<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
  <head>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script><style>
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
