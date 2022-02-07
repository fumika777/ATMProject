package com.github.ATMproject;

import lombok.Data;

@Data
public class ATM {
    private boolean authFlag;

    public ATM(){
        this.authFlag = false;
    }
}
