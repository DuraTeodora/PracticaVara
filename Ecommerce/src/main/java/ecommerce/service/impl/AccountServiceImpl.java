package ecommerce.service.impl;

import ecommerce.model.*;
import ecommerce.component.TokenGenerator;
import ecommerce.service.abs.AccountService;
import org.springframework.stereotype.Service;
import ecommerce.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Value("${properties.registration-token-size}")
    private int registrationTokenSize;

    private final EmailSenderService emailSenderService;

    private final AccountRepository accountRepository;

    private final RegistrationTokenServiceImpl tokenService;

    private final TokenGenerator tokenGenerator;

    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository registerRepository,
                              TokenGenerator tokenGenerator,
                              EmailSenderService emailSenderService, RegistrationTokenServiceImpl tokenService, PasswordEncoder passwordEncoder) {
        this.accountRepository = registerRepository;
        this.tokenGenerator = tokenGenerator;
        this.tokenService = tokenService;
        this.emailSenderService = emailSenderService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account createAccount(CreateAccountRequest accountRequest) {

        accountRequest.getAccount().setStatus(Status.PENDING);
        Account createdAccount = accountRepository.save(accountRequest.getAccount());
        String registrationToken = tokenGenerator.generateToken(registrationTokenSize);
        tokenService.saveRegistrationToken(RegistrationToken.builder()
                .id(accountRequest.getAccount().getId())
                .token(registrationToken).build());
        //emailSenderService.registerEmail(accountRequest.getAccount().getEmail(), registrationToken, registerConstant);
        return createdAccount;

    }

    @Override
    public Account confirmAccount(ConfirmAccountRequest confirmRequest) {

        RegistrationToken registerToken = tokenService.getRegistrationToken(confirmRequest.getToken());
        UUID registerAccountId = registerToken.getId();
        tokenService.deleteRegistrationToken(registerToken.getId());
        Account registerAccount = accountRepository.getAccountById(registerAccountId);

        if (!registerAccount.getStatus().equals(Status.PENDING)) {
            throw new IllegalArgumentException("Account's status is not pending");
        }

        System.out.println("Account's status is pending!");
        registerAccount.setStatus(Status.ACTIVE);
        registerAccount.setPassword(passwordEncoder.encode(confirmRequest.getPassword()));
        accountRepository.save(registerAccount);
        return registerAccount;
    }

    @Override
    public Account getAccountById(UUID id) {
        return accountRepository.getAccountById(id);
    }

}
