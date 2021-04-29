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

/**
 * @author sadia.afroz
 * @since 4/27/21
 */
@WebServlet("/view/addnewcourse")
public class AddCourseServlet extends HttpServlet {

    CourseService courseService;

    @Override
    public void init() throws ServletException {
        courseService = new CourseService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String courseTitle = req.getParameter("coursetitle");

        String message = "";
        CourseValidator courseValidator = new CourseValidator();
        if (courseValidator.isValidTitle(courseTitle)) {
            Course course = new Course();
            course.setTitle(courseTitle);
            courseService.save(course);

            message = "Course Added Successfully";
        } else {
            message = "Title already exits";
        }
        resp.sendRedirect("messageview?message=" + message);
    }
}
