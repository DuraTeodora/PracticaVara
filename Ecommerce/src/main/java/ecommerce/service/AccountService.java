package ecommerce.service;

import ecommerce.model.Account;
import ecommerce.model.CreateAccountRequest;

import javax.mail.MessagingException;

public interface AccountService {

    Account createAccount(CreateAccountRequest accountRequest) throws MessagingException;
}
