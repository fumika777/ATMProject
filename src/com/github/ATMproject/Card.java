package com.github.ATMproject;

public class Card {
    private String cardNumber;
    private String accNumber;
    private Integer pinCode;

    public Card(String accNumber){
        this.accNumber=accNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public Integer getPinCode() {
        return pinCode;
    }
}
