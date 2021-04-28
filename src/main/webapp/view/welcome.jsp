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
    <title>CourseApp</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    if (session.getAttribute("sesionid") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<h1>Welcome id: ${sesionid}</h1>
<div class="container">
    <div class="row">
        <div class="col m8 offset-m2">
            <div class="card">
                <div class="card-content">
                    <form action="coursedetailsbytraineeid" method="post">
                        <h1>Course details by Traineeid: </h1><br>
                        Enter trainee id : <input type="text" name="traineeid" required><br>
                        <button type="submit" class="btn">Submit</button>
                    </form>
                    <form action="traineedetailsbycourseid" method="post">
                        <h1>Trainee details by Courseid: </h1><br>
                        Enter course id : <input type="text" name="courseid" required><br>
                        <button type="submit" class="btn">Submit</button>
                    </form>
                    <form action="addnewcourse" method="post">
                        <h1>Add New Course: </h1><br>
                        Enter course Title : <input type="text" name="coursetitle" required><br>
                        <button type="submit" class="btn">Save</button>
                    </form>

                    <form action="updatecoursetitle" method="post">
                        <h1>Update Course Title: </h1><br>
                        Enter course id : <input type="text" name="courseid" required></br>
                        Enter new Title : <input type="text" name="coursetitle" required></br>
                        <button type="submit" class="btn">Update</button>
                    </form>

                    <form action="removecourse">
                        <h1>Remove Course:</h1><br>
                        Enter course id : <input type="text" name="courseid" required><br>
                        <button type="submit" class="btn">Remove</button>
                    </form>

                    <form action="addnewtrainee" method="post">
                        <h1>Add New Trainee: </h1><br>
                        Enter Trainee Name : <input type="text" name="traineename" required><br>
                        Enter Trainee Email : <input type="text" name="traineeemail" required><br>
                        <button type="submit" class="btn">Save</button>
                    </form>

                    <form action="updatetraineeemail" method="post">
                        <h1>Update Trainee Email : </h1><br>
                        Enter trainee id : <input type="text" name="traineeid" required></br>
                        Enter new email : <input type="text" name="traineeemail" required></br>
                        <button type="submit" class="btn">Update</button>
                    </form>

                    <form action="updatetraineename" method="post">
                        <h1>Update Trainee Name : </h1><br>
                        Enter Trainee id : <input type="text" name="traineeid" required></br>
                        Enter new Name : <input type="text" name="traineename" required></br>
                        <button type="submit" class="btn">Update</button>
                    </form>

                    <form action="removetrainee">
                        <h1>Remove Trainee : </h1><br>
                        Enter trainee id : <input type="text" name="traineeid" required><br>
                        <button type="submit" class="btn">Remove</button>
                    </form>

                    <form action="enrolltrainee">
                        <h1>Enroll New Trainee : </h1><br>
                        Enter trainee id = <input type="text" name="traineeid" required><br>
                        Enter course id = <input type="text" name="courseid" required><br>
                        <button type="submit" class="btn">Enroll</button>
                    </form>

                    <form action="removetraineefromcourse">
                        <h1>Remove Trainee From Course : </h1><br>
                        Enter trainee id = <input type="text" name="traineeid" required><br>
                        Enter course id = <input type="text" name="courseid" required><br>
                        <button type="submit" class="btn">Remove</button>
                    </form>

                    <form action="getallcourses">
                        <h1>Get All Courses: </h1><br>
                        <button type="submit" class="btn">Get Courses</button>
                    </form>

                    <form action="getalltrainees">
                        <h1>Get All Trainees: </h1><br>
                        <button type="submit" class="btn">Get Trainees</button>
                    </form>

                    </br>
                    <form action="logout">
                        <button type="submit" class="btn">Logout</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
