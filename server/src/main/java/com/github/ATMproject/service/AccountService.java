package com.github.ATMproject.service;

import com.github.ATMproject.entity.Account;
import com.github.ATMproject.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public Account addAccount(Account account){
        return accountRepository.save(account);
    }

    public Account getAccount(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }
}
