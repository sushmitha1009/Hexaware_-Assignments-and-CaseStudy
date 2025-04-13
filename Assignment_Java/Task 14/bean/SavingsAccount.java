package bean;

public class SavingsAccount extends Account {
    private double interestRate;

    // Constructor for SavingsAccount
    public SavingsAccount(long accountNumber, double balance, Customer customer, double interestRate) {
        super(accountNumber, balance, customer);
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }

    public double getInterestRate() {
        return interestRate;
    }
}
