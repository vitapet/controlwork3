<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<header>
    <jsp:include page="../res/header.jsp"/>
</header>
<a href="${pageContext.request.contextPath}/admin/users/add">Add</a>
<table>
    <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>FirstName</th>
        <th>Surname</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.surname}"/></td>
            <td><c:out value="${user.role}"/></td>
            <td><a href="${pageContext.request.contextPath}/admin/users/<c:out value="${user.id}"/>/edit">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/admin/users/<c:out value="${user.id}"/>/delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
