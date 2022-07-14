package ecommerce.service;

import ecommerce.model.RegistrationToken;
import ecommerce.repository.TokenRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    public final TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public RegistrationToken save(RegistrationToken token) {
        return tokenRepository.save(token);
    }
}
