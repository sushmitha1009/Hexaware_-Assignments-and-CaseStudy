package bean;

public class CurrentAccount extends Account {
    private float overdraftLimit; // Additional attribute for overdraft.

    // Constructor
    public CurrentAccount(float accountBalance, Customer customer, float overdraftLimit) {
        super("Current", accountBalance, customer);
        this.overdraftLimit = overdraftLimit;
    }

    // Getters and Setters
    public float getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(float overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(float amount) {
        if (amount <= getAccountBalance() + overdraftLimit) {
            float balance = getAccountBalance() - amount;
            setAccountBalance(balance < 0 ? 0 : balance);
            System.out.println("Withdrawal successful. Remaining balance: " + getAccountBalance());
            return true;
        } else {
            System.out.println("Withdrawal amount exceeds overdraft limit.");
            return false;
        }
    }
}
