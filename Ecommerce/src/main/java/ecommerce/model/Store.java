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
public class Store {

    @Id
    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="address")
    private String address;

    @Column(name="latitude")
    private String latitude;

    @Column(name="longitude")
    private String longitude;

    @Column(name="employees")
    private Integer employees;

    @Column(name="ownerId",updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    private UUID ownerId;

    @Column(name="logo")
    private String logo;

}
