package com.github.ATMproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CARDS")
public class Card {
    @Id
    @Column(name="CARD")
    private String cardNumber;
    @Column(name="ACCOUNT")
    private String accountNumber;
    @Column(name="PIN")
    private int PIN;
}
