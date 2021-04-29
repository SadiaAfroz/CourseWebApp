package net.therap.controller;

import net.therap.model.Trainee;
import net.therap.service.TraineeService;
import net.therap.validator.TraineeValidator;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/view/updatetraineename")
public class UpdateTraineeNameServlet extends HttpServlet {

    TraineeService traineeService ;

    @Override
    public void init() throws ServletException {
        traineeService = new TraineeService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String traineeName = req.getParameter("traineename");
        int traineeId = Integer.parseInt(req.getParameter("traineeid"));
        String message = "";
        TraineeValidator traineeValidator = new TraineeValidator();
        if (traineeValidator.isValidId(traineeId)) {
            Trainee trainee = new Trainee();
            trainee.setId(traineeId);
            trainee.setName(traineeName);
            traineeService.saveOrUpdate(trainee);
            message="Trainee Name updated Successfully";
        } else {
            message="Invalid Trainee Id";
        }
        resp.sendRedirect("messageview?message="+message);
    }
}