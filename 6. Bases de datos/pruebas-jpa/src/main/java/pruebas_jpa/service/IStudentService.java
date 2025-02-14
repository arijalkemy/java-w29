package pruebas_jpa.service;

import pruebas_jpa.entity.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student stu);
    public void deleteStudent(long id);
    public Student findStudent(long id);
}
