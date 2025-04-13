package service;

import bean.Account;
import java.util.ArrayList;
import java.util.List;

public class BankServiceProviderImpl implements IBankServiceProvider {
    private final List<Account> accountList = new ArrayList<>();

    @Override
    public void createAccount(Account account) {
        accountList.add(account); // Add the account object to the list
        System.out.println("Account created successfully: " + account.getAccountNumber());
    }

    @Override
    public void deposit(long accountNumber, double amount) {
        for (Account account : accountList) {
            if (account.getAccountNumber() == accountNumber) {
                account.setBalance(account.getBalance() + amount);
                return;
            }
        }
        throw new IllegalArgumentException("Account not found!");
    }

    @Override
    public void withdraw(long accountNumber, double amount) {
        for (Account account : accountList) {
            if (account.getAccountNumber() == accountNumber) {
                if (account.getBalance() >= amount) {
                    account.setBalance(account.getBalance() - amount);
                    return;
                } else {
                    throw new IllegalArgumentException("Insufficient balance!");
                }
            }
        }
        throw new IllegalArgumentException("Account not found!");
    }

    @Override
    public void transfer(long fromAccount, long toAccount, double amount) {
        Account from = null, to = null;

        for (Account account : accountList) {
            if (account.getAccountNumber() == fromAccount) {
                from = account;
            }
            if (account.getAccountNumber() == toAccount) {
                to = account;
            }
        }

        if (from == null || to == null) {
            throw new IllegalArgumentException("One or both accounts not found!");
        }

        if (from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
        } else {
            throw new IllegalArgumentException("Insufficient balance in source account!");
        }
    }

    @Override
    public double getAccountBalance(long accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber() == accountNumber) {
                return account.getBalance();
            }
        }
        throw new IllegalArgumentException("Account not found!");
    }
}
