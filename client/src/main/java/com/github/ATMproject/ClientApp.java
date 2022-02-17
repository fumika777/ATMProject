package com.github.ATMproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class ClientApp
{
    public static void main(String[] args) {SpringApplication.run(ClientApp.class, args);
    }
}
