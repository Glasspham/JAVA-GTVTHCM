package mssv079205013990.phamhavo.km2301b.elearning5.repositories;
import java.util.List;
import mssv079205013990.phamhavo.km2301b.elearning5.dao.StudentDAO;
import mssv079205013990.phamhavo.km2301b.elearning5.pojo.Student;

public class StudentRepository implements IStudentRepository {
    private StudentDAO studentDAO = null;

    public StudentRepository(String fileConfig) {
        studentDAO = new StudentDAO(fileConfig);
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.getStudents();
    }

    @Override
    public void delete(int studentID) {
        studentDAO.delete(studentID);
    }

    @Override
    public Student findById(int studentID) {
        return studentDAO.findById(studentID);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }
}
