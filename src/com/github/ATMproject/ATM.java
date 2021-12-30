package com.github.ATMproject;

public class ATM {
    private boolean authFlag;

    public ATM(){
    }

    public boolean checkPin(String cardNumber){
        return this.authFlag;
    }

    public void getBalance(String card){
        if (this.authFlag) {
        }
    }
}
