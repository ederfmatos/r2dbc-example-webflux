package ederfmatos.r2dbcwebflux.config.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerHandlerAdvice {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleWebExchangeBindException(WebExchangeBindException exception) {
        return Map.of(
                "errors", exception.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage))
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleException(Exception exception) {
        exception.printStackTrace();
        return Map.of("error", "Ocorreu um erro interno");
    }

}
