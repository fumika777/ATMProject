package com.github.ATMproject;

public class Account {
    private String accNumber;
    private Number balance;
    private String currency;
    private Long clientId;

    public Account (Long clientId) {
    }

    public void changeBalance(String operation, Number sum) {
    }

    public Number getBalance(){
        return this.balance;
    }
}
