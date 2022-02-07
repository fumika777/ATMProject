package com.github.ATMproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@AllArgsConstructor
@Data
@Entity
@Table(name = "CARDS")
public class Card {
    @Id
    private String cardNumber;
    private String accountNumber;
    private int PIN;
    public Card(){
    }
}
