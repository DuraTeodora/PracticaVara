package ecommerce.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CreateStoreRequest {

    private String name;
    private String description;
    private String address;
    private Integer employees;
}
