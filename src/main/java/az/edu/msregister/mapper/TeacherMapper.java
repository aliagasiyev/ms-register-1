package az.edu.msregister.mapper;

import az.edu.msregister.dto.request.TeacherRequest;
import az.edu.msregister.dto.response.TeacherResponse;
import az.edu.msregister.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherEntity toEntity(TeacherRequest dto);

    TeacherResponse toDto(TeacherEntity entity);
}
