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
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/view/traineedetailsbycourseid")
public class TraineeDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseid"));
        PrintWriter out = resp.getWriter();
        CourseValidator cv = new CourseValidator();
        if (cv.isValidId(courseId)) {
            TraineeService traineeService = new TraineeService();
            Set<Trainee> trainees = traineeService.findAllByCourseId(courseId);
            if (trainees.size() < 1) {
                out.println("No Trainee Assigned to the Course");
            } else {
                req.setAttribute("trainees", trainees);
                RequestDispatcher rd = req.getRequestDispatcher("showTrainees.jsp");
                rd.forward(req, resp);
            }
        } else {
            out.println("<h1>Invalid Course id</h1>");
        }

    }
}