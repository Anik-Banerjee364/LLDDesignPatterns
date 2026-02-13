package org.example.BasicATMDesign;

public interface BankService {
    boolean validatePin(Card card, String pin);
    Account getAccount(Card card);
    void updateAccount(Account account);
}

/*
 In real system → calls bank backend API.
*/