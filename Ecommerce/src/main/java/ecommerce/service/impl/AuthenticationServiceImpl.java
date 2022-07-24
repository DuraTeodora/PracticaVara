package ecommerce.service.impl;

import ecommerce.component.TokenGenerator;
import ecommerce.exception.BadCredentialsException;
import ecommerce.exception.LoginException;
import ecommerce.model.*;
import ecommerce.repository.AccountRepository;
import ecommerce.service.abs.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.UUID;

@Slf4j
@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Value("${properties.authentification-token-size}")
    private int authenticationTokenSize;

    private final TokenGenerator tokenGenerator;

    private final AccountRepository accountRepository;

    private final AuthenticationTokenServiceImpl authenticationTokenService;

    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(AccountRepository accountRepository, TokenGenerator tokenGenerator, PasswordEncoder passwordEncoder, AuthenticationTokenServiceImpl authentificationTokenService) {
        this.accountRepository = accountRepository;
        this.tokenGenerator = tokenGenerator;
        this.passwordEncoder = passwordEncoder;
        this.authenticationTokenService = authentificationTokenService;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        Account authenticationAccount = accountRepository.getAccountByEmail(loginRequest.getEmail());
        if (!authenticationAccount.getStatus().equals(Status.ACTIVE)) {
            throw new LoginException("Inappropriate status!");
        }
        if (passwordEncoder.matches(loginRequest.getPassword(), authenticationAccount.getPassword())) {
            String authenticationToken = tokenGenerator.generateToken(authenticationTokenSize);
            authenticationTokenService.saveAuthenticationToken(AuthenticationToken.builder()
                    .id(authenticationAccount.getId())
                    .token(authenticationToken).build());
            return LoginResponse.builder()
                    .loginAccount(authenticationAccount)
                    .authenticationToken(authenticationToken)
                    .build();
        } else {
            throw new BadCredentialsException("Data doesn't match!");
        }
    }

    @Override
    public void logout(UUID authenicationAccountId) {
        authenticationTokenService.deleteAuthenticationToken(authenicationAccountId);
    }



}
