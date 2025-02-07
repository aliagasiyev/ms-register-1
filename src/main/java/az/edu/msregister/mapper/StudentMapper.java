package az.edu.msregister.mapper;

import az.edu.msregister.dto.request.StudentRequest;
import az.edu.msregister.dto.response.StudentResponse;
import az.edu.msregister.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentEntity toEntity(StudentRequest dto);

    StudentResponse toDto(StudentEntity entity);
}
