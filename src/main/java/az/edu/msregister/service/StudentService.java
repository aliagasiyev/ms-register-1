package az.edu.msregister.service;

import az.edu.msregister.dto.request.StudentRequest;
import az.edu.msregister.dto.response.StudentResponse;
import az.edu.msregister.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentResponse createStudent(StudentRequest requestDto);

    Optional findByEmail(String email);
}