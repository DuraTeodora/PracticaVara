package ecommerce.service.impl;

import ecommerce.model.Test;
import ecommerce.service.abs.TestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceSimulationImpl implements TestService {
    @Override
    public Test save(Test test) {
        return null;
    }

    @Override
    public List<Test> getAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Test update(Test test) {
        return null;
    }
}
