package com.github.ATMproject.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @Column(name = "CLIENT_ID")
    private long clientID;

    public Client() {
        this.clientID=System.currentTimeMillis();
    }

    public Client(long clientID){
        this.clientID=clientID;
    }
}