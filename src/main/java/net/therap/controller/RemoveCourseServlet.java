package net.therap.controller;

import net.therap.model.Course;
import net.therap.service.CourseService;
import net.therap.validator.CourseValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sadia.afroz
 * @since 4/27/21
 */
@WebServlet("/view/removecourse")
public class RemoveCourseServlet extends HttpServlet {

    CourseService courseService;

    @Override
    public void init() throws ServletException {
        courseService = new CourseService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int courseId = Integer.parseInt(req.getParameter("courseid"));
        String message="";
        CourseValidator courseValidator = new CourseValidator();
        if (courseValidator.isValidId(courseId)) {
            Course course = new Course();
            course.setId(courseId);
            courseService.remove(course);
            message="Course Removed Successfully";
        } else {
            message="Invalid Id";
        }
        resp.sendRedirect("messageview?message="+message);
    }
}
