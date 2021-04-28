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

@WebServlet("/view/getalltrainees")
public class AllTrainees extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TraineeService traineeService = new TraineeService();
        Set<Trainee> trainees = traineeService.findAll();

        req.setAttribute("trainees", trainees);
        RequestDispatcher rd = req.getRequestDispatcher("showTrainees.jsp");
        rd.forward(req, resp);
    }
}