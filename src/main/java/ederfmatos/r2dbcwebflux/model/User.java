package ederfmatos.r2dbcwebflux.model;

import ederfmatos.r2dbcwebflux.lib.Persistable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table("USERS")
public class User implements Persistable {

    @Id
    @Column("id")
    private String id;

    @Column("name")
    private String name;

    @Column("email")
    private String email;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

}
