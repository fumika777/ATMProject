package com.github.ATMproject.repository;

import com.github.ATMproject.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
    Account save (Account account);
}
