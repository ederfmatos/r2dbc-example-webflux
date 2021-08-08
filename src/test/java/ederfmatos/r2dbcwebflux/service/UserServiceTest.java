package ederfmatos.r2dbcwebflux.service;

import ederfmatos.r2dbcwebflux.controller.request.UserNewRequest;
import ederfmatos.r2dbcwebflux.controller.response.UserResponse;
import ederfmatos.r2dbcwebflux.mapper.UserMapper;
import ederfmatos.r2dbcwebflux.model.User;
import ederfmatos.r2dbcwebflux.repository.UserRepository;
import ederfmatos.r2dbcwebflux.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserMapper userMapper;

    @Mock
    UserRepository userRepository;

    @Test
    void shouldListAllUsers() {
        when(userMapper.mapToResponse(any()))
                .thenReturn(new UserResponse());

        when(userRepository.findAll())
                .thenReturn(Flux.just(new User(), new User()));

        userService.findAll()
                .as(StepVerifier::create)
                .expectNextCount(2)
                .verifyComplete();

        verify(userRepository).findAll();
    }

    @Test
    void shouldCreateNewUser() {
        when(userRepository.save(any()))
                .thenReturn(Mono.just(new User()));

        when(userMapper.mapToResponse(any()))
                .thenReturn(new UserResponse());

        when(userMapper.mapToEntity(any()))
                .thenReturn(new User());

        userService.create(new UserNewRequest())
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();

        verify(userRepository).save(any());
    }

}
