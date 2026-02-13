package org.example.BasicATMDesign;

public abstract class Transaction {

    protected Account account;
    protected ATM atm;

    public Transaction(Account account, ATM atm) {
        this.account = account;
        this.atm = atm;
    }

    public final void execute() {
        validate();
        process();
        postProcess();
    }

    protected abstract void validate();
    protected abstract void process();

    protected void postProcess() {
        System.out.println("Transaction completed at " + atm);
    }
}
