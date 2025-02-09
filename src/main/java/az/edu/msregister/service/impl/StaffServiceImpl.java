package az.edu.msregister.service.impl;

import az.edu.msregister.dto.request.StaffRequest;
import az.edu.msregister.dto.response.StaffResponse;
import az.edu.msregister.entity.StaffEntity;
import az.edu.msregister.entity.UserEntity;
import az.edu.msregister.enums.UserRole;
import az.edu.msregister.exceptions.StaffNotFoundException;
import az.edu.msregister.exceptions.UserNotFoundException;
import az.edu.msregister.exceptions.UnauthorizedAccessException;
import az.edu.msregister.mapper.StaffMapper;
import az.edu.msregister.repository.StaffRepository;
import az.edu.msregister.repository.UserRepository;
import az.edu.msregister.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final UserRepository userRepository;
    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    @Override
    public StaffResponse createStaff(StaffRequest request, Authentication authentication) {
        String userEmail = authentication.getName();
        UserEntity user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getRole() != UserRole.STAFF) {
            throw new UnauthorizedAccessException("Only STAFF can create their own StaffEntity");
        }

        if (staffRepository.existsByUserEntity(user)) {
            throw new RuntimeException("StaffEntity already exists for this user");
        }

        StaffEntity staffEntity = staffMapper.toEntity(request);
        staffEntity.setUser(user);

        staffRepository.save(staffEntity);
        return staffMapper.toDto(staffEntity);
    }

    @Override
    @Transactional
    public StaffResponse updateStaff(StaffRequest request, Authentication authentication) {
        String userEmail = authentication.getName();

        // Fetch the UserEntity based on email
        UserEntity user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + userEmail));

        // Check if the user is STAFF
        if (user.getRole() != UserRole.STAFF) {
            throw new UnauthorizedAccessException("Only users with the STAFF role can update their StaffEntity");
        }

        // Fetch the StaffEntity associated with the user
        StaffEntity existingStaff = staffRepository.findByUserEntity(user)
                .orElseThrow(() -> new StaffNotFoundException("StaffEntity not found for user: " + userEmail));
        System.out.println(existingStaff);  // Check the value of existingStaff here


        // Update the fields from the request
        existingStaff.setJob(request.getJob());
        existingStaff.setBio(request.getBio());
        existingStaff.setPicture(request.getPicture());
        existingStaff.setSocialMediaLinks(request.getSocialMediaLinks());
        existingStaff.setActivityPosts(request.getActivityPosts());

        // Handle attendance status and grade
        if (request.getAttendanceStatus() != null) {
            existingStaff.setAttendanceStatus(List.of(request.getAttendanceStatus()));
        }
        if (request.getAttendanceGrade() != null) {
            existingStaff.setAttendanceGrade(List.of(request.getAttendanceGrade()));
        }

        // Save the updated StaffEntity
        staffRepository.save(existingStaff);

        // Return the response DTO
        return staffMapper.toDto(existingStaff);
    }


}
