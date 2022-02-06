package com.github.ATMproject;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Card {
    private String cardNumber;
    private String accountNumber;
    private int PIN;
}
