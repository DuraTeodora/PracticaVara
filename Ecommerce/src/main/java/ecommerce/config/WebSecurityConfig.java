package ecommerce.config;

import ecommerce.component.TokenAuthenticationEntryPoint;
import ecommerce.component.TokenAuthenticationProvider;
import ecommerce.component.TokenFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenAuthenticationProvider tokenAuthenticationProvider;

    private final TokenFilter tokenFilter;

    private TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint;

    public WebSecurityConfig(TokenAuthenticationProvider tokenAuthenticationProvider, TokenFilter tokenFilter, TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint) {
        this.tokenAuthenticationProvider = tokenAuthenticationProvider;
        this.tokenFilter = tokenFilter;
        this.tokenAuthenticationEntryPoint = tokenAuthenticationEntryPoint;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder){
        authenticationManagerBuilder.authenticationProvider(tokenAuthenticationProvider);
    }

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/account/");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(tokenAuthenticationEntryPoint)
                .and()
                .authenticationProvider(tokenAuthenticationProvider)
                .addFilterBefore(tokenFilter, AnonymousAuthenticationFilter.class)
                .csrf().disable()
                .httpBasic().authenticationEntryPoint(new TokenAuthenticationEntryPoint())
                .and()
                .logout().disable();
    }
}
