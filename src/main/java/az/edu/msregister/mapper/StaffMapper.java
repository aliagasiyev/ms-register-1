package az.edu.msregister.mapper;

import az.edu.msregister.dto.request.StaffRequest;
import az.edu.msregister.dto.response.StaffResponse;
import az.edu.msregister.entity.StaffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StaffMapper {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    StaffEntity toEntity(StaffRequest dto);

    StaffResponse toDto(StaffEntity entity);
}