package ecommerce.repository;

import ecommerce.model.RegistrationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<RegistrationToken,Integer> {

}
