<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<div style="color: teal; font-size: 20px">Registration Form</div>
<form:form method="post" modelAttribute="user" action="reg">

    <form:label path="login">Login:</form:label>
    <form:input path="login"/>

    <form:label path="password">Password:</form:label>
    <form:password path="password"/>

    <form:label path="email">Password:</form:label>
    <form:input path="email"/>

    <input type="submit" class="btnLogin" value="Save" tabindex="4">

    <a href="/admin" class=""> list </a>
    <a href="/index" class=""> login</a>
</form:form>
</body>
</html>
