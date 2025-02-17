package az.edu.msregister.mapper;

import az.edu.msregister.dto.request.StaffRequest;
import az.edu.msregister.dto.response.StaffResponse;
import az.edu.msregister.entity.StaffEntity;
import az.edu.msregister.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    @Mapping(source = "user", target = "userEntity")
    @Mapping(target = "id", ignore = true)
    StaffEntity toEntity(StaffRequest request, UserEntity user);

    @Mapping(source = "userEntity", target = ".")
    StaffResponse toDto(StaffEntity entity);

    default void updateStaffEntity(StaffEntity existingEntity, StaffRequest request) {
        existingEntity.setJob(request.getJob());
        existingEntity.setBio(request.getBio());
        existingEntity.setPicture(request.getPicture());
        existingEntity.setSocialMediaLinks(request.getSocialMediaLinks());
        existingEntity.setActivityPosts(request.getActivityPosts());
        existingEntity.setAttendanceStatus(request.getAttendanceStatus());
        existingEntity.setAttendanceGrade(request.getAttendanceGrade());
    }
}
