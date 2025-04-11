package bean;

public class ZeroBalanceAccount extends Account {
    // Constructor
    public ZeroBalanceAccount(Customer customer) {
        super("Zero Balance", 0, customer); // ZeroBalanceAccount starts with zero balance.
    }

    @Override
    public boolean withdraw(float amount) {
        if (amount <= getAccountBalance()) {
            return super.withdraw(amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
            return false;
        }
    }
}
