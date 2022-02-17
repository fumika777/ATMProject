package com.github.ATMproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
@Data
public class Account {
    @Id
    @Column(name = "ACCOUNT")
    private String accountNumber;
    @Column(name = "BALANCE")
    private int balance;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "CLIENT_ID")
    private long clientID;
}
