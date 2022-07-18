package ecommerce.repository;

import ecommerce.model.RegistrationToken;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TokenRepository extends JpaRepository<RegistrationToken,Integer> {

    RegistrationToken getRegistrationTokenByToken(String Token);
}
