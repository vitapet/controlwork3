<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <jsp:include page="../res/header.jsp"/>
</header>
<a href="${pageContext.request.contextPath}/user/documents/add">Add</a>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Page count</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${documents}" var="document">
        <tr>
            <td><c:out value="${document.id}"/></td>
            <td><c:out value="${document.name}"/></td>
            <td><c:out value="${document.pageCount}"/></td>
            <td><c:out value="${document.description}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/user/documents/<c:out value="${document.id}"/>/edit">Edit</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/user/documents/<c:out value="${document.id}"/>/delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
