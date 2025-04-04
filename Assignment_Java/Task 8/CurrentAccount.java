package Bank;

public class CurrentAccount extends Account{
    private static final double OVERDRAFT_LIMIT=5000.00;
    public CurrentAccount() {
        super();
    }
    public CurrentAccount(int accountNumber, String accountType, float accountBalance){
        super(accountNumber, "Current", accountBalance);
    }

    @Override
    public boolean withdraw(float amount){
        if(amount>0 && getAccountBalance()-amount>=OVERDRAFT_LIMIT){
            setAccountBalance(getAccountBalance()-amount);
            return true;
        }
        else{
            System.out.println("Exceeded overdraft limit or invalid amount");
            return false;
        }
    }

    @Override
    public void calculateInterest(){
        System.out.println("No interest for current account");
    }


}
