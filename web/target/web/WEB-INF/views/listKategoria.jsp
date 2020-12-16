<%--
  Created by IntelliJ IDEA.
  User: air
  Date: 2020. 12. 06.
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${!empty notes}">
    <table frame="border" rules="all">
        <tr><th>Azonosító</th><th>Név</th><th>Hozzáadás dátuma</th></tr>
        <c:forEach items="${notes}" var="note">
            <tr><td><a href="${pageContext.servletContext.contextPath}/note/${note.id}">${note.id}</a></td><td>${note.nev}</td><td>${note.hozzaAdasDatuma}</td></tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty notes}">
    <c:out value="Nincs jegyzet ebben a kategóriában."/></c:if><br><br>

<form action="${pageContext.servletContext.contextPath}/notes">
    <input type="submit" value="Home">
</form>

</body>
</html>
