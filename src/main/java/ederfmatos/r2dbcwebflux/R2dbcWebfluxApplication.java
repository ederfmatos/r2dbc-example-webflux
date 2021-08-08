package ederfmatos.r2dbcwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcAuditing
@SpringBootApplication
@EnableR2dbcRepositories
public class R2dbcWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(R2dbcWebfluxApplication.class, args);
    }

}
