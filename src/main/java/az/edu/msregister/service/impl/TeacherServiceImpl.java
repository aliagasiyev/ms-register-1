package az.edu.msregister.service.impl;

import az.edu.msregister.dto.request.TeacherRequest;
import az.edu.msregister.dto.response.TeacherResponse;
import az.edu.msregister.entity.TeacherEntity;
import az.edu.msregister.entity.UserEntity;
import az.edu.msregister.enums.UserRole;
import az.edu.msregister.exceptions.UnauthorizedAccessException;
import az.edu.msregister.exceptions.UserNotFoundException;
import az.edu.msregister.mapper.TeacherMapper;
import az.edu.msregister.repository.TeacherRepository;
import az.edu.msregister.repository.UserRepository;
import az.edu.msregister.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    @Transactional
    public TeacherResponse createTeacher(TeacherRequest requestDto, Authentication authentication) {
        String userEmail = authentication.getName();

        UserEntity user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getRole() != UserRole.STAFF) {
            throw new UnauthorizedAccessException("Only STAFF can create a Teacher");
        }

        TeacherEntity teacherEntity = teacherMapper.toEntity(requestDto);

        teacherEntity.setId(user.getId());
        teacherEntity.setName(user.getName());
        teacherEntity.setSurname(user.getSurname());
        teacherEntity.setEmail(user.getEmail());

        teacherEntity = teacherRepository.save(teacherEntity);

        return teacherMapper.toDto(teacherEntity);
    }

    @Override
    public Optional<TeacherResponse> findByEmail(String email) {
        return teacherRepository.findByEmail(email)
                .map(teacherMapper::toDto);
    }

    @Override
    @Transactional
    public TeacherResponse update(Long id, TeacherRequest requestDto, Authentication authentication) {
        UserEntity user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getRole() != UserRole.STAFF && user.getRole() != UserRole.SUPER_ADMIN) {
            throw new UnauthorizedAccessException("Only STAFF or SUPER_ADMIN can update Teacher info");
        }

        TeacherEntity teacherEntity = teacherRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Teacher not found"));

        teacherEntity.setUniversities(requestDto.getUniversities());
        teacherEntity.setWorkExperiences(requestDto.getWorkExperiences());
        teacherEntity.setTeachingSubjects(requestDto.getTeachingSubjects());
        teacherEntity.setPaymentDetails(requestDto.getPaymentDetails());
        teacherEntity.setBio(requestDto.getBio());
        teacherEntity.setProfilePicture(requestDto.getProfilePicture());
        teacherEntity.setSocialMediaLinks(requestDto.getSocialMediaLinks());
        teacherEntity.setActivityPosts(requestDto.getActivityPosts());

        teacherEntity = teacherRepository.save(teacherEntity);

        return teacherMapper.toDto(teacherEntity);
    }

    @Override
    @Transactional
    public void deleteTeacher(Long teacherId, Authentication authentication) {
        UserEntity user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getRole() != UserRole.SUPER_ADMIN) {
            throw new UnauthorizedAccessException("Only SUPER_ADMIN can delete a teacher");
        }

        TeacherEntity teacherEntity = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new UserNotFoundException("Teacher not found"));

        teacherRepository.delete(teacherEntity);
    }
}
