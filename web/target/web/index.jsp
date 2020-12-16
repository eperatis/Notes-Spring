<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.servletContext.contextPath}/notes">
    <input type="submit" value="Home">
</form>
</body>
</html>
