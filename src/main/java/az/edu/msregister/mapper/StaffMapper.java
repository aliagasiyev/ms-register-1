package az.edu.msregister.mapper;

import az.edu.msregister.dto.request.StaffRequest;
import az.edu.msregister.dto.response.StaffResponse;
import az.edu.msregister.entity.StaffEntity;
import az.edu.msregister.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = ".", target = "userEntity", qualifiedByName = "mapUserEntity")
    @Mapping(target = "job", source = "job")
    @Mapping(target = "bio", source = "bio")
    @Mapping(target = "picture", source = "picture")
    @Mapping(source = "socialMediaLinks", target = "socialMediaLinks", qualifiedByName = "mapSocialMediaLinks")
    @Mapping(target = "activityPosts", source = "activityPosts")
    @Mapping(source = "attendanceStatus", target = "attendanceStatus", qualifiedByName = "mapAttendanceStatusToList")
    @Mapping(source = "attendanceGrade", target = "attendanceGrade", qualifiedByName = "mapAttendanceGradeToList")
    StaffEntity toEntity(StaffRequest dto);

    @Mapping(source = "userEntity.name", target = "name")
    @Mapping(source = "userEntity.surname", target = "surname")
    @Mapping(source = "userEntity.email", target = "email")
    @Mapping(source = "userEntity.fin", target = "fin")
    @Mapping(source = "userEntity.specialization", target = "specialization")
    @Mapping(source = "userEntity.courseEmail", target = "courseEmail")
    @Mapping(source = "userEntity.phoneNumber", target = "phoneNumber")
    @Mapping(source = "userEntity.role", target = "role")
    @Mapping(source = "job", target = "job")
    @Mapping(source = "bio", target = "bio")
    @Mapping(source = "picture", target = "picture")
    @Mapping(source = "socialMediaLinks", target = "socialMediaLinks", qualifiedByName = "mapSocialMediaToString")
    @Mapping(source = "activityPosts", target = "activityPosts")
    @Mapping(source = "attendanceStatus", target = "attendanceStatus")
    @Mapping(source = "attendanceGrade", target = "attendanceGrade")
    StaffResponse toDto(StaffEntity staffEntity);

    @Named("mapUserEntity")
    default UserEntity mapUserEntity(StaffRequest request) {
        return UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .fin(request.getFin())
                .email(request.getEmail())
                .specialization(request.getSpecialization())
                .courseEmail(request.getCourseEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }

    @Named("mapSocialMediaLinks")
    default List<String> mapSocialMediaLinks(List<String> socialMediaLinks) {
        return socialMediaLinks != null ? socialMediaLinks : Collections.emptyList();
    }

    @Named("mapAttendanceStatusToList")
    default List<String> mapAttendanceStatusToList(String attendanceStatus) {
        return StringUtils.hasText(attendanceStatus)
                ? Arrays.asList(attendanceStatus.split("\\s*,\\s*"))
                : Collections.emptyList();
    }

    @Named("mapAttendanceGradeToList")
    default List<String> mapAttendanceGradeToList(String attendanceGrade) {
        return StringUtils.hasText(attendanceGrade)
                ? Arrays.asList(attendanceGrade.split("\\s*,\\s*"))
                : Collections.emptyList();
    }

    @Named("mapSocialMediaToString")
    default List<String> mapSocialMediaToString(List<String> socialMediaLinks) {
        return socialMediaLinks != null ? socialMediaLinks : Collections.emptyList();
    }
}