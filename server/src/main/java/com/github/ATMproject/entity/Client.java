package com.github.ATMproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CLIENTS")
@AllArgsConstructor
public class Client {
    @Id
    @Column(name = "CLIENT_ID")
    private long clientID;

    public Client() {
        this.clientID=System.currentTimeMillis();
    }

}