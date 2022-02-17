package com.github.ATMproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BalanceResponse {
    int amount;
    String currency;
    String message;

    public BalanceResponse(String message){
        this.message=message;
    }
}
