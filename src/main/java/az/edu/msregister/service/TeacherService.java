package az.edu.msregister.service;

import az.edu.msregister.entity.TeacherEntity;

import java.util.List;

public interface TeacherService {
    TeacherEntity createTeacher(TeacherEntity teacher);

    TeacherEntity updateTeacher(TeacherEntity teacher);

    TeacherEntity getTeacherById(Long id);

    void deleteTeacher(Long id);

    List<TeacherEntity> getAllTeachers();
}
