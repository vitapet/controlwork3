<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Documents</title>
</head>
<body>
<header>
    <jsp:include page="../res/header.jsp"/>
</header>
<form:form method="post" modelAttribute="document">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td>Page Count</td>
            <td><form:input path="pageCount"/></td>
            <td><form:errors path="pageCount"/></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><form:input path="description"/></td>
            <td><form:errors path="description"/></td>
        </tr>
    </table>
    <button type="submit">Save</button>
    <c:out value="${message}"/>
</form:form>
</body>
</html>
