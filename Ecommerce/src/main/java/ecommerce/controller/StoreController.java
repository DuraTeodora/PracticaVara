package ecommerce.controller;

import ecommerce.model.CreateStoreRequest;
import ecommerce.model.Store;
import ecommerce.service.impl.StoreServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/store")
public class StoreController {

    private StoreServiceImpl storeService;

    public StoreController(StoreServiceImpl storeService) {
        this.storeService = storeService;
    }

    @RequestMapping(value="/create",method= RequestMethod.POST)
    public Store createStore(@Valid @RequestBody CreateStoreRequest createStoreRequest){
        return storeService.createStore(createStoreRequest);
    }

    //TODO
    //create, update magazin

}
