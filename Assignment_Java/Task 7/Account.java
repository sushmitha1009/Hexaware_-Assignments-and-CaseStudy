package Bank;
public class Account {
    private int accountNumber;
    private String accountType;
    private float accountBalance;
    private static final float INTEREST_RATE = 4.5f;

    // Default Constructor
    public Account() {
    }

    // Parameterized Constructor
    public Account(int accountNumber, String accountType, float accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    // Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
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

    // Deposit Method
    public void deposit(float amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(float amount) {
        if (amount > 0 && accountBalance >= amount) {
            accountBalance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + accountBalance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Calculate Interest (Only for Savings Account)
    public void calculateInterest() {
        if (accountType.equalsIgnoreCase("Savings")) {
            float interest = (accountBalance * INTEREST_RATE) / 100;
            accountBalance += interest;
            System.out.println("Interest Added: " + interest + ", New Balance: " + accountBalance);
        } else {
            System.out.println("Interest calculation is only for Savings Account.");
        }
    }

    // Display Account Details
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accountBalance);
    }
}
