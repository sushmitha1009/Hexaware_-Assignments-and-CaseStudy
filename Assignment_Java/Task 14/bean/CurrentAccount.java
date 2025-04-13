package bean;

public class CurrentAccount extends Account {
    private double overdraftLimit;

    // Constructor for CurrentAccount
    public CurrentAccount(long accountNumber, double balance, Customer customer, double overdraftLimit) {
        super(accountNumber, balance, customer);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "Current";
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
