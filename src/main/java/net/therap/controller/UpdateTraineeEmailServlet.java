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
@WebServlet("/updatetraineeemail")
public class UpdateTraineeEmailServlet extends HttpServlet {

    private TraineeService traineeService;

    @Override
    public void init() throws ServletException {
        this.traineeService = new TraineeService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String traineeEmail = req.getParameter("traineeemail");
        int traineeId = Integer.parseInt(req.getParameter("traineeid"));

        String message = "";
        TraineeValidator traineeValidator = new TraineeValidator();
        if (traineeValidator.isValidId(traineeId)) {
            Trainee trainee = new Trainee();
            trainee.setId(traineeId);
            trainee.setEmail(traineeEmail);
            traineeService.saveOrUpdate(trainee);
            message = "Trainee Email updated Successfully";
        } else {
            message = "Invalid Trainee Id";
        }
        resp.sendRedirect("messageview?message=" + message);
    }
}
