package net.therap.controller;

import net.therap.model.Trainee;
import net.therap.service.TraineeService;
import net.therap.validator.CourseValidator;

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
@WebServlet("/traineedetailsbycourseid")
public class TraineeDetailsServlet extends HttpServlet {

    private TraineeService traineeService;

    @Override
    public void init() throws ServletException {
        this.traineeService = new TraineeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseid"));
        String message = "";
        CourseValidator cv = new CourseValidator();
        if (cv.isValidId(courseId)) {
            Set<Trainee> trainees = traineeService.findAllByCourseId(courseId);
            if (trainees.size() < 1) {
                message = "No Trainee Assigned to the Course";
                req.setAttribute("message", message);
                RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/messageView.jsp");
                rd.forward(req, resp);
            } else {
                req.setAttribute("trainees", trainees);
                RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/showTrainees.jsp");
                rd.forward(req, resp);
            }
        } else {
            message = "Invalid Course id";
            req.setAttribute("message", message);
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/messageView.jsp");
            rd.forward(req, resp);
        }
    }
}