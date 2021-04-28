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

@WebServlet("/view/getallcourses")
public class AllCourses extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseService courseService = new CourseService();
        Set<Course> courses = courseService.findAll();

        req.setAttribute("courses", courses);
        RequestDispatcher rd = req.getRequestDispatcher("showCourses.jsp");
        rd.forward(req, resp);
    }
}
