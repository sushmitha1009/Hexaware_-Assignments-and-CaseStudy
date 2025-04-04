package Bank;

public class SavingsAccount extends Account {
    private static final float INTEREST_RATE=4.5f;
    public SavingsAccount(){
        super();
    }
    public SavingsAccount(int accountNumber, float accountBalance){
        super(accountNumber, "Savings", accountBalance);
    }
    @Override
    public void calculateInterest(){
        float interest=(getAccountBalance()*INTEREST_RATE)/100;
        accountBalance+=interest;
        System.out.println("After adding interest, your account balance is Rs. "+accountBalance);
    }
}
