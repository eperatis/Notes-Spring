<%--
  Created by IntelliJ IDEA.
  User: air
  Date: 2020. 12. 06.
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Jegyzet hozzáadása</title>
</head>
<body>

<form:form method="post" action="addNote" modelAttribute="note">
    <form:label path="nev">Név</form:label>
    <form:input path="nev"/>

    <form:label path="kategoria">kategoria</form:label>
    <form:select path="kategoria">
        <form:options items="${kategoriak}"/>
    </form:select>

    <form:label path="fontossag">fontossag</form:label>
    <form:input path="fontossag"/>
    <input type="submit" value="Küldés"/>
</form:form>

</body>
</html>
