package ecommerce.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationToken {

    @Id
    @Column(name="account_id",nullable=false)
    private Integer id;

    @Column(name="token",nullable=false)
    private String token;

}
