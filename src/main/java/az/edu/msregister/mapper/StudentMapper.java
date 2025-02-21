package az.edu.msregister.mapper;

import az.edu.msregister.dto.request.StudentRequest;
import az.edu.msregister.dto.response.StudentResponse;
import az.edu.msregister.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "user", ignore = true) // Handle user mapping manually if needed
    })
    StudentEntity toEntity(StudentRequest studentRequest);

    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "universities", source = "universities")
    @Mapping(target = "workExperiences", source = "workExperiences")
    @Mapping(target = "studySpecialization", source = "studySpecialization")
    @Mapping(target = "paymentDetails", source = "paymentDetails")
    @Mapping(target = "group", source = "group")
    @Mapping(target = "attendanceStatus", source = "attendanceStatus")
    @Mapping(target = "grades", source = "grades")
    @Mapping(target = "bio", source = "bio")
    @Mapping(target = "profilePicture", source = "profilePicture")
    @Mapping(target = "socialMediaPlatform", source = "socialMediaPlatform")
    @Mapping(target = "socialMediaLink", source = "socialMediaLink")
    @Mapping(target = "activityPosts", source = "activityPosts")
        // These mappings are inherited from UserResponse because StudentResponse extends it
    StudentResponse toDto(StudentEntity studentEntity);
}
