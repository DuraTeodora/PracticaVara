package ecommerce.component;

import ecommerce.model.CustomAuthentication;
import ecommerce.model.AuthenticationToken;
import ecommerce.service.impl.AccountServiceImpl;
import ecommerce.service.impl.AuthenticationTokenServiceImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    private final AccountServiceImpl accountService;
    private final AuthenticationTokenServiceImpl authenticationTokenService;

    public TokenAuthenticationProvider(AccountServiceImpl accountService, AuthenticationTokenServiceImpl authenticationTokenService) {
        this.accountService = accountService;
        this.authenticationTokenService = authenticationTokenService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String token = (String) authentication.getCredentials();
        AuthenticationToken authenticationToken = authenticationTokenService.getAuthenticationToken(token);

        return CustomAuthentication.builder()
                .account(accountService.getAccountById(authenticationToken.getId()))
                .authenticated(true)
                .build();
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
