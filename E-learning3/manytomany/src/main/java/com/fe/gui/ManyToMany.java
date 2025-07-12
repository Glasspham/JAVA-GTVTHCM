package com.fe.gui;

import java.util.List;

import com.fe.pojo.Book;
import com.fe.pojo.Student;
import com.fe.service.IStudentService;
import com.fe.service.StudentService;

public class ManyToMany {
    public static void main(String[] args) {
        String fileName = "JPAs";
        IStudentService studentService = new StudentService(fileName);
        Student student = new Student("Lam", "Nguyen", 9);
        Student student2 = new Student("Van", "Nguyen", 7);
        Book book = new Book("Java Persistence with Hibernate", "Christian Bauer", "9781617293452");
        student.getBooks().add(book);
        student2.getBooks().add(book);
        studentService.save(student);
        studentService.save(student2);
        List<Student> students = studentService.findAll();
        for(Student st : students) {
            System.out.println(st.getFirstName());
        }
        System.exit(0);
    }
}
