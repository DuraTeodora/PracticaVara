package ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationToken {

    @Id
    @Column(name="account_id",nullable=false)
    private Integer id;

    @Column(name="token",nullable=false)
    private String token;

}
