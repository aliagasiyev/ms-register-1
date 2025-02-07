package az.edu.msregister.service;

import az.edu.msregister.entity.StaffEntity;

import java.util.List;

public interface StaffService {
    StaffEntity createStaff(StaffEntity staff);

    StaffEntity updateStaff(StaffEntity staff);

    StaffEntity getStaffById(Long id);

    void deleteStaff(Long id);

    List<StaffEntity> getAllStaff();
}
