<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<div style="color: teal; font-size: 20px">Edit user</div>
<a href="/logout" class=""> logout </a>

<a href="/reg">New User</a>

<br>
<form:form method="post" action="/edit" modelAttribute="user">

    <br>
    <table>

        <tr>
            <td>id <c:out value="${user.id}"/></td>
            <td><input type="hidden" name="id" value="<c:out value="${user.id}"/>"></td>
        </tr>
        <tr>
            <td>login</td>
            <td><input type="text" name="login" value="<c:out value="${user.login}"/>"></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="email" name="email" value="<c:out value="${user.email}"/>"></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password" value="<c:out value="${user.password}"/>"></td>
        </tr>

        <c:forEach var="role" items="${roles}">
            <form:checkbox path="roles" value="${role.name}"/>${role.name}
            <br>
        </c:forEach>

        <tr>
            <td>rating</td>
            <td><input type="number" name="rating" value="<c:out value="${user.rating}"/>"></td>
        </tr>

    </table>

    <input type="submit" class="btnLogin" value="Save" tabindex="4">
    <a href="/admin" class=""> cancel </a>
</form:form>


</body>
</html>
