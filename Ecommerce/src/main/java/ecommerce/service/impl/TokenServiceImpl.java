package ecommerce.service.impl;

import ecommerce.model.RegistrationToken;
import ecommerce.repository.TokenRepository;
import ecommerce.service.abs.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    public final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public RegistrationToken saveToken(RegistrationToken token) {
        return tokenRepository.save(token);
    }

    @Override
    public RegistrationToken getToken(String token) {
        return tokenRepository.getRegistrationTokenByToken(token);
    }

}
