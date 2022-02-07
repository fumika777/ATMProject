package com.github.ATMproject;

import lombok.Data;

@Data
public class Balance {
    private int amount;
    private String currency;

    public Balance(){
        this.amount=0;
        this.currency="RUR";
    }

    public Balance(int amount, String currency){
        this.amount=amount;
        this.currency=currency;
    }

    public void getBalance(){
        System.out.println(this.amount + " " + this.currency);
    }

    public void changeBalance(Balance balance){
        this.amount=balance.getAmount();
        this.currency=balance.getCurrency();
    }
}
