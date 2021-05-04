<%--
  Created by IntelliJ IDEA.
  User: sadia.afroz
  Date: 4/29/21
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CourseApp</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>

<c:set var="url" value="../login.jsp"/>
<c:if test="${sessionScope.sesionid == null}">
    <c:redirect url="${url}"/>
</c:if>

<h1>
    <c:out value="${message}"/>
</h1>
</body>
</html>
