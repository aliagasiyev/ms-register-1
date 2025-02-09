package az.edu.msregister.service;

import az.edu.msregister.dto.request.StaffRequest;
import az.edu.msregister.dto.response.StaffResponse;
import org.springframework.security.core.Authentication;

public interface StaffService {

    StaffResponse createStaff(StaffRequest request, Authentication authentication);

    StaffResponse updateStaff(StaffRequest request, Authentication authentication);
}
