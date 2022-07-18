package ecommerce.service.abs;

import ecommerce.model.RegistrationToken;

public interface TokenService {

    RegistrationToken saveToken(RegistrationToken token);
    RegistrationToken getToken(String token);
}
