package com.fe.main;

import java.util.Scanner;

import com.fe.dao.StudentDAO;
import com.fe.pojo.Student;

public class StudentMain {
    public static void main(String[] args) {
        int inputkey = -1;
        Scanner console = new Scanner(System.in);
        while(inputkey != 0) {
            Menu();
            System.out.print("Enter your choice: ");
            inputkey = console.nextInt();
            StudentDAO studentDAO = new StudentDAO("jpacrud");
            Student student = new Student("Lam", "Nguyen", 9);
            switch (inputkey) {
                case 0:
                    break;
                case 1:
                    System.out.println("Get Students");
                    studentDAO.getStudents().forEach(s -> {
                        System.out.println("ID: " + s.getId() + ", Name: " + s.getFirstName() + " " + s.getLastName() + ", Marks: " + s.getMarks());
                    });
                    break;
                case 2:
                    studentDAO.save(student);
                    System.out.println("Student added successfully!");
                    break;
                case 3:
                    studentDAO.delete(1);
                    System.out.println("Student deleted successfully!");
                    break;
                case 4:
                    student.setId(1); // Assuming we want to update the student with ID 1
                    student.setFirstName("UpdatedFirstName");
                    student.setLastName("UpdatedLastName");
                    student.setMarks(10);
                    studentDAO.update(student);
                    System.out.println("Student updated successfully!");
                    break;
                case 5:
                    Student foundStudent = studentDAO.findById(1);
                    System.out.println("Found Student - ID: " + foundStudent.getId() + 
                                        ", Name: " + foundStudent.getFirstName() + 
                                        " " + foundStudent.getLastName() + 
                                        ", Marks: " + foundStudent.getMarks());
                    break;
                default:
                    System.out.println("Please choice menu!");
            }
        }
        console.close();
        System.exit(0);
    }

    public static void Menu() {
        System.out.println("+++++++++Menu+++++++++");
        System.out.println("+ 1. Get Students    +");
        System.out.println("+ 2. Add Student     +");
        System.out.println("+ 3. Delete Student  +");
        System.out.println("+ 4. Update Student  +");
        System.out.println("+ 5. Get a Student   +");
        System.out.println("+ 0. QUIT            +");
        System.out.println("++++++++++++++++++++++");
    }
}
