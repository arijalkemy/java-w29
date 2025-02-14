package pruebas_jpa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pruebas_jpa.entity.Student;
import pruebas_jpa.service.IStudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable long id,
                               @RequestParam("name") String newName,
                               @RequestParam("lastname") String newLastName){


        Student stu = studentService.findStudent(id);

        //Esto puede ir en el service
        stu.setLastname(newName);
        stu.setName(newLastName);
        studentService.saveStudent(stu);

        return stu;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }

}
