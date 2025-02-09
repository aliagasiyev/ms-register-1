package az.edu.msregister.controller;

import az.edu.msregister.dto.request.TeacherRequest;
import az.edu.msregister.dto.response.TeacherResponse;
import az.edu.msregister.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherResponse> createTeacher(@RequestBody TeacherRequest request, Authentication authentication) {
        return ResponseEntity.ok(teacherService.createTeacher(request, authentication));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<TeacherResponse> findByEmail(@PathVariable String email) {
        Optional<TeacherResponse> teacherResponse = teacherService.findByEmail(email);
        return teacherResponse.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherResponse> updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest request, Authentication authentication) {
        return ResponseEntity.ok(teacherService.update(id, request, authentication));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id, Authentication authentication) {
        teacherService.deleteTeacher(id, authentication);
        return ResponseEntity.noContent().build();
    }
}
