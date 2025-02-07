package az.edu.msregister.service;

import az.edu.msregister.dto.request.StaffRequest;
import az.edu.msregister.dto.response.StaffResponse;
import az.edu.msregister.entity.StaffEntity;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    StaffResponse createStaff(StaffRequest requestDto);

    Optional findByEmail(String email);
}