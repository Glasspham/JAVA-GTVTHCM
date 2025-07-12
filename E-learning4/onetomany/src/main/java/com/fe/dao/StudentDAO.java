package com.fe.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.fe.pojo.Student;
import java.util.List;

public class StudentDAO {
    private SessionFactory sessionFactory = null;
    private Configuration cf = null;

    public StudentDAO(String persistanceName) {
        cf = new Configuration();
        cf = cf.configure(persistanceName);
        sessionFactory = cf.buildSessionFactory();
    }

    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(student);
            t.commit();
            System.out.println("Successfully saved");
        } catch (Exception ex) {
            t.rollback();
            System.out.println("Err " + ex.getMessage());
        } finally {
            sessionFactory.close();
            session.close();
        }
    }

    public List<Student> getStudents() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Student> students = null;
        try {
            tx.begin();
            students = session.createQuery("from Student", Student.class).list();
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e; // rethrow the exception to handle it later
        } finally {
            session.close();
        }
        return students;
    }

    public void delete(Long studentID) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx.begin();
            Student student = (Student) session.get(Student.class, studentID);
            session.delete(student);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e; // rethrow the exception to handle it later
        } finally {
            session.close();
        }
    }

    public Student findById(Long studentID) {
        Session session = sessionFactory.openSession();
        try {
            return (Student) session.get(Student.class, studentID);
        } catch (RuntimeException e) {
            throw e; // rethrow the exception to handle it later
        } finally {
            session.close();
        }
    }

    public void update(Student student) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(student);
            t.commit();
            System.out.println("Update saved");
        } catch (Exception ex) {
            t.rollback();
            System.out.println("Err " + ex.getMessage());
        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
