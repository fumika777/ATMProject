package com.github.ATMproject;

import java.util.Set;

public class AccountRepository {
    private Set<Account> repository;

    public AccountRepository(){
    }

    public void addAccount(Account account){
        repository.add(account);
    }
}
