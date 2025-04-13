package service;

import bean.Account;
import java.sql.SQLException;

public interface ICustomerServiceProvider {
    double getAccountBalance(long accountNumber) throws SQLException;
    void deposit(long accountNumber, double amount) throws SQLException;
    void withdraw(long accountNumber, double amount) throws SQLException;
    void transfer(long fromAccount, long toAccount, double amount) throws SQLException;
    Account getAccountDetails(long accountNumber) throws SQLException;
}
