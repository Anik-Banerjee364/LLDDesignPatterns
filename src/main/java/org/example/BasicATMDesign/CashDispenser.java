package org.example.BasicATMDesign;

public class CashDispenser {

    private double availableCash;

    public CashDispenser(double initialCash) {
        this.availableCash = initialCash;
    }

    public boolean hasSufficientCash(double amount) {
        return availableCash >= amount;
    }

    public void dispense(double amount) {
        if(!hasSufficientCash(amount)) {
            throw new RuntimeException("Insufficient cash in dispenser for amount " + amount);
        }
        availableCash -= amount;
    }

}
