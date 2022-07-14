package ecommerce.controller;

import ecommerce.model.Account;
import ecommerce.model.CreateAccountRequest;
import ecommerce.service.AccountServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

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

}
