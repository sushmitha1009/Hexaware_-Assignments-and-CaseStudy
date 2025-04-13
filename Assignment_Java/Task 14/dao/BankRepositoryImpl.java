package dao;

import bean.Account;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRepositoryImpl implements IBankRepository {

    private Map<Long, Account> accountDatabase = new HashMap<>();

    @Override
    public void createAccount(long accountNumber, String accountType, double balance, double additionalInfo) {
        Account newAccount = switch (accountType.toLowerCase()) {
            case "savings" -> new bean.SavingsAccount(accountNumber, balance, null, additionalInfo);
            case "current" -> new bean.CurrentAccount(accountNumber, balance, null, additionalInfo);
            case "zero-balance" -> new bean.ZeroBalanceAccount(accountNumber, balance, null);
            default -> throw new IllegalArgumentException("Invalid account type");
        };
        accountDatabase.put(accountNumber, newAccount);
        System.out.println("Account created successfully with Account Number: " + accountNumber);
    }

    @Override
    public void deposit(long accountNumber, double amount) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposited " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Account not found for account number: " + accountNumber);
        }
    }

    @Override
    public void withdraw(long accountNumber, double amount) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("Withdrawn " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Account not found for account number: " + accountNumber);
        }
    }

    @Override
    public void transfer(long fromAccount, long toAccount, double amount) {
        Account fromAcc = getAccountByAccountNumber(fromAccount);
        Account toAcc = getAccountByAccountNumber(toAccount);

        if (fromAcc != null && toAcc != null) {
            if (fromAcc.getBalance() >= amount) {
                fromAcc.withdraw(amount);
                toAcc.deposit(amount);
                System.out.println("Transferred " + amount + " from account " + fromAccount + " to account " + toAccount);
            } else {
                System.out.println("Insufficient balance in account " + fromAccount);
            }
        } else {
            System.out.println("One or both accounts not found");
        }
    }

    @Override
    public double getAccountBalance(long accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        return account != null ? account.getBalance() : 0.0;
    }

    @Override
    public Account getAccountByAccountNumber(long accountNumber) {
        return accountDatabase.get(accountNumber);
    }

    @Override
    public Account getAccountDetails(long accountNumber) {
        Account account = accountDatabase.get(accountNumber);
        if (account != null) {
            System.out.println("Account Details: ");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Balance: " + account.getBalance());
            System.out.println("Account Type: " + account.getAccountType());
        } else {
            System.out.println("Account not found for account number: " + accountNumber);
        }
        return account;
    }

    @Override
    public List<Account> listAccounts() throws SQLException {
        // Returning all accounts as a list
        return new ArrayList<>(accountDatabase.values());
    }
}
