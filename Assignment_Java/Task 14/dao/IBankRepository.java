package dao;

import bean.Account;
import java.sql.SQLException;
import java.util.List;

public interface IBankRepository {
    void createAccount(long accountNumber, String accountType, double initialBalance, double extra) throws SQLException;
    void deposit(long accountNumber, double amount) throws SQLException;
    void withdraw(long accountNumber, double amount) throws SQLException;
    double getAccountBalance(long accountNumber) throws SQLException;
    Account getAccountByAccountNumber(long accountNumber) throws SQLException;
    List<Account> listAccounts() throws SQLException;
    void transfer(long fromAccount, long toAccount, double amount) throws SQLException;
    Account getAccountDetails(long accountNumber) throws SQLException;
}
