package com.github.ATMproject.service;

import com.github.ATMproject.entity.ATM;
import com.github.ATMproject.entity.Account;
import com.github.ATMproject.entity.BalanceResponse;
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

    public BalanceResponse getBalance(String cardNumber){
        if (ATM.isAuthFlag()) {
            System.out.println("PIN правильный");
            String accountNumber = cardRepository.findByCardNumber(cardNumber).getAccountNumber();
            Account account = accountRepository.findByAccountNumber(accountNumber);
            return new BalanceResponse(account.getBalance(),account.getCurrency(),"PIN введен верно");
        }
        else {
            System.out.println("PIN неправильный");
            return new BalanceResponse("PIN введен неверно");
        }
    }

    public String logout(){
        ATM.setAuthFlag(false);
        if (ATM.isAuthFlag()==false){
            return "Выход из системы выполнен успешно";
        }
        else {
            return "Выход из системы не выполнен";
        }
    }
}
