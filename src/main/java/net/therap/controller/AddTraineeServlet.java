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

/**
 * @author sadia.afroz
 * @since 4/27/21
 */
@WebServlet("/addnewtrainee")
public class AddTraineeServlet extends HttpServlet {

    private TraineeService traineeService;

    @Override
    public void init() throws ServletException {
        this.traineeService = new TraineeService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("traineename");
        String email = req.getParameter("traineeemail");
        String message = "";
        TraineeValidator traineeValidator = new TraineeValidator();
        if (traineeValidator.isValidName(name)) {
            Trainee trainee = new Trainee();
            trainee.setName(name);
            trainee.setEmail(email);

            traineeService.save(trainee);

            message = "Trainee Added Successfully";
        } else {
            message = "Trainee Name already exits";
        }
        resp.sendRedirect("messageview?message=" + message);
    }
}
