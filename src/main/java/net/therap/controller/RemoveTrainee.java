package net.therap.controller;

import net.therap.model.Trainee;
import net.therap.service.TraineeService;
import net.therap.validator.TraineeValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/removetrainee")
public class RemoveTrainee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int traineeId = Integer.parseInt(req.getParameter("traineeid"));
        PrintWriter out = resp.getWriter();
        TraineeValidator traineeValidator = new TraineeValidator();
        if (traineeValidator.isValidId(traineeId)) {
            TraineeService traineeService = new TraineeService();
            Trainee trainee = new Trainee();
            trainee.setId(traineeId);
            traineeService.remove(trainee);

            out.println("<h1> Trainee Removed Successfully <h1>");
        } else {
            out.println("<h1>Not a valid id<h1>");
        }
    }
}
