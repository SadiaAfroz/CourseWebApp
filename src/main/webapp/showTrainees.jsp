<%@ page import="net.therap.model.Trainee" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: sadia.afroz
  Date: 4/27/21
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Set<Trainee> trainees = (Set<Trainee>) request.getAttribute("trainees");
    PrintWriter outt = response.getWriter();
    for (Trainee t: trainees){
        outt.println(t.toString());
    }
%>
</body>
</html>
