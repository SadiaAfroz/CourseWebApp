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
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/27/21
 */
@WebServlet("/view/coursedetailsbytraineeid")
public class CourseDetailsServlet extends HttpServlet {

    CourseService courseService;

    @Override
    public void init() throws ServletException {
        courseService = new CourseService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int traineeId = Integer.parseInt(req.getParameter("traineeid"));
        TraineeValidator tv = new TraineeValidator();
        if (tv.isValidId(traineeId)) {
            Set<Course> courses = courseService.findAllByTraineeId(traineeId);
            if (courses.size() < 1) {
                req.setAttribute("message", "No Course Assigned to the trainee");
                RequestDispatcher rd = req.getRequestDispatcher("messageView.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("courses", courses);
                RequestDispatcher rd = req.getRequestDispatcher("showCourses.jsp");
                rd.forward(req, resp);
            }
        } else {
            req.setAttribute("message", "Invalid trainee id");
            RequestDispatcher rd = req.getRequestDispatcher("messageView.jsp");
            rd.forward(req, resp);
        }

    }
}
