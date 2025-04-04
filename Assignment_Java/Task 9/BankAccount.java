package Bank;

public abstract class BankAccount {
    protected int accountNumber;
    protected String customerName;
    protected float balance;
    //default constructor
    public BankAccount(){
        this.accountNumber=0;
        this.customerName="null";
        this.balance=0.0f;
    }
    //parametrized constructor
    public BankAccount(int AccountNumber, String CustomerName, float Balance){
        this.accountNumber=AccountNumber;
        this.customerName=CustomerName;
        this.balance=Balance;
    }
    //getters and setters
    public int getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(int AccountNumber){
        this.accountNumber=AccountNumber;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String CustomerName){
        this.customerName=CustomerName;
    }
    public float getBalance(){
        return balance;
    }
    public void setBalance(float Balance){
        this.balance=Balance;
    }
    //print account information
    public void AccountInfo(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Customer Name: "+customerName);
        System.out.println("Balance: "+balance);
    }
    //abstract methods
    public abstract void deposit(float amount);
    public abstract void withdraw(float amount);
    public abstract void calculateInterest();

}


