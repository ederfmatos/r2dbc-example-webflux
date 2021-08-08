package ederfmatos.r2dbcwebflux.service;

import ederfmatos.r2dbcwebflux.controller.request.UserNewRequest;
import ederfmatos.r2dbcwebflux.controller.response.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserResponse> create(UserNewRequest userNewRequest);

    Flux<UserResponse> findAll();

}
