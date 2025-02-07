package az.edu.msregister.service;

import az.edu.msregister.dto.request.TeacherRequest;
import az.edu.msregister.dto.response.TeacherResponse;
import az.edu.msregister.entity.TeacherEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    TeacherResponse createTeacher(TeacherRequest requestDto);

    Optional findByEmail(String email);
}
