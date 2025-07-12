package com.fe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fe.pojo.Student;

import java.util.List;

public class StudentDAO {
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public StudentDAO(String persistanceName) {
        emf = Persistence.createEntityManagerFactory(persistanceName);
    }

    public void save(Student student) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Error " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Student> getStudents() {
        List<Student> students = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            students = em.createQuery("FROM Student", Student.class).getResultList();
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            em.close();
        }
        return students;
    }

    public void delete(Long studentID) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Student s = em.find(Student.class, studentID);
            if(s == null) {
                System.out.println("Student not found with ID: " + studentID);
                return;
            }
            em.remove(s);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    public Student findById(Long studentID) {
        Student student = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            student = em.find(Student.class, studentID);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            em.close();
        }
        return student;
    }

    public void update(Student student) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Student s = em.find(Student.class, student.getId());
            if(s == null) {
                System.out.println("Student not found with ID: " + student.getId());
                return;
            }
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setMarks(student.getMarks());
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            em.close();
        }
    }
}
