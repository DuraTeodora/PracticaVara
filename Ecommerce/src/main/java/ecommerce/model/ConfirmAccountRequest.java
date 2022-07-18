package ecommerce.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmAccountRequest {

    private String token;
    private String password;

}
