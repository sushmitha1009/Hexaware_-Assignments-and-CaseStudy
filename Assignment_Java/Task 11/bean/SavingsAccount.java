package bean;

public class SavingsAccount extends Account {
    private float interestRate; // Additional attribute for SavingsAccount.

    // Constructor
    public SavingsAccount(float accountBalance, Customer customer, float interestRate) {
        super("Savings", Math.max(accountBalance, 500), customer); // Ensure minimum balance is 500.
        this.interestRate = interestRate;
    }

    // Getters and Setters
    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(float amount) {
        if (getAccountBalance() - amount >= 500) { // Ensure balance doesn't drop below 500.
            return super.withdraw(amount);
        } else {
            System.out.println("Insufficient balance. Minimum balance of 500 required.");
            return false;
        }
    }
}
