package ecommerce.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {

    private Account account;

}
