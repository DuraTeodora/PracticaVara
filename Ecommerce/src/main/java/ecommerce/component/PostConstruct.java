package ecommerce.component;

import org.springframework.stereotype.Component;

@Component
public class PostConstruct {

    @javax.annotation.PostConstruct
    public void PostConstruct(){
        System.out.println("We are at this point");
    }
}
