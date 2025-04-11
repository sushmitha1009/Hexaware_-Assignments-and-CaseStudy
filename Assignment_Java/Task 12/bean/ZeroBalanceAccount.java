package bean;

public class ZeroBalanceAccount extends Account {
    // Constructor
    public ZeroBalanceAccount(long accountNumber, Customer customer) {
        super(accountNumber, "Zero Balance", 0, customer); // Zero balance account starts with zero balance.
    }

    // Custom withdrawal method for ZeroBalanceAccount
    public boolean withdraw(float amount) {
        if (amount <= getAccountBalance()) {
            setAccountBalance(getAccountBalance() - amount);
            System.out.println("Withdrawal successful. Remaining balance: " + getAccountBalance());
            return true;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            return false;
        }
    }
}
