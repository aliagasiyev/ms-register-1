package az.edu.msregister.controller;

import az.edu.msregister.dto.request.TeacherRequest;
import az.edu.msregister.dto.response.TeacherResponse;
import az.edu.msregister.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    @PreAuthorize("hasRole('STAFF')")
    public ResponseEntity<TeacherResponse> createTeacher(@RequestBody TeacherRequest request, Authentication authentication) {
        TeacherResponse teacherResponse = teacherService.createTeacher(request, authentication);
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherResponse);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<TeacherResponse> findByEmail(@PathVariable String email) {
        Optional<TeacherResponse> teacherResponse = teacherService.findByEmail(email);
        return teacherResponse.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('STAFF')")
    public ResponseEntity<TeacherResponse> updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest request, Authentication authentication) {
        TeacherResponse teacherResponse = teacherService.update(id, request, authentication);
        return ResponseEntity.ok(teacherResponse);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id, Authentication authentication) {
        teacherService.deleteTeacher(id, authentication);
        return ResponseEntity.noContent().build();
    }
}
