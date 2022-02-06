package com.github.ATMproject;

public class ATM {
    private boolean authFlag;
    private CardRepository cardRepository;
    private AccountRepository accountRepository;

    public ATM(){
        this.authFlag = false;
        this.cardRepository = new CardRepository();
        this.accountRepository = new AccountRepository();
    }

    public boolean checkPin(String cardNumber, int PIN) throws NullPointerException{
        try {
            this.authFlag=cardRepository.getCard(cardNumber).getPIN()==PIN;
        }
        catch (NullPointerException ignored) {
        }
        return this.authFlag;
    }

    public void getBalance(String card){
        if (this.authFlag) {
            String accNumber = this.cardRepository.getCard(card).getAccountNumber();
            accountRepository.getAccount(accNumber).getBalance();
        }
        else {
            System.out.println("PIN неправильный");
        }
    }
}
