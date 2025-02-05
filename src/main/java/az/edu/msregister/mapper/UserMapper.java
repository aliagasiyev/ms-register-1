package az.edu.msregister.mapper;
import az.edu.msregister.dto.response.UserResponse;
import az.edu.msregister.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse toResponse(UserEntity user);
}