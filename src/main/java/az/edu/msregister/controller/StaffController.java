package az.edu.msregister.controller;

import az.edu.msregister.dto.request.StaffRequest;
import az.edu.msregister.dto.response.StaffResponse;
import az.edu.msregister.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('STAFF')")
    public StaffResponse createStaff(@RequestBody StaffRequest request, Authentication authentication) {
        return staffService.createStaff(request, authentication);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('STAFF')")
    public StaffResponse updateStaff(@RequestBody StaffRequest request, Authentication authentication) {
        return staffService.updateStaff(request, authentication);
    }

    @DeleteMapping("/delete/{staffId}")
    @PreAuthorize("hasRole('STAFF')")
    public void deleteStaff(@PathVariable Long staffId, Authentication authentication) {
        staffService.deleteStaff(staffId, authentication);
    }
}
