package ecommerce.repository;

import ecommerce.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account getAccountById(int id);
}
