<%@ page import="java.util.Set" %>
<%@ page import="net.therap.model.Course" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: sadia.afroz
  Date: 4/27/21
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Set<Course> courses = (Set<Course>) request.getAttribute("courses");
    PrintWriter outt = response.getWriter();
    for (Course c: courses){
        outt.println(c.toString());
    }
%>
</body>
</html>
