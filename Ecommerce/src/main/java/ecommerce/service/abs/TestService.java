package ecommerce.service.abs;

import ecommerce.model.Test;

import java.util.List;

public interface TestService {

    Test save(Test test);
    List<Test> getAll();
    void delete(Integer id);
    //Test update(Test test);

}
