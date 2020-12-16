<%--
  Created by IntelliJ IDEA.
  User: air
  Date: 2020. 12. 06.
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${note.nev}</title>
</head>
<body>
<h2>${note.nev}</h2>
<h3>Fontosság: ${note.fontossag}</h3>
<p>Kategória: ${note.kategoria}</p>
<p>Hozzáadás dátuma: ${note.hozzaAdasDatuma}</p>
<ul>
    <c:forEach items="${note.jegyzetek}" var="jegyzet">
        <li>${jegyzet.jegyzet}</li>
    </c:forEach>
</ul>
<form action="${pageContext.servletContext.contextPath}/notes">
    <input type="submit" value="Home">
</form>
</body>
</html>
