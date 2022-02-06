package com.github.ATMproject;
import java.util.Hashtable;
import java.util.Map;


public class CardRepository {
    private static final Map<String,Card> cardRepository = new Hashtable<>();

    public Card getCard(String cardNumber){
        return this.cardRepository.get(cardNumber);
    }

    public Card addCard(String cardNumber, String accNumber, int PIN){
        cardRepository.put(cardNumber, new Card(cardNumber, accNumber, PIN));
        return this.cardRepository.get(cardNumber);
    }
}
