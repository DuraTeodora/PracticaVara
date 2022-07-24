package ecommerce.service.abs;

import ecommerce.model.LoginRequest;
import ecommerce.model.LoginResponse;
import java.util.UUID;

public interface AuthenticationService {

    LoginResponse login(LoginRequest loginRequest);
    void logout(UUID authentificationAccountId);

}
