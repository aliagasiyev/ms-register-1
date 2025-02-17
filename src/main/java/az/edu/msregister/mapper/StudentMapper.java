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
            @Mapping(target = "user", ignore = true) // Needs manual handling
    })
    StudentEntity toEntity(StudentRequest studentRequest);

    StudentResponse toDto(StudentEntity studentEntity);


    }