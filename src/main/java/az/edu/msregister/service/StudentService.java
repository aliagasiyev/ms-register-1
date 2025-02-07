package az.edu.msregister.service;

import az.edu.msregister.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity createStudent(StudentEntity student);

    StudentEntity updateStudent(StudentEntity student);

    StudentEntity getStudentById(Long id);

    void deleteStudent(Long id);

    List<StudentEntity> getAllStudents();
}
