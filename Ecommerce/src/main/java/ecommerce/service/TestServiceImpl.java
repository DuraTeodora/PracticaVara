package ecommerce.service;

import ecommerce.model.Test;
import ecommerce.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    public TestRepository testRepository;


    @Override
    public Test save(Test test) {
//        Test.TestBuilder test1 = Test.builder().id(10);
//        test1.build();
        return testRepository.save(test);
    }

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        testRepository.deleteById(id);
    }

    @Override
    public Test update(Test test) {
        Test testDB = testRepository.findById(test.getId()).get();
        //cu adnotari
        if (Objects.nonNull(test.getFirstName()) && !"".equalsIgnoreCase(test.getFirstName())) {
            testDB.setFirstName(test.getFirstName());
        }

        if (Objects.nonNull(test.getLastName()) && !"".equalsIgnoreCase(test.getLastName())) {
            testDB.setLastName(test.getLastName());
        }

        if (Objects.nonNull(test.getEmail()) && !"".equalsIgnoreCase(test.getEmail())) {
            testDB.setEmail(test.getEmail());
        }

        return testRepository.save(testDB);
    }
}
