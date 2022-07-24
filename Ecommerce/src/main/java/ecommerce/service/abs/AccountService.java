package ecommerce.service.abs;

import ecommerce.model.Account;
import ecommerce.model.ConfirmAccountRequest;
import ecommerce.model.CreateAccountRequest;
import java.util.UUID;

public interface AccountService {

    Account createAccount(CreateAccountRequest accountRequest);
    Account confirmAccount(ConfirmAccountRequest confirmRequest);
    Account getAccountById(UUID id);
}
