package ecommerce.service.impl;

import ecommerce.model.RegistrationToken;
import ecommerce.repository.RegistrationTokenRepository;
import ecommerce.service.abs.RegistrationTokenService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class RegistrationTokenServiceImpl implements RegistrationTokenService {

    public final RegistrationTokenRepository tokenRepository;

    public RegistrationTokenServiceImpl(RegistrationTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public RegistrationToken saveRegistrationToken(RegistrationToken token) {
        return tokenRepository.save(token);
    }

    @Override
    public RegistrationToken getRegistrationToken(String token) {
        return tokenRepository.getRegistrationTokenByToken(token);
    }

    @Override
    public void deleteRegistrationToken(UUID id) {
        tokenRepository.deleteRegistrationTokenById(id);
    }

}
