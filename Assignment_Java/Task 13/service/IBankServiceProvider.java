package service;

import bean.Account;
import bean.Customer;

public interface IBankServiceProvider extends ICustomerServiceProvider {
    void create_account(Customer customer, String accountType, float initialDeposit);

    Account[] listAccounts();

    void calculateInterest();
}
