package service;

import bean.Account;

import java.util.HashMap;
import java.util.Map;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {
    private Map<Long, Account> accountMap = new HashMap<>();

    @Override
    public float get_account_balance(long accountNumber) {
        Account account = accountMap.get(accountNumber);
        if (account != null) {
            return account.getAccountBalance();
        }
        System.out.println("Account not found.");
        return -1;
    }

    @Override
    public boolean deposit(long accountNumber, float amount) {
        Account account = accountMap.get(accountNumber);
        if (account != null && amount > 0) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            System.out.println("Deposit successful. New balance: " + account.getAccountBalance());
            return true;
        }
        System.out.println(account == null ? "Account not found." : "Invalid deposit amount.");
        return false;
    }

    @Override
    public boolean withdraw(long accountNumber, float amount) {
        Account account = accountMap.get(accountNumber);
        if (account != null && amount > 0) {
            if (account.getAccountBalance() >= amount) {
                account.setAccountBalance(account.getAccountBalance() - amount);
                System.out.println("Withdrawal successful. Remaining balance: " + account.getAccountBalance());
                return true;
            }
            System.out.println("Insufficient balance.");
        } else {
            System.out.println(account == null ? "Account not found." : "Invalid withdrawal amount.");
        }
        return false;
    }

    @Override
    public boolean transfer(long fromAccountNumber, long toAccountNumber, float amount) {
        Account fromAccount = accountMap.get(fromAccountNumber);
        Account toAccount = accountMap.get(toAccountNumber);
        if (fromAccount != null && toAccount != null && amount > 0) {
            if (fromAccount.getAccountBalance() >= amount) {
                fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
                toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
                System.out.println("Transfer successful.");
                return true;
            }
            System.out.println("Insufficient balance in source account.");
        } else {
            System.out.println("Invalid account number(s) or transfer amount.");
        }
        return false;
    }

    @Override
    public String getAccountDetails(long accountNumber) {
        Account account = accountMap.get(accountNumber);
        return account != null ? account.toString() : "Account not found.";
    }
}
