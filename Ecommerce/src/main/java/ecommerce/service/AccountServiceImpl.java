package ecommerce.service;

import ecommerce.component.TokenGenerator;
import ecommerce.model.CreateAccountRequest;
import ecommerce.model.Account;
import ecommerce.model.RegistrationToken;
import ecommerce.repository.AccountRepository;
import ecommerce.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Value("${properties.registration-token-size}")
    private int registrationTokenSize;

    public final AccountRepository accountRepository;

    private final TokenRepository tokenRepository;

    public AccountServiceImpl(AccountRepository registerRepository,
                              TokenGenerator tokenGenerator, TokenRepository tokenRepository) {
        this.accountRepository = registerRepository;
        this.tokenGenerator = tokenGenerator;
        this.tokenRepository = tokenRepository;
    }

    private final TokenGenerator tokenGenerator;

    @Override
    public Account createAccount(CreateAccountRequest accountRequest) {

         Account createdAccount = accountRepository.save(accountRequest.getAccount());
         String registrationToken = tokenGenerator.generateToken(registrationTokenSize);
         tokenRepository.save(new RegistrationToken(accountRequest.getAccount().getId(),registrationToken));
         return createdAccount;

    }

}
