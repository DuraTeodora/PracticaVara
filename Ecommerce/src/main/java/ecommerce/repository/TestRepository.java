package ecommerce.repository;

import ecommerce.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {

    Test getById(Integer id);
    List<Test> findAll();
    void deleteById(Integer id);

}
