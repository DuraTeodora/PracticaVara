package ecommerce.service;

import ecommerce.model.RegistrationToken;

public interface TokenService {

    RegistrationToken save(RegistrationToken token);
}
