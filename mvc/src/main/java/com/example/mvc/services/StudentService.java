package com.example.mvc.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mvc.model.Student;
import com.example.mvc.repositories.IStudentRepository;

@Service
public class StudentService {
    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository _studentRepository) {
        this.studentRepository = _studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}