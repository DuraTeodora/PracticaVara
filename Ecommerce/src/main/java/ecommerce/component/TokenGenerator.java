package ecommerce.component;

import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {

    public String generateToken(int size){
        return org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(size);
    }
}
