package bean;

public class Account {
    private static long lastAccNo = 1000; // Static variable for account number generation
    private long accountNumber;          // Unique account number
    private String accountType;          // Type of account (e.g., Savings, Current)
    private float accountBalance;        // Account balance
    private Customer customer;           // Associated customer

    // Constructor
    public Account(long accountNumber, String accountType, float balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = balance;   // Corrected from 'balance' to 'accountBalance'
        this.customer = customer;        // Added 'customer' field and initialization
    }

    // Getters
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public Customer getCustomer() {
        return customer; // Added getter for customer
    }

    // Setters
    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer; // Added setter for customer
    }

    // Static method to generate unique account numbers
    public static long generateAccountNumber() {
        return ++lastAccNo;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                ", Account Type: " + accountType +
                ", Balance: " + accountBalance +
                ", Customer: [" + customer.toString() + "]";
    }

}
