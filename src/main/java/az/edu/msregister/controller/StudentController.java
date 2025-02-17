package az.edu.msregister.controller;

import az.edu.msregister.dto.request.StudentRequest;
import az.edu.msregister.dto.response.StudentResponse;
import az.edu.msregister.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('STAFF')")
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest, Authentication authentication) {
        return studentService.createStudent(studentRequest, authentication);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('STAFF') or hasRole('SUPER_ADMIN')")
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest, Authentication authentication) {
        return studentService.update(id, studentRequest, authentication);
    }

    @DeleteMapping("/delete/{studentId}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public void deleteStudent(@PathVariable Long studentId, Authentication authentication) {
        studentService.deleteStudent(studentId, authentication);
    }

    @GetMapping("/find/{email}")
    public Optional<StudentResponse> getStudentByEmail(@PathVariable String email) {
        return studentService.findByEmail(email);
    }
}
