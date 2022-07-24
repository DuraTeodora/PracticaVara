package ecommerce.repository;

import ecommerce.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account,UUID> {

    Account getAccountById(UUID id);
    Account getAccountByEmail(String email);
}
