package Bank;

public class CurrentAccount extends BankAccount{
    private static final double OVERDRAFT_LIMIT=5000.00;
    public CurrentAccount() {
        super();
    }
    public CurrentAccount(int accountNumber, String customerName, float balance){
        super(accountNumber, customerName, balance);
    }
    @Override
    public void deposit(float amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Amount deposited successfully!\nNew Balance is:"+balance);
        }
        else{
            System.out.println("Invalid deposit amount");
        }
    }
    @Override
    public void withdraw(float amount){
        if(balance-amount >= -OVERDRAFT_LIMIT){
            balance-=amount;
            System.out.println("Amount withdrawn successfully\nNew Balance is: "+balance);
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
    @Override
    public void calculateInterest(){
        System.out.println("No interest for current account");
    }
}
