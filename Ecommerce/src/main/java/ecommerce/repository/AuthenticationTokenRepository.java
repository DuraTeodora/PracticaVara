package ecommerce.repository;

import ecommerce.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AuthenticationTokenRepository extends JpaRepository<AuthenticationToken, UUID> {

    void deleteAuthentificationTokenById(UUID id);
}
