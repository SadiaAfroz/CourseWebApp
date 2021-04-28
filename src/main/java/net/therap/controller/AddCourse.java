package net.therap.controller;

import net.therap.model.Course;
import net.therap.service.CourseService;
import net.therap.validator.CourseValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/addnewcourse")
public class AddCourse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseTitle = req.getParameter("coursetitle");

        PrintWriter out = resp.getWriter();
        CourseValidator courseValidator = new CourseValidator();
        if (courseValidator.isValidTitle(courseTitle)) {
            Course course = new Course();
            course.setTitle(courseTitle);
            CourseService courseService = new CourseService();
            courseService.save(course);

            out.println("<h1>Course Added Successfully<h1>");
        } else {
            out.println("<h1>Title already exits</h1>");
        }
    }
}
