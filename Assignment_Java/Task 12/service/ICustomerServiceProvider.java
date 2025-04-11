package service;

import bean.Account;
import exception.OverDraftLimitExceededException;

public interface ICustomerServiceProvider {
    float get_account_balance(long accountNumber);
    boolean deposit(long accountNumber, float amount);
    boolean withdraw(long accountNumber, float amount) throws OverDraftLimitExceededException;
    boolean transfer(long fromAccountNumber, long toAccountNumber, float amount) throws OverDraftLimitExceededException;
    Account getAccountDetails(long accountNumber);
}
