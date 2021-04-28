package net.therap.service;

import net.therap.dao.CourseEnrollmentDao;

/**
 * @author sadia.afroz
 * @since 4/18/21
 */
public class CourseEnrollmentService {

    public void enrollTrainees(int courseId, int traineeId) {
        CourseEnrollmentDao ced = new CourseEnrollmentDao();
        ced.addTraineeList(courseId, traineeId);
    }

    public void removeTrainee(int courseId, int traineeId) {
        CourseEnrollmentDao ced = new CourseEnrollmentDao();
        ced.removeTrainee(courseId, traineeId);
    }
}
