package ecommerce.repository;

import ecommerce.model.RegistrationToken;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

@Repository
public interface RegistrationTokenRepository extends JpaRepository<RegistrationToken, UUID> {

    RegistrationToken getRegistrationTokenByToken(String Token);
    void deleteRegistrationTokenById(UUID id);
}
