package com.github.ATMproject;

import com.github.ATMproject.entity.Account;

import java.util.Hashtable;
import java.util.Map;

public class AccountRepositoryClass {
    private static final Map<String, Account> accountRepository = new Hashtable<>();

    public Account addAccount(Account account){
        accountRepository.put(account.getAccountNumber(), account);
        return account;
    }

    public Account getAccount(String accountNumber){
        return accountRepository.get(accountNumber);
    }
}
