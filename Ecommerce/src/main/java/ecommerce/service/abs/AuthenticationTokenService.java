package ecommerce.service.abs;

import ecommerce.model.AuthenticationToken;

import java.util.UUID;

public interface AuthenticationTokenService {

    AuthenticationToken saveAuthenticationToken(AuthenticationToken token);
    void deleteAuthenticationToken(UUID id);
    AuthenticationToken getAuthenticationToken(String token);
}
