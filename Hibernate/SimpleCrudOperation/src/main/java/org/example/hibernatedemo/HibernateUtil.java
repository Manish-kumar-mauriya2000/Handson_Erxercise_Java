package org.example.hibernatedemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        return sessionFactory;
    }
}
