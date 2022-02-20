package com.github.ATMproject.service;

import com.github.ATMproject.entity.ATM;
import com.github.ATMproject.entity.Account;
import com.github.ATMproject.entity.BalanceResponse;
import com.github.ATMproject.entity.Card;
import com.github.ATMproject.repository.AccountRepository;
import com.github.ATMproject.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ATMService {
    private AccountRepository accountRepository;
    private CardRepository cardRepository;
    private ATM ATM;

    @Autowired
    public ATMService(AccountRepository accountRepository, CardRepository cardRepository){
        this.cardRepository=cardRepository;
        this.accountRepository=accountRepository;
        this.ATM=new ATM();
    }

    public boolean checkPin(String cardNumber, int PIN) throws NullPointerException{
        try {
            ATM.setAuthFlag(cardRepository.findByCardNumber(cardNumber).getPIN()==PIN);
        }
        catch (NullPointerException ignored) {
        }
        return ATM.isAuthFlag();
    }

    public BalanceResponse getBalance(String cardNumber){
        if (ATM.isAuthFlag()) {
            Card card = cardRepository.findByCardNumber(cardNumber);
            if (card!= null) {
                String accountNumber = card.getAccountNumber();
                Account account = accountRepository.findByAccountNumber(accountNumber);
                return new BalanceResponse(account.getBalance(), account.getCurrency(), "PIN введен верно");
            }
            else return new BalanceResponse("Карты с таким номером не сушествует");
        }
        else {
            return new BalanceResponse("PIN введен неверно");
        }
    }

    public String logout(){
        ATM.setAuthFlag(false);
        if (!ATM.isAuthFlag()){
            return "Выход из системы выполнен успешно";
        }
        else {
            return "Выход из системы не выполнен";
        }
    }
}
