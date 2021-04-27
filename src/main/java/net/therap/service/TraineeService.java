package net.therap.service;

import net.therap.dao.TraineeDao;
import net.therap.model.Trainee;
import net.therap.view.TraineesView;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sadia.afroz
 * @since 4/8/21
 */
public class TraineeService {

    public void processTrainees(Set<Trainee> trainees) {
        TraineesView traineesView = new TraineesView();
        traineesView.view(trainees);
    }

    public Set<Trainee> findAllByCourseId(int courseId) {
        TraineeDao traineeDao = new TraineeDao();
        Set<Trainee> trainees = traineeDao.findAllByCourseId(courseId);
        return trainees;
    }

    public Set<Trainee> findAll() {
        TraineeDao traineeDao = new TraineeDao();
        Set<Trainee> trainees = new HashSet<>(traineeDao.findAll());
        return trainees;
    }

    public void save(Trainee trainee) {
        TraineeDao traineeDao = new TraineeDao();
        traineeDao.save(trainee);
    }

    public void saveOrUpdate(Trainee trainee) {
        TraineeDao traineeDao = new TraineeDao();
        traineeDao.saveOrUpdate(trainee);
    }

    public void remove(Trainee trainee) {
        TraineeDao traineeDao = new TraineeDao();
        traineeDao.remove(trainee);
    }
}
