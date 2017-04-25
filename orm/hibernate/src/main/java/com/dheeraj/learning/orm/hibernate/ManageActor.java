package com.dheeraj.learning.orm.hibernate;

import com.dheeraj.learning.orm.hibernate.domain.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by gopad on 24-04-2017.
 */
public class ManageActor {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Actor a = (Actor)session.get(Actor.class, 1);
        System.out.println(a);

        session.getTransaction().commit();
        session.close();
    }
}
