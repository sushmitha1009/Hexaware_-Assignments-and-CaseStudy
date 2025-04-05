package entity;
public class Account {
    private static long nextAccountNumber = 1001;
    private long accountNumber;
    private String accountType;
    protected float accountBalance;
    private Customer customer;
    //private static final float INTEREST_RATE = 4.5f;

    // Default Constructor
    public Account() {
    }

    // Parameterized Constructor
    public Account(String accountType, float accountBalance,Customer customer) {
        this.accountNumber = nextAccountNumber++;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customer=customer;
    }

    // Getters and Setters
    public long getAccountNumber() {
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
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
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
    public void printAccountDetails() {
        System.out.println("            Account Details           ");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accountBalance);
        if(customer!=null){
            customer.printCustomerDetails();
        }
    }
}
