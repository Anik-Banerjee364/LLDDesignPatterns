package org.example.BasicATMDesign;

public class ATM {

    private ATMState state = ATMState.IDLE;
    private Card card;
    private Account account;

    private BankService bankService;
    private CashDispenser cashDispenser;

    private int pinAttemptsCounter = 0;

    public ATM(BankService bankService, CashDispenser cashDispenser) {
        this.bankService = bankService;
        this.cashDispenser = cashDispenser;
    }

    public void insertCard(Card card) {
        if (state != ATMState.IDLE) {
            System.out.println("ATM is not ready for a new card.");
            return;
        }
        if (card.isBlocked()) {
            System.out.println("Card is blocked. Please contact your bank.");
            return;
        }
        this.card = card;
        this.state = ATMState.CARD_INSERTED;
        System.out.println("Card inserted. Please enter your PIN.");
    }

    public void enterPin(String pin) {
        if (state != ATMState.CARD_INSERTED) {
            System.out.println("Please insert your card first.");
            return;
        }
        if (bankService.validatePin(card, pin)) {
            this.account = bankService.getAccount(card);
            this.state = ATMState.AUTHENTICATED;
            System.out.println("PIN validated. You can now perform transactions.");
        } else {
            pinAttemptsCounter++;
            System.out.println("Invalid PIN. Attempt " + pinAttemptsCounter);
            if (pinAttemptsCounter >= 3) {
                card.block();
                ejectCard();
                System.out.println("Card blocked due to multiple invalid attempts.");
            }
        }
    }

    public void withdraw(int amount) {
        if (state != ATMState.AUTHENTICATED) {
            System.out.println("Please authenticate first.");
            return;
        }
        state = ATMState.PROCESSING;
        Transaction transaction = new WithdrawTransaction(account, this, amount);
        transaction.execute();
        state = ATMState.AUTHENTICATED; // Return to authenticated state after processing
    }

    public void ejectCard() {
        if (state == ATMState.IDLE) {
            System.out.println("No card to eject.");
            return;
        }
        this.card = null;
        this.account = null;
        this.pinAttemptsCounter = 0;
        this.state = ATMState.IDLE;
        System.out.println("Card ejected. Thank you for using our ATM.");
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void printReceipt(String message) {
        System.out.println("Receipt: " + message);
    }
}
