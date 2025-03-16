package org.example.part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionExample {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Student student = new Student("Ivan1", 27);
            session.save(student);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
