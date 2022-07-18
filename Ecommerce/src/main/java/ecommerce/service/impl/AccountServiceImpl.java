package ecommerce.service.impl;

import ecommerce.model.*;
import ecommerce.component.TokenGenerator;
import ecommerce.service.abs.AccountService;
import org.springframework.stereotype.Service;
import ecommerce.repository.AccountRepository;
import static ecommerce.utils.ApplicationConstants.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AccountServiceImpl implements AccountService {

    @Value("${properties.registration-token-size}")
    private int registrationTokenSize;

    private final EmailSenderService emailSenderService;

    private final AccountRepository accountRepository;

    private final TokenServiceImpl tokenService;

    private final TokenGenerator tokenGenerator;

    private final PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository registerRepository,
                              TokenGenerator tokenGenerator,
                              EmailSenderService emailSenderService, TokenServiceImpl tokenService, PasswordEncoder passwordEncoder) {
        this.accountRepository = registerRepository;
        this.tokenGenerator = tokenGenerator;
        this.tokenService = tokenService;
        this.emailSenderService = emailSenderService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account createAccount(CreateAccountRequest accountRequest){

         accountRequest.getAccount().setStatus(Status.PENDING);
         Account createdAccount = accountRepository.save(accountRequest.getAccount());
         String registrationToken = tokenGenerator.generateToken(registrationTokenSize);
         tokenService.saveToken(RegistrationToken.builder()
                 .id(accountRequest.getAccount().getId())
                 .token(registrationToken).build());
         emailSenderService.registerEmail(accountRequest.getAccount().getEmail(),registrationToken,registerConstant);
         return createdAccount;

    }

    @Override
    public Account confirmAccount(ConfirmAccountRequest confirmRequest) {

        Integer registerAccountId = tokenService.getToken(confirmRequest.getToken()).getId();
        Account registerAccount = accountRepository.getAccountById(registerAccountId);
        try{
            if(registerAccount.getStatus().equals(Status.PENDING)){
                System.out.println("The account's status is pending!");
                registerAccount.setStatus(Status.ACTIVE);
                registerAccount.setPassword(passwordEncoder.encode(confirmRequest.getPassword()));
                accountRepository.save(registerAccount);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return registerAccount;
    }

//    public static String encodeToBase64(String message) {
//        return Base64.getEncoder().encodeToString(message.getBytes());
//    }

}
