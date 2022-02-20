package com.github.ATMproject.service;

import com.github.ATMproject.entity.ATM;
import com.github.ATMproject.entity.Account;
import com.github.ATMproject.entity.BalanceResponse;
import com.github.ATMproject.entity.Card;
import com.github.ATMproject.repository.AccountRepository;
import com.github.ATMproject.repository.CardRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;


public class ATMServiceTest {
    CardRepository cardRepository;
    AccountRepository accountRepository;
    ATMService atmService;
    ATM ATM;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);
        cardRepository = Mockito.mock(CardRepository.class);
        ATM = Mockito.mock(ATM.class);
        atmService = new ATMService(accountRepository, cardRepository);
    }

    @Test
    public void checkPIN(){
        Card card = new Card("4000001234567899","6178236817263813",1012);
        when(cardRepository.findByCardNumber("4000001234567899")).thenReturn(card);
        assertEquals(atmService.checkPin("4000001234567899",1012), true);
        assertNotEquals(atmService.checkPin("4000001234567899",221), true);
    }

    @Test
    public void getBalance(){
        atmService = new ATMService(accountRepository, cardRepository, new ATM(true));
        Card card = new Card("4000001234567899","6178236817263813",1012);
        Account account = new Account("6178236817263813",5000,"RUR",1l);
        BalanceResponse balanceResponse = new BalanceResponse(5000, "RUR", "PIN введен верно");

        when(cardRepository.findByCardNumber("4000001234567899")).thenReturn(card);
        when(accountRepository.findByAccountNumber("6178236817263813")).thenReturn(account);

        assertEquals(atmService.getBalance("4000001234567899"), balanceResponse);
    }

    @Test
    public void logout(){
        atmService = new ATMService(accountRepository, cardRepository, new ATM(true));
        assertEquals(atmService.logout(), "Выход из системы выполнен успешно");
    }

}
