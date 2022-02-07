package com.github.ATMproject;

import lombok.Data;

@Data
public class Client {
    private long clientID;

    public Client() {
        this.clientID=System.currentTimeMillis();
    }

    public Client(long clientID){
        this.clientID=clientID;
    }
}