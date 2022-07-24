package ecommerce.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationToken {

    @Id
    @Column(name = "account_id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name="token",nullable=false)
    private String token;
}
