package ecommerce.service.impl;

import ecommerce.exception.StoreCreateException;
import ecommerce.model.*;
import ecommerce.repository.StoreRepository;
import ecommerce.service.abs.StoreService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store createStore(CreateStoreRequest createStoreRequest) {

        CustomAuthentication authentication = (CustomAuthentication) SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.getAccount().getRole().equals(Role.OWNER)){
            throw new StoreCreateException("Inappropiate role!");
        }

        return storeRepository.save(Store.builder()
                .name(createStoreRequest.getName())
                .description(createStoreRequest.getDescription())
                .address(createStoreRequest.getAddress())
                .employees(createStoreRequest.getEmployees())
                .ownerId(authentication.getAccount().getId())
                .build());
    }
}
