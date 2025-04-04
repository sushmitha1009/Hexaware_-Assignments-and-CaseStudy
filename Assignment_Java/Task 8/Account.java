package Bank;
public class Account {
    private int accountNumber;
    private String accountType;
    protected float accountBalance;
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

    // deposit method
    // overloaded deposit methods
    public void deposit(float amount) {
        if (amount>0) {
            accountBalance += amount;
            System.out.println("Deposited (float): " + amount + ", New Balance: " + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void deposit(int amount){
        if (amount>0) {
            accountBalance += amount;
            System.out.println("Deposited (int): " + amount + ", New Balance: " + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void deposit(double amount){
        if (amount>0) {
            accountBalance += amount;
            System.out.println("Deposited (double): " + amount + ", New Balance: " + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // withdraw method
    //overloaded withdraw methods
    public boolean withdraw(float amount) {
        if (amount > 0 && accountBalance >= amount) {
            accountBalance -= amount;
            return true;
        }else{
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && accountBalance >= amount) {
            accountBalance -= amount;
            System.out.println("Withdrawn (int): " + amount + ", New Balance: " + accountBalance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && accountBalance >= amount) {
            accountBalance -= amount;
            System.out.println("Withdrawn (double): " + amount + ", New Balance: " + accountBalance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Calculate Interest (to be overridden by SavingsAccount)
    public void calculateInterest() {
        System.out.println("Interest calculation not avalilable for base account");
    }

    // Display Account Details
    public void displayAccountInfo() {
        System.out.println("            Account Details           ");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accountBalance);
    }
}
