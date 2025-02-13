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

    // Convert TeacherRequest to TeacherEntity
    TeacherEntity toEntity(TeacherRequest teacherRequest);

    // Convert TeacherEntity to TeacherResponse
    TeacherResponse toDto(TeacherEntity teacherEntity);
}
