package ecommerce.service.abs;

import ecommerce.model.RegistrationToken;

import java.util.UUID;

public interface RegistrationTokenService {

    RegistrationToken saveRegistrationToken(RegistrationToken token);
    RegistrationToken getRegistrationToken(String token);
    void deleteRegistrationToken(UUID id);
}
