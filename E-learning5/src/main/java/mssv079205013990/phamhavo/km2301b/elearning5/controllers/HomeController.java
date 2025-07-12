package mssv079205013990.phamhavo.km2301b.elearning5.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

import mssv079205013990.phamhavo.km2301b.elearning5.pojo.Student;
import mssv079205013990.phamhavo.km2301b.elearning5.services.IStudentService;
import mssv079205013990.phamhavo.km2301b.elearning5.services.StudentService;

@Controller
public class HomeController {

    private IStudentService iStudentService;

    @Autowired
    public HomeController() {
        iStudentService = new StudentService("JPAs");
    }

    @RequestMapping(value = "/")
    public ModelAndView showStudent(HttpServletRequest response) throws IOException {
        List<Student> students = iStudentService.findAll();
        ModelAndView model = new ModelAndView("home");
        model.addObject("students", students);
        return model;
    }

    @RequestMapping(value = "/manageStudent")
    public String manageStudent(HttpServletRequest request) throws IOException {
        String type = request.getParameter("btnManageStudent");
        String idStr = request.getParameter("txtID");
        String firstName = request.getParameter("txtFirstName");
        String lastName = request.getParameter("txtLastName");
        int mark = Integer.parseInt(request.getParameter("txtMark"));
        Student student = new Student(firstName, lastName, mark);

        switch (type) {
            case "add":
                iStudentService.save(student);
                break;
            case "update":
                if (idStr != null && !idStr.isEmpty()) {
                    int StudentID = Integer.parseInt(idStr);
                    student.setId(StudentID);
                    iStudentService.update(student);
                }
                break;
            case "delete":
                if (idStr != null && !idStr.isEmpty()) {
                    int StudentID = Integer.parseInt(idStr);
                    iStudentService.delete(StudentID);
                }
                break;
            default:
                break;
        }
        return "redirect:/";
    }
}
