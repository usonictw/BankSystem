package entity;

import java.util.Scanner;

public class Card {

    private CardType cardType;
    private long CardNumber;
    private short cvv;
    private long userId;
    private long balance;

    public Card() {
        this.CardNumber = 0;
        this.cvv = 0;
        this.balance = 0;
    }

    public void createCard(long userId) {
        this.CardNumber = (long) (Math.random() * 999999999);
        this.cvv = (short) (100 + (Math.random() * 900));
        this.userId = userId;
    }

    public void chooseCard(Scanner scanner) {
        System.out.println("Choose card type: ");
        CardType[] cardType = CardType.values();
        int i = 1;
        for (CardType c : cardType) {
            System.out.println(i + " " + c);
            i++;
        }
        System.out.println("Input index number of type Card");
        int index = scanner.nextInt();
        if (index >= 1 && index <= cardType.length){
        setCardType(cardType[index - 1]);
        }else {
            System.out.println("Choose type of card. Input index from 1 to " + cardType.length);
        }
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public long getCardNumber() {
        return CardNumber;
    }

    public short getCvv() {
        return cvv;
    }

    public long getUserId() {
        return userId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long amount) {
        this.balance = amount;
    }
}
