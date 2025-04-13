package bean;

public class ZeroBalanceAccount extends Account {

    public ZeroBalanceAccount(long accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    @Override
    public String getAccountType() {
        return "ZeroBalance";
    }
}
