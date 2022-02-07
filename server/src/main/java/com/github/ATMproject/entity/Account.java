package com.github.ATMproject.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    private String accountNumber;
    @Column(name = "BALANCE")
    private int balance;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "CLIENT_ID")
    private long clientID;

    public Account() {
    }

    public void getBalance(){
        System.out.println(this.balance + " " + this.currency);
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }
}
