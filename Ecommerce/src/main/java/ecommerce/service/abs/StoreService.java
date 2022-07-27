package ecommerce.service.abs;

import ecommerce.model.CreateStoreRequest;
import ecommerce.model.Store;

public interface StoreService {

    Store createStore(CreateStoreRequest createStoreRequest);
}
