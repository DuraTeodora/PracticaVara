package ecommerce.service.abs;

import ecommerce.model.Account;
import ecommerce.model.ConfirmAccountRequest;
import ecommerce.model.CreateAccountRequest;

public interface AccountService {

    Account createAccount(CreateAccountRequest accountRequest);
    Account confirmAccount(ConfirmAccountRequest confirmRequest);
}
