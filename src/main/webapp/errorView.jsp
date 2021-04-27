<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: sadia.afroz
  Date: 4/27/21
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    PrintWriter outt= response.getWriter();
    outt.println(errorMessage);

%>
</body>
</html>
