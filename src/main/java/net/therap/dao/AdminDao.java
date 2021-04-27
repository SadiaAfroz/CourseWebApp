package net.therap.dao;

import net.therap.model.Admin;
import net.therap.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AdminDao {
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public AdminDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("courseEnrollment");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public Admin check(String username, String password) {
        TypedQuery<Admin> query = entityManager.createQuery("SELECT a FROM Admin a WHERE a.username=:username AND a.password=:password", Admin.class);
        Admin admin = query.setParameter("username", username).setParameter("password", password).getSingleResult();
        entityManager.close();
        entityManagerFactory.close();
        return admin;
    }
}
