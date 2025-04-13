package service;

import bean.Account;
import dao.IBankRepository;
import dao.BankRepositoryImpl;
import java.sql.SQLException;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {
    private IBankRepository bankRepository;

    // Constructor
    public CustomerServiceProviderImpl() {
        this.bankRepository = new BankRepositoryImpl();  // Correct instantiation of BankRepositoryImpl
    }

    @Override
    public double getAccountBalance(long accountNumber) throws SQLException {
        return bankRepository.getAccountBalance(accountNumber);
    }

    @Override
    public void deposit(long accountNumber, double amount) throws SQLException {
        bankRepository.deposit(accountNumber, amount);
    }

    @Override
    public void withdraw(long accountNumber, double amount) throws SQLException {
        bankRepository.withdraw(accountNumber, amount);
    }

    @Override
    public void transfer(long fromAccount, long toAccount, double amount) throws SQLException {
        bankRepository.transfer(fromAccount, toAccount, amount);
    }

    @Override
    public Account getAccountDetails(long accountNumber) throws SQLException {
        return bankRepository.getAccountDetails(accountNumber);
    }
}
