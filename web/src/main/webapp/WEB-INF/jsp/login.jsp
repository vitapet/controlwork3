<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Return</a><br/>
<c:if test="${error}">
    <p>Invalid credentials.</p>
</c:if>
<c:remove var="error" scope="request"/>
<form:form method="post" modelAttribute="user">
    <table>
        <form:errors path="login"/>
        <tr>
            <td><form:label path="login">Login</form:label></td>
            <td><form:input path="login" id="user.login"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:password path="password" id="user.password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Login"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>