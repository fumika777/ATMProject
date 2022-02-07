package com.github.ATMproject.service;

import com.github.ATMproject.ATM;
import com.github.ATMproject.repository.AccountRepository;
import com.github.ATMproject.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ATMService {
    private AccountRepository accountRepository;
    private CardRepository cardRepository;
    private static ATM ATM = new ATM();
    private static boolean authResult;

    public boolean checkPin(String cardNumber, int PIN) throws NullPointerException{
        try {
            ATM.setAuthFlag(cardRepository.findByCardNumber(cardNumber).getPIN()==PIN);
        }
        catch (NullPointerException ignored) {
        }
        if (ATM.isAuthFlag()==true) {
            authResult = true;
        } else {
            authResult = false;
        }
        return authResult;
    }

    public void getBalance(String cardNumber, int PIN){
        if (checkPin(cardNumber, PIN)) {
            String accountNumber = cardRepository.findByCardNumber(cardNumber).getAccountNumber();
            accountRepository.findByAccountNumber(accountNumber).getBalance();
        }
        else {
            System.out.println("PIN неправильный");
        }
    }
}
