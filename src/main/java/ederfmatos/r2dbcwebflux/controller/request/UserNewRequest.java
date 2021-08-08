package ederfmatos.r2dbcwebflux.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserNewRequest {

    @NotNull(message = "O nome é obrigatório")
    private String name;

    @NotNull(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

}
