package com.github.ATMproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ATMController {
    ATM ATMEmulator = new ATM();

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @RequestMapping(value = "/login")
    public boolean loginSystem(@RequestParam(value = "cardNumber") String cardNumber,@RequestParam(value = "PIN") int PIN){
        return ATMEmulator.checkPin(cardNumber, PIN);
    }
}
