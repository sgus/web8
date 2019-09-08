<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<div style="color: teal; font-size: 20px">Registration Form</div>
<a href="/logout" class=""> logout </a>

<form:form method="post" modelAttribute="user" action="reg">
    <br>

    <form:label path="login">Login:</form:label>
    <form:input path="login"/>
    <br>

    <form:label path="email">email:</form:label>
    <form:input path="email"/>
    <br>

    <form:label path="password">Password:</form:label>
    <form:password path="password"/>
    <br>


    <c:forEach var="role" items="${roles}">
        <form:checkbox path="roles" value="${role.name}"/>${role.name}
        <br>
    </c:forEach>


    <input type="submit" class="btnLogin" value="Save" tabindex="4">
    <a href="/admin" class=""> list </a>
    <a href="/index" class=""> login</a>
</form:form>
</body>
</html>
