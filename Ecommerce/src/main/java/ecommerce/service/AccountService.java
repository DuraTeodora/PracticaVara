package ecommerce.service;

import ecommerce.model.Account;
import ecommerce.model.CreateAccountRequest;

public interface AccountService {

    Account createAccount(CreateAccountRequest accountRequest);
}
