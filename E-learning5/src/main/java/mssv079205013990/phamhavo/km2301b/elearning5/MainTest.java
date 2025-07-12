package mssv079205013990.phamhavo.km2301b.elearning5;

import java.util.List;

import mssv079205013990.phamhavo.km2301b.elearning5.pojo.Book;
import mssv079205013990.phamhavo.km2301b.elearning5.pojo.Student;
import mssv079205013990.phamhavo.km2301b.elearning5.services.IStudentService;
import mssv079205013990.phamhavo.km2301b.elearning5.services.StudentService;

public class MainTest {
    public static void main(String[] args) {
        String fileName = "JPAs";
        IStudentService studentService = new StudentService(fileName);
        /* Student student = new Student("Lam", "Nguyen", 9);
        Student student2 = new Student("Van", "Nguyen", 7);
        Book book = new Book("Java Persistence with Hibernate", "Christian Bauer", "9781617293452");
        student.getBooks().add(book);
        student2.getBooks().add(book);
        studentService.save(student);
        studentService.save(student2); */
        List<Student> students = studentService.findAll();
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getFirstName() + " " + s.getLastName() + ", Marks: " + s.getMarks());
            for (Book b : s.getBooks()) {
                System.out.println("  Book: " + b.getTitle() + ", Author: " + b.getAuthor() + ", ISBN: " + b.getIsbn());
            }
        }
    }
}