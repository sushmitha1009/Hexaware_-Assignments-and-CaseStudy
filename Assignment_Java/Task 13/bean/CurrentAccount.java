package bean;

public class CurrentAccount extends Account {
    private float overdraftLimit; // Additional attribute for overdraft.

    // Constructor
    public CurrentAccount(long accountNumber, float accountBalance, Customer customer, float overdraftLimit) {
        super(accountNumber, "Current", accountBalance, customer);
        this.overdraftLimit = overdraftLimit;
    }

    // Getters and Setters
    public float getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(float overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    // Method to withdraw money with overdraft
    public boolean withdraw(float amount) {
        if (amount <= getAccountBalance() + overdraftLimit) {
            float newBalance = getAccountBalance() - amount;
            setAccountBalance(newBalance); // Can go negative within overdraft limit
            System.out.println("Withdrawal successful. Remaining balance: " + getAccountBalance());
            return true;
        } else {
            System.out.println("Withdrawal amount exceeds overdraft limit.");
            return false;
        }
    }
}
