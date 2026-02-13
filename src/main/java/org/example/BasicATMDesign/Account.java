package org.example.BasicATMDesign;

public class Account {

    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void debit(double amount)  {
        if (amount > balance) {
            throw new RuntimeException("Insufficient funds in account " + accountNumber);
        }
        balance -= amount;
        System.out.println("Debited " + amount + " from account " + accountNumber + ". New balance: " + balance);
    }

    public synchronized void credit(double amount) {
        balance += amount;
        System.out.println("Credited " + amount + " to account " + accountNumber + ". New balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
