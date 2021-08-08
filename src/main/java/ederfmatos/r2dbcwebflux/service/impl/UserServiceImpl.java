package ederfmatos.r2dbcwebflux.service.impl;

import ederfmatos.r2dbcwebflux.controller.request.UserNewRequest;
import ederfmatos.r2dbcwebflux.controller.response.UserResponse;
import ederfmatos.r2dbcwebflux.mapper.UserMapper;
import ederfmatos.r2dbcwebflux.model.User;
import ederfmatos.r2dbcwebflux.repository.UserRepository;
import ederfmatos.r2dbcwebflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<UserResponse> create(UserNewRequest userNewRequest) {
        User user = userMapper.mapToEntity(userNewRequest);
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user)
                .map(userMapper::mapToResponse);
    }

    @Override
    public Flux<UserResponse> findAll() {
        return userRepository.findAll()
                .map(userMapper::mapToResponse);
    }

}
