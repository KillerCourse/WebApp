<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
    <jsp:include page="headerPage.jsp"/>
</head>

<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Red balloons shop</h1>
    <p class="lead">Some text.</p>
</div>
<div class="container">
    <c:forEach var="rowIndex" begin="0" end="${(products.size() - 1)/3}">
        <div class="row">
            <c:forEach var="columnIndex" begin="0" end="2">
                <c:set var="productIndex" value="${rowIndex*3 + columnIndex}"/>
                <c:set var="product" value="${products.get(productIndex)}"/>
                <div class="col-4">
                    <div class="card-deck mb-3 text-center">
                        <div class="card mb-4 box-shadow">
                            <div class="card-header">
                                <h4 class="my-0 font-weight-normal">Balloon <fmt:formatNumber
                                        value="${product.diameter}"
                                        maxFractionDigits="0"/></h4>
                            </div>
                            <div class="card-body">
                                <h1 class="card-title pricing-card-title">${product.price}$ <small class="text-muted">/
                                    unit</small>
                                </h1>
                                <ul class="list-unstyled mt-3 mb-4">
                                    <li>diameter ${product.diameter}</li>
                                    <li>weight ${product.weight}</li>
                                    <li>name ${product.name}</li>
                                    <li>quantity ${product.quantity}</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:forEach>
</div>

<footer class="pt-4 my-md-5 pt-md-5 border-top">
    <div class="row">
        <div class="col-12 col-md">
            <img class="mb-2" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt=""
                 width="24" height="24">
            <small class="d-block mb-3 text-muted">&copy; 2017-2018</small>
        </div>
        <div class="col-6 col-md">
            <h5>Features</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Cool stuff</a></li>
                <li><a class="text-muted" href="#">Random feature</a></li>
                <li><a class="text-muted" href="#">Team feature</a></li>
                <li><a class="text-muted" href="#">Stuff for developers</a></li>
                <li><a class="text-muted" href="#">Another one</a></li>
                <li><a class="text-muted" href="#">Last time</a></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Resource</a></li>
                <li><a class="text-muted" href="#">Resource name</a></li>
                <li><a class="text-muted" href="#">Another resource</a></li>
                <li><a class="text-muted" href="#">Final resource</a></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>About</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="#">Team</a></li>
                <li><a class="text-muted" href="#">Locations</a></li>
                <li><a class="text-muted" href="#">Privacy</a></li>
                <li><a class="text-muted" href="#">Terms</a></li>
            </ul>
        </div>
    </div>
</footer>
</div>
</body>
</html>
