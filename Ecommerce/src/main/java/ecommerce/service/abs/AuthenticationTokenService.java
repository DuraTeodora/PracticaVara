package ecommerce.service.abs;

import ecommerce.model.AuthenticationToken;

import java.util.UUID;

public interface AuthenticationTokenService {

    AuthenticationToken saveAuthentificationToken(AuthenticationToken token);
    void deleteAuthentificationToken(UUID id);
}
