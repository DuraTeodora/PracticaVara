package ecommerce.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private Account loginAccount;
    private String authentificationToken;
}
