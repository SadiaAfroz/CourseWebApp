package net.therap.controller;


import net.therap.model.Trainee;
import net.therap.service.TraineeService;

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
@WebServlet("/view/getalltrainees")
public class AllTraineesServlet extends HttpServlet {

    TraineeService traineeService ;

    @Override
    public void init() throws ServletException {
        traineeService = new TraineeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Trainee> trainees = traineeService.findAll();

        req.setAttribute("trainees", trainees);
        RequestDispatcher rd = req.getRequestDispatcher("showTrainees.jsp");
        rd.forward(req, resp);
    }
}
