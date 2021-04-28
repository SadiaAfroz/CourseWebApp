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

@WebServlet("/view/removecourse")
public class RemoveCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int courseId = Integer.parseInt(req.getParameter("courseid"));

        PrintWriter out = resp.getWriter();
        CourseValidator courseValidator = new CourseValidator();
        if (courseValidator.isValidId(courseId)) {
            CourseService courseService = new CourseService();
            Course course = new Course();
            course.setId(courseId);
            courseService.remove(course);
            out.println("<h1> Course Removed Successfully <h1>");
        } else {
            out.println("<h1>Not a valid id<h1>");
        }
    }
}
