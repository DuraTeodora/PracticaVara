package ecommerce.controller;

import ecommerce.model.LoginRequest;
import ecommerce.model.LoginResponse;
import ecommerce.service.impl.AuthenticationServiceImpl;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;

    public AuthenticationController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @RequestMapping(value = "/logout/{authenticationAccountId}", method = RequestMethod.POST)
    public void logout(@PathVariable UUID authenticationAccountId) {
        authenticationService.logout(authenticationAccountId);
    }
}
