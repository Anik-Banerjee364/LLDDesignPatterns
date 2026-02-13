package org.example.BasicATMDesign;

public class Card {

    private final String cardNumber;
    private boolean blocked;

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
        this.blocked = false;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void block() {
        this.blocked = true;
    }
}
