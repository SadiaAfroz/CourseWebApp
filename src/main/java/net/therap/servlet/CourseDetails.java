package net.therap.servlet;

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

@WebServlet("/coursedetailsbytraineeid")
public class CourseDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int traineeId= Integer.parseInt(req.getParameter("traineeid"));
        TraineeValidator tv = new TraineeValidator();
        if (tv.isValidId(traineeId)) {
            CourseService courseService = new CourseService();
            Set<Course> courses = courseService.findAllByTraineeId(traineeId);

            req.setAttribute("courses", courses);
            RequestDispatcher rd= req.getRequestDispatcher("course/showCourses.jsp");
            rd.forward(req,resp);
        } else {
            String message= "Invalid trainee id";
            req.setAttribute("errorMessage", message);
            RequestDispatcher rd= req.getRequestDispatcher("errorView.jsp");
            rd.forward(req,resp);
        }

    }
}
