package service;

import bean.Account;
import java.util.HashMap;
import java.util.Map;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {

    // Declare Map with proper generics
    private Map<Long, Account> accountMap = new HashMap<>();

    @Override
    public float get_account_balance(long account_number) {
        Account account = accountMap.get(Long.valueOf(account_number)); // Explicit boxing
        if (account != null) {
            return account.getAccountBalance();
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }

    @Override
    public boolean deposit(long account_number, float amount) {
        Account account = accountMap.get(Long.valueOf(account_number)); // Explicit boxing
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            System.out.println("Deposit successful. New balance: " + account.getAccountBalance());
            return true;
        } else {
            System.out.println("Account not found.");
            return false;
        }
    }


    @Override
    public boolean withdraw(long account_number, float amount) {
        Account account = accountMap.get(Long.valueOf(account_number)); // Explicit boxing
        if (account != null) {
            if (account.getAccountBalance() >= amount) {
                account.setAccountBalance(account.getAccountBalance() - amount);
                return true;
            } else {
                System.out.println("Insufficient balance.");
                return false;
            }
        } else {
            System.out.println("Account not found.");
            return false;
        }
    }

    @Override
    public boolean transfer(long from_account, long to_account, float amount) {
        Account fromAccount = accountMap.get(Long.valueOf(from_account)); // Explicit boxing
        Account toAccount = accountMap.get(Long.valueOf(to_account)); // Explicit boxing

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getAccountBalance() >= amount) {
                fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
                toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
                return true;
            } else {
                System.out.println("Insufficient balance in the source account.");
                return false;
            }
        } else {
            System.out.println("One or both accounts not found.");
            return false;
        }
    }

    @Override
    public Account getAccountDetails(long account_number) {
        Account account = accountMap.get(Long.valueOf(account_number)); // Explicit boxing
        if (account != null) {
            return account;
        } else {
            System.out.println("Account not found.");
            return null;
        }
    }
}
