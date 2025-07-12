package mssv079205013990.phamhavo.km2301b.elearning5.repositories;

import java.util.List;

import mssv079205013990.phamhavo.km2301b.elearning5.pojo.Student;

public interface IStudentRepository {
    public List<Student> findAll();

    public void save(Student student);

    public void delete(int studentID);

    public Student findById(int studentID);

    public void update(Student student);
}
