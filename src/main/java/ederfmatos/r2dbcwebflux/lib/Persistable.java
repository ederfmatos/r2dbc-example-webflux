package ederfmatos.r2dbcwebflux.lib;

import java.time.LocalDateTime;

public interface Persistable extends org.springframework.data.domain.Persistable<String> {

    LocalDateTime getCreatedAt();

    LocalDateTime getUpdatedAt();

    default boolean isNew() {
        return this.getCreatedAt() == this.getUpdatedAt();
    }
}
