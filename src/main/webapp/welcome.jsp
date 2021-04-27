<%--sesionid
  Created by IntelliJ IDEA.
  User: sadia.afroz
  Date: 4/27/21
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    if(session.getAttribute("sesionid")==null){
        response.sendRedirect("login.jsp");
    }
%>

Welcome ${sesionid}
</br>


<form action="coursedetailsbytraineeid" method="post">
    Enter trainee id = <input type="text" name="traineeid"><br>
    <input type="submit" value="submit">
</form>

<form action="traineedetailsbycourseid" method="post">
    Enter course id = <input type="text" name="courseid"><br>
    <input type="submit" value="submit">
</form>

<form action="addnewcourse" method="post">
    Enter course Title = <input type="text" name="coursetitle"><br>
    <input type="submit" value="save">
</form>

<form action="updatecoursetitle" method="post">
    Enter course id = <input type="text" name="courseid"></br>
    Enter new Title = <input type="text" name="coursetitle"></br>
    <input type="submit" value="update">
</form>

<form action="deletecourse" method="post">
    Enter course id = <input type="text" name="courseid"><br>
    <input type="submit" value="delete">
</form>


<%--<a href="">ADD_NEW_COURSE</a></br>--%>
<%--<a href="">UPDATE_COURSE_TITLE</a></br>--%>
<%--<a href="">DELETE_COURSE</a></br>--%>
<%--<a href="">ADD_NEW_TRAINEE</a></br>--%>
<%--<a href="">UPDATE_TRAINEE_EMAIL</a></br>--%>
<%--<a href="">UPDATE_TRAINEE_NAME</a></br>--%>
<%--<a href="">DELETE_TRAINEE</a></br>--%>
<%--<a href="">ENROLL_NEW_TRAINEES</a></br>--%>
<%--<a href="">REMOVE_TRAINEE_FROM_COURSE</a></br>--%>
<%--<a href="">GET_ALL_COURSES</a></br>--%>
<%--<a href="">GET_ALL_TRAINEES</a></br>--%>

</br>
<form action="logout">
    <input type="submit" value="logout">

</form>

</body>
</html>
