package ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Account")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    @GeneratedValue
    private UUID id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email",unique=true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone", unique=true)
    private String phone;

    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @CreationTimestamp
    private LocalDateTime createdOn;

    public Account hidePassword(){
        this.setPassword("");
        return this;
    }

}
