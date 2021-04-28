package net.therap.controller;

import net.therap.service.CourseEnrollmentService;
import net.therap.validator.CourseValidator;
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
@WebServlet("/view/enrolltrainee")
public class EnrollTrainee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseid"));
        int traineeId = Integer.parseInt(req.getParameter("traineeid"));
        PrintWriter out = resp.getWriter();
        CourseValidator cv = new CourseValidator();
        if (cv.isValidId(courseId)) {
            int numberOfTrainees = 1;
            TraineeValidator traineeValidator = new TraineeValidator();
            if (traineeValidator.hasTraineeCapacity(courseId, numberOfTrainees)) {
                TraineeValidator tv = new TraineeValidator();
                if (tv.isValidId(traineeId)) {
                    CourseEnrollmentService ces = new CourseEnrollmentService();
                    ces.enrollTrainees(courseId, traineeId);
                    out.println("Trainee : " + traineeId + " Enrolled to the Course :" + courseId + " Successfully");
                } else {
                    out.println("\n************************* Invalid Trainee Id ***************************");
                }
            } else {
                out.println("*************************** Capacity Not Supported **********************");
            }
        } else {
            out.println("\n************************* Invalid Course Id ********************");
        }
    }
}
