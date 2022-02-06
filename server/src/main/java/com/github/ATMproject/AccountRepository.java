package com.github.ATMproject;

import java.util.Hashtable;
import java.util.Map;

public class AccountRepository {
    private static final Map<String,Account> accountRepository = new Hashtable<>();

    public Account addAccount(Account account){
        accountRepository.put(account.getAccountNumber(), account);
        return account;
    }

    public Account getAccount(String accountNumber){
        return accountRepository.get(accountNumber);
    }
}
