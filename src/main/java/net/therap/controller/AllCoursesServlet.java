package net.therap.controller;

import net.therap.model.Course;
import net.therap.service.CourseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/27/21
 */
@WebServlet("/getallcourses")
public class AllCoursesServlet extends HttpServlet {

    private CourseService courseService;

    @Override
    public void init() throws ServletException {
        this.courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Course> courses = courseService.findAll();
        req.setAttribute("courses", courses);
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/showCourses.jsp");
        rd.forward(req, resp);
    }
}
