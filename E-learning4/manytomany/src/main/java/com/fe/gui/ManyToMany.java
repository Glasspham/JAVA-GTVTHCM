package com.fe.gui;

import com.fe.pojo.Book;
import com.fe.pojo.Student;
import com.fe.service.IStudentService;
import com.fe.service.StudentService;

public class ManyToMany {
    public static void main(String[] args) {
        String fileName = "hibernate.cfg.xml";
        IStudentService studentService = new StudentService(fileName);
        Student student = new Student("Lam", "Nguyen", 9);
        Book book = new Book("Java Persistence with Hibernate", "Christian Bauer", "9781617293452");
        student.getBooks().add(book);
        studentService.save(student);
        System.exit(0);
    }
}
