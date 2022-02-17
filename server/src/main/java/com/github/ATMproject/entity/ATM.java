package com.github.ATMproject.entity;

import lombok.Data;

@Data
public class ATM {
    private boolean authFlag;

    public ATM(){
        this.authFlag = false;
    }
}
