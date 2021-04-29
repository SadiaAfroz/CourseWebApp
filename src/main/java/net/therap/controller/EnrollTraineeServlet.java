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

/**
 * @author sadia.afroz
 * @since 4/27/21
 */
@WebServlet("/view/enrolltrainee")
public class EnrollTraineeServlet extends HttpServlet {

    CourseEnrollmentService ces = new CourseEnrollmentService();

    @Override
    public void init() throws ServletException {
        ces = new CourseEnrollmentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseid"));
        int traineeId = Integer.parseInt(req.getParameter("traineeid"));
        String message = "";
        CourseValidator cv = new CourseValidator();
        if (cv.isValidId(courseId)) {
            int numberOfTrainees = 1;
            TraineeValidator traineeValidator = new TraineeValidator();
            if (traineeValidator.hasTraineeCapacity(courseId, numberOfTrainees)) {
                TraineeValidator tv = new TraineeValidator();
                if (tv.isValidId(traineeId)) {

                    ces.enrollTrainees(courseId, traineeId);
                    message = "Trainee : " + traineeId + " Enrolled to the Course :" + courseId + " Successfully";
                } else {
                    message = " Invalid Trinee Id";
                }
            } else {
                message = "Capacity Not Supported";
            }
        } else {
            message = "Invalid Course Id ";
        }
        resp.sendRedirect("messageview?message=" + message);
    }
}
