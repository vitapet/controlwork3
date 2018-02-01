<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<header>
    <jsp:include page="../res/header.jsp"/>
</header>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>Login</td>
            <td><form:input path="login"/></td>
            <td><form:errors path="login"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><form:input path="password"/></td>
            <td><form:errors path="password"/></td>
        </tr>
        <tr>
            <td>FirstName</td>
            <td><form:input path="firstName"/></td>
            <td><form:errors path="firstName"/></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><form:input path="surname"/></td>
            <td><form:errors path="surname"/></td>
        </tr>
        <tr>
            <td>Role</td>
            <td><form:select path="role">
                <form:options items="${roles}"/>
            </form:select></td>
        </tr>
    </table>
    <button type="submit">Save</button>
    <c:out value="${message}"/>
</form:form>
</body>
</html>
