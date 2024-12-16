package io.pratik.banking;

import io.pratik.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, id> {

}
