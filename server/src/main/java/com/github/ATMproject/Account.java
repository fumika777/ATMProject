package com.github.ATMproject;

public class Account {
    private String accountNumber;
    private Balance balance;
    private long clientID;

    public Account(){
    }
    public Account (long clientId, String accNumber, Balance balance) {
        this.balance=balance;
        this.accountNumber=accNumber;
        this.clientID =clientId;
    }

    public Account (long clientId, String accNumber) {
        this.balance=new Balance();
        this.clientID =clientId;
        this.accountNumber=accNumber;
    }

    public Account (String accNumber) {
        this.balance=new Balance();
        this.clientID =System.currentTimeMillis();
        this.accountNumber=accNumber;
    }

    public void getBalance(){
        this.balance.getBalance();
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
}
