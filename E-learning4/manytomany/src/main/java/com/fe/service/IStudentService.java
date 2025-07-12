package com.fe.service;

import java.util.List;
import com.fe.pojo.Student;

public interface IStudentService {
    public List<Student> findAll();

    public void save(Student student);

    public void delete(Long studentID);

    public Student findById(Long studentID);

    public void update(Student student);
}
