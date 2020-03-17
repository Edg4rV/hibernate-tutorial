package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class)
        .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {


            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            displayMethods(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            System.out.println("\n\nStudents who have last name of Doe");
            displayMethods(theStudents);

            theStudents = session.createQuery("from Student s where" + " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
            System.out.println("\n\nStudents who have last name of Doe or first name daffy");
            displayMethods(theStudents);


            theStudents = session.createQuery("from Student s where" + " s.email LIKE '%luv2code.com'").getResultList();
            System.out.println("\n\nStudents who have email ends with luv2code");
            displayMethods(theStudents);

            session.getTransaction().commit();

            System.out.println("Done");


        }
        finally {
            factory.close();
        }

    }

    private static void displayMethods(List<Student> theStudents) {
        for(Student tempStudent:theStudents){
            System.out.println(tempStudent);
        }
    }
}
