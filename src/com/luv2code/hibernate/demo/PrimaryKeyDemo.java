package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating  new Student object...");

            Student tempStudent1 = new Student("John","Doe","john@luv2Code.com");
            Student tempStudent2 = new Student("Mary","Public","mary@luv2Code.com");
            Student tempStudent3 = new Student("Bonita","Applebaum","bonita@luv2Code.com");

            session.beginTransaction();
            System.out.println("Saving the student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

            System.out.println("Done");


        }
        finally {
            factory.close();
        }
    }
}
