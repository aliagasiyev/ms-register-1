package az.edu.msregister.service.impl;

import az.edu.msregister.dto.request.StudentRequest;
import az.edu.msregister.dto.response.StudentResponse;
import az.edu.msregister.entity.StudentEntity;
import az.edu.msregister.entity.UserEntity;
import az.edu.msregister.enums.UserRole;
import az.edu.msregister.exceptions.UnauthorizedAccessException;
import az.edu.msregister.exceptions.UserNotFoundException;
import az.edu.msregister.mapper.StudentMapper;
import az.edu.msregister.repository.StudentRepository;
import az.edu.msregister.repository.UserRepository;
import az.edu.msregister.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Transactional
    @Override
    public StudentResponse createStudent(StudentRequest requestDto, Authentication authentication) {
        String userEmail = authentication.getName();

        UserEntity user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getRole() != UserRole.STAFF) {
            throw new UnauthorizedAccessException("Only STAFF can create a Student");
        }

        // Check if the user already has a student entity
        if (user.getStudentEntity() != null) {
            throw new UnauthorizedAccessException("User already has an associated student profile");
        }

        StudentEntity studentEntity = studentMapper.toEntity(requestDto);
        studentEntity.setUser(user);
        studentEntity = studentRepository.save(studentEntity);

        return studentMapper.toDto(studentEntity);
    }


    @Override
    public Optional<StudentResponse> findByEmail(String email) {
        return studentRepository.findByEmail(email)
                .map(studentMapper::toDto);
    }

    @Override
    @Transactional
    public StudentResponse update(Long id, StudentRequest requestDto, Authentication authentication) {
        UserEntity user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getRole() != UserRole.STAFF && user.getRole() != UserRole.SUPER_ADMIN) {
            throw new UnauthorizedAccessException("Only STAFF or SUPER_ADMIN can update Student info");
        }

        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Student not found"));

        studentEntity.setUniversities(requestDto.getUniversities());
        studentEntity.setWorkExperiences(requestDto.getWorkExperiences());
        studentEntity.setStudySpecialization(requestDto.getStudySpecialization());
        studentEntity.setPaymentDetails(requestDto.getPaymentDetails());
        studentEntity.setGroup(requestDto.getGroup());
        studentEntity.setAttendanceStatus(requestDto.getAttendanceStatus());
        studentEntity.setGrades(requestDto.getGrades());
        studentEntity.setBio(requestDto.getBio());
        studentEntity.setProfilePicture(requestDto.getProfilePicture());
        studentEntity.setSocialMediaPlatform(requestDto.getSocialMediaPlatform());
        studentEntity.setSocialMediaLink(requestDto.getSocialMediaLink());
        studentEntity.setActivityPosts(requestDto.getActivityPosts());

        studentEntity = studentRepository.save(studentEntity);

        return studentMapper.toDto(studentEntity);
    }

    @Override
    @Transactional
    public void deleteStudent(Long studentId, Authentication authentication) {
        UserEntity user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getRole() != UserRole.SUPER_ADMIN) {
            throw new UnauthorizedAccessException("Only SUPER_ADMIN can delete a student");
        }

        StudentEntity studentEntity = studentRepository.findById(studentId)
                .orElseThrow(() -> new UserNotFoundException("Student not found"));

        studentRepository.delete(studentEntity);
    }
}
