package org.example.BasicATMDesign;

public class WithdrawTransaction extends Transaction{

    private double amount;

    public WithdrawTransaction(Account account, ATM atm, double amount) {
        super(account, atm);
        this.amount = amount;
    }

    @Override
    protected void validate() {
        if(!atm.getCashDispenser().hasSufficientCash(amount)) {
            throw new RuntimeException("ATM " + atm + " does not have sufficient cash for withdrawal of " + amount);
        }
        if(account.getBalance() < amount) {
            throw new RuntimeException("Account " + account + " does not have sufficient balance for withdrawal of " + amount);
        }
    }

    @Override
    protected void process() {
        account.debit(amount);
        atm.getCashDispenser().dispense(amount);
    }
}
