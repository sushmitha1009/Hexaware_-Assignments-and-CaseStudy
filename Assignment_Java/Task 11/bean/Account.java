package bean;

public class Account {
    private static long lastAccNo = 1000; // Static variable for auto-generating account numbers.
    private long accountNumber;          // Unique account identifier.
    private String accountType;          // Type of account (e.g., Savings, Current).
    private float accountBalance;        // Account balance.
    private Customer customer;           // Customer associated with this account.

    // Constructor
    public Account(String accountType, float accountBalance, Customer customer) {
        this.accountNumber = ++lastAccNo; // Auto-generate account number.
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customer = customer;
    }

    // Getters and Setters
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Deposit Method
    public void deposit(float amount) {
        if (amount > 0) {
            this.accountBalance += amount;
            System.out.println("Amount deposited successfully! New Balance: " + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public boolean withdraw(float amount) {
        if (amount > 0 && amount <= accountBalance) {
            this.accountBalance -= amount;
            System.out.println("Amount withdrawn successfully! Remaining Balance: " + accountBalance);
            return true;
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
            return false;
        }
    }

    // Print Account Details
    public void printAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accountBalance);
        System.out.println("Customer Details: " + customer.toString());
    }
}
