package az.edu.msregister.mapper;

import az.edu.msregister.dto.request.TeacherRequest;
import az.edu.msregister.dto.response.TeacherResponse;
import az.edu.msregister.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    TeacherEntity toEntity(TeacherRequest request);

    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "surname", source = "user.surname")
    @Mapping(target = "fin", source = "user.fin")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "specialization", source = "user.specialization")
    @Mapping(target = "courseEmail", source = "user.courseEmail")
    @Mapping(target = "phoneNumber", source = "user.phoneNumber")
    @Mapping(target = "role", source = "user.role")
    TeacherResponse toDto(TeacherEntity entity);
}
