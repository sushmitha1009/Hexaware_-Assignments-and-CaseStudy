package service;

import bean.Account;

public interface IBankServiceProvider {
    void createAccount(Account account); // Accepts an Account object
    void deposit(long accountNumber, double amount);
    void withdraw(long accountNumber, double amount);
    void transfer(long fromAccount, long toAccount, double amount);
    double getAccountBalance(long accountNumber);
}
