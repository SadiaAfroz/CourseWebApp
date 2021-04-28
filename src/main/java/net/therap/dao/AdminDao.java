package net.therap.dao;

import net.therap.model.Admin;

import javax.persistence.*;
import java.util.List;

public class AdminDao {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public AdminDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("courseEnrollment");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public Admin check(String username, String password) {
        TypedQuery<Admin> query = entityManager.createQuery("SELECT a FROM Admin a WHERE a.username=:username AND a.password=:password", Admin.class);
        List<Admin> admins = query.setParameter("username", username).setParameter("password", password).getResultList();

        entityManager.close();
        entityManagerFactory.close();
        if (admins.isEmpty()) {
            return null;

        } else {
            return admins.get(0);
        }
    }
}