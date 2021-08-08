package ederfmatos.r2dbcwebflux.mapper;

import ederfmatos.r2dbcwebflux.controller.request.UserNewRequest;
import ederfmatos.r2dbcwebflux.controller.response.UserResponse;
import ederfmatos.r2dbcwebflux.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper {

    User mapToEntity(UserNewRequest userNewRequest);

    UserResponse mapToResponse(User user);

}
