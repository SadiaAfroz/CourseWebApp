package net.therap.controller;

import net.therap.model.Course;
import net.therap.service.CourseService;
import net.therap.validator.TraineeValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/view/coursedetailsbytraineeid")
public class CourseDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int traineeId = Integer.parseInt(req.getParameter("traineeid"));
        TraineeValidator tv = new TraineeValidator();
        PrintWriter out = resp.getWriter();
        if (tv.isValidId(traineeId)) {
            CourseService courseService = new CourseService();
            Set<Course> courses = courseService.findAllByTraineeId(traineeId);
            if (courses.size() < 1) {
                out.println("No Course Assigned to the trainee");
            } else {
                req.setAttribute("courses", courses);
                RequestDispatcher rd = req.getRequestDispatcher("showCourses.jsp");
                rd.forward(req, resp);
            }
        } else {
            out.println("<h1>Invalid trainee id</h1>");
        }

    }
}
