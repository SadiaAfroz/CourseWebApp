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

/**
 * @author sadia.afroz
 * @since 4/27/21
 */
@WebServlet("/view/addnewtrainee")
public class AddTrainee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("traineename");
        String email = req.getParameter("traineeemail");
        PrintWriter out = resp.getWriter();
        TraineeValidator traineeValidator = new TraineeValidator();
        if (traineeValidator.isValidName(name)) {
            Trainee trainee = new Trainee();
            trainee.setName(name);
            trainee.setEmail(email);

            TraineeService traineeService = new TraineeService();
            traineeService.save(trainee);

            out.println("<h1>Course Added Successfully<h1>");
        } else {
            out.println("<h1>Trainee Name already exits<h1>");
        }
    }
}
