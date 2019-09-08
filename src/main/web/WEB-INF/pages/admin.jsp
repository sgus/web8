<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="color: teal; font-size: 20px">List of user</div>
<a href="/logout" class=""> logout </a>
<br>
<br>
<a href="/reg">New User</a>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>login</th>
        <th>email</th>
        <th>password</th>
        <th>rank</th>
        <th>rating</th>
        <th>action</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>

        <c:forEach var="role" items="${user.roles}">
            ${role.name}
            <br>
        </c:forEach>

            </td>
            <td>${user.rating}</td>
            <td>
                <a href="/admin/edit?id=<c:out value='${user.id}'/>">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/admin/delete?id=<c:out value='${user.id}'/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
