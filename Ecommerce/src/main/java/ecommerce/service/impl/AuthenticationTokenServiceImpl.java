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

    private final AuthenticationTokenRepository authentificationTokenRepository;

    public AuthenticationTokenServiceImpl(AuthenticationTokenRepository authentificationTokenRepository) {
        this.authentificationTokenRepository = authentificationTokenRepository;
    }

    @Override
    public AuthenticationToken saveAuthentificationToken(AuthenticationToken authentificationToken) {
        return authentificationTokenRepository.save(authentificationToken);
    }

    @Override
    public void deleteAuthentificationToken(UUID id) {
        authentificationTokenRepository.deleteAuthentificationTokenById(id);
    }

}
