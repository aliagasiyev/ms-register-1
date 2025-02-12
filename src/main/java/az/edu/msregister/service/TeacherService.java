//package az.edu.msregister.service;
//
//import az.edu.msregister.dto.request.TeacherRequest;
//import az.edu.msregister.dto.response.TeacherResponse;
//import org.springframework.security.core.Authentication;
//
//import java.util.Optional;
//
//public interface TeacherService {
//    TeacherResponse createTeacher(TeacherRequest requestDto, Authentication authentication);
//
//    Optional<TeacherResponse> findByEmail(String email);
//
//    TeacherResponse update(Long id, TeacherRequest requestDto, Authentication authentication);
//
//    void deleteTeacher(Long teacherId, Authentication authentication);
//}
