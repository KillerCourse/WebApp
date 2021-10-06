<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--@elvariable id="sessionUser" type="com.redball.entity.UserEntity"--%>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">


    <h5 class="my-0 mr-md-auto font-weight-normal">
        <a  href="/homepage">Red Shop</a><%--  добавить class, разобраться с css чо писать чтоб текст был другой--%>
    </h5>
    <c:choose>
        <c:when test="${sessionUser == null}">
            <a class="btn btn-outline-primary" href="/login" style="margin: 0px 5px 0px 5px">Log in</a>
            <a class="btn btn-outline-primary" href="/register" style="margin: 0px 5px 0px 5px">Register</a>
        </c:when>
        <c:otherwise>
            <c:set var="userFullName" value="${sessionUser.name} ${sessionUser.surname}"/>
            <p>${userFullName}</p>
            <a class="btn btn-outline-primary" href="/logout" style="margin: 0px 5px 0px 5px">Log Out</a>
        </c:otherwise>
    </c:choose>

</div>
