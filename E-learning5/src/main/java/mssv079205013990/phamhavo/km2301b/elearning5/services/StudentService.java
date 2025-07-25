package mssv079205013990.phamhavo.km2301b.elearning5.services;

import java.util.List;
import mssv079205013990.phamhavo.km2301b.elearning5.pojo.Student;
import mssv079205013990.phamhavo.km2301b.elearning5.repositories.IStudentRepository;
import mssv079205013990.phamhavo.km2301b.elearning5.repositories.StudentRepository;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepo = null;

    public StudentService(String fileName) {
        iStudentRepo = new StudentRepository(fileName);
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public List<Student> findAll() {
        return iStudentRepo.findAll();
    }

    @Override
    public void delete(int studentID) {
        iStudentRepo.delete(studentID);
    }

    @Override
    public Student findById(int studentID) {
        return iStudentRepo.findById(studentID);
    }

    @Override
    public void update(Student student) {
        iStudentRepo.update(student);
    }
}
