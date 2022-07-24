package ecommerce.service.impl;

import ecommerce.model.AuthenticationToken;
import ecommerce.repository.AuthenticationTokenRepository;
import ecommerce.service.abs.AuthenticationTokenService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class AuthenticationTokenServiceImpl implements AuthenticationTokenService {

    private final AuthenticationTokenRepository authenticationTokenRepository;

    public AuthenticationTokenServiceImpl(AuthenticationTokenRepository authentificationTokenRepository) {
        this.authenticationTokenRepository = authentificationTokenRepository;
    }

    @Override
    public AuthenticationToken saveAuthenticationToken(AuthenticationToken authentificationToken) {
        return authenticationTokenRepository.save(authentificationToken);
    }

    @Override
    public void deleteAuthenticationToken(UUID id) {
        authenticationTokenRepository.deleteAuthentificationTokenById(id);
    }

    @Override
    public AuthenticationToken getAuthenticationToken(String token) {
        return authenticationTokenRepository.getAuthenticationTokenByToken(token);
    }

}
