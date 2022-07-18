package ecommerce.controller;

import javax.validation.Valid;
import ecommerce.model.Account;
import ecommerce.model.CreateAccountRequest;
import ecommerce.model.ConfirmAccountRequest;
import ecommerce.service.impl.AccountServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    public final AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl registerService) {
        this.accountService = registerService;
    }

    @RequestMapping(value="/create",method= RequestMethod.POST)
    public Account createAccount(@Valid @RequestBody CreateAccountRequest accountRequest){
        return accountService.createAccount(accountRequest);
    }

    @RequestMapping(value="/confirm",method= RequestMethod.POST)
    public Account confirmAccount(@Valid @RequestBody ConfirmAccountRequest confirmRequest){
        return accountService.confirmAccount(confirmRequest);
    }

}
