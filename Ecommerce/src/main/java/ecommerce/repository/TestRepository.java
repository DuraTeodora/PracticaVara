package ecommerce.repository;

import ecommerce.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface TestRepository extends JpaRepository<Test, UUID> {

    Test getById(Integer id);
    List<Test> findAll();
    void deleteById(Integer id);

}
