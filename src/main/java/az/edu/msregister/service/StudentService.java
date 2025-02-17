package az.edu.msregister.service;

import az.edu.msregister.dto.request.StudentRequest;
import az.edu.msregister.dto.response.StudentResponse;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface StudentService {
    StudentResponse createStudent(StudentRequest requestDto, Authentication authentication);

    Optional<StudentResponse> findByEmail(String email);

    StudentResponse update(Long id, StudentRequest requestDto, Authentication authentication);

    void deleteStudent(Long studentId, Authentication authentication);
}
