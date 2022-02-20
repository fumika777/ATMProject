package com.github.ATMproject.Controller;

import com.github.ATMproject.entity.BalanceResponse;
import com.github.ATMproject.service.ATMService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ATMController {
    private ATMService ATMService;

    @GetMapping(value = "/login")
    public boolean loginSystem(@RequestParam(value = "cardNumber") String cardNumber,@RequestParam(value = "PIN") int PIN){
        return ATMService.checkPin(cardNumber, PIN);
    }

    @GetMapping(value = "/getBalance")
    public BalanceResponse getBalance(@RequestParam(value = "cardNumber") String cardNumber){
        return ATMService.getBalance(cardNumber);
    }
    @GetMapping(value = "/logout")
    public String logout(){
        return ATMService.logout();
    }
}
