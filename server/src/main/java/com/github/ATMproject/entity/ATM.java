package com.github.ATMproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ATM {
    private boolean authFlag;

    public ATM(){
        this.authFlag = false;
    }

    public boolean isAuthFlag(){
        boolean authResult;
        if (authFlag) {
            authResult = true;
        } else {
            authResult = false;
        }
        return authResult;
    }
}
