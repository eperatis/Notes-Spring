<%--
  Created by IntelliJ IDEA.
  User: air
  Date: 2020. 12. 06.
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Jegyzetek</title>
</head>
<body>

<c:if test="${!empty notes}">
    <table frame="border" rules="all">
        <tr><th>Azonosító</th><th>Név</th><th>Hozzáadás dátuma</th><th>Action</th></tr>
        <c:forEach items="${notes}" var="note">
            <tr><td><a href="${pageContext.servletContext.contextPath}/note/${note.id}">${note.id}</a></td><td>${note.nev}</td><td>${note.hozzaAdasDatuma}</td>
                <td>
                    <a type="button" href="${pageContext.servletContext.contextPath}/deleteNote/${note.id}">Törlés</a>
                </td></tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty notes}">
    <c:out value="Nincs Jegyzet"/>
</c:if>

<form action="${pageContext.servletContext.contextPath}/addNote">
    <input type="submit" value="Jegyzet hozzáadása">
</form>

<p>Lekérdezés kategóriák szerint</p>
<form action="${pageContext.servletContext.contextPath}/listSuli">
    <input type="submit" value="Sulis jegyzetek">
</form>

<form action="${pageContext.servletContext.contextPath}/listMunka">
    <input type="submit" value="Munka jegyzetek">
</form>

<form action="${pageContext.servletContext.contextPath}/listSzemelyes">
    <input type="submit" value="Személyes jegyzetek">
</form>
</body>
</html>
