package entity;

public class SavingsAccount extends BankAccount {
    private static final float INTEREST_RATE=4.5f;
    public SavingsAccount(){
        super();
    }
    public SavingsAccount(int accountNumber, String customerName, float balance){
        super(accountNumber, customerName,balance);
    }
    public void deposit(float amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Amount deposited successfully!\nNew Balance is:"+balance);
        }
        else{
            System.out.println("Invalid deposit amount");
        }
    }
    public void withdraw(float amount){
        if(balance>=amount){
            balance-=amount;
            System.out.println("Amount withdrawn successfully\nNew Balance is: "+balance);
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
    //implementing calculate interest method
    @Override
    public void calculateInterest(){
        float interest=(balance*INTEREST_RATE)/100;
        balance+=interest;
        System.out.println("Interest added. Your account balance is Rs. "+balance);
    }
}
