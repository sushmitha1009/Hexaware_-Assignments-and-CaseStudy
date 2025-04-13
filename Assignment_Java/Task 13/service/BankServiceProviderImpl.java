package service;

import bean.Account;
import bean.Customer;
import bean.CurrentAccount;
import bean.SavingsAccount;
import bean.ZeroBalanceAccount;

import java.util.ArrayList;
import java.util.List;

public class BankServiceProviderImpl implements IBankServiceProvider {
    private List<Account> accounts = new ArrayList<>();

    @Override
    public void create_account(Customer customer, String accountType, float initialDeposit) {
        Account account = null;

        if ("Savings".equalsIgnoreCase(accountType)) {
            account = new SavingsAccount(Account.generateAccountNumber(), initialDeposit, customer, 4.5f);
        } else if ("Current".equalsIgnoreCase(accountType)) {
            account = new CurrentAccount(Account.generateAccountNumber(), initialDeposit, customer, 1000f);
        } else if ("Zero Balance".equalsIgnoreCase(accountType)) {
            account = new ZeroBalanceAccount(Account.generateAccountNumber(), customer);
        }

        if (account != null) {
            accounts.add(account);
            System.out.println("Account created successfully: " + account);
        } else {
            System.out.println("Invalid account type.");
        }
    }

    @Override
    public Account[] listAccounts() {
        return accounts.toArray(new Account[0]);
    }

    @Override
    public void calculateInterest() {
        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                float interest = savingsAccount.getAccountBalance() * savingsAccount.getInterestRate() / 100;
                System.out.println("Interest for account " + savingsAccount.getAccountNumber() + ": " + interest);
            }
        }
    }

    @Override
    public float get_account_balance(long accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        if (account != null) {
            return account.getAccountBalance();
        }
        System.out.println("Account not found for account number: " + accountNumber);
        return -1;
    }

    @Override
    public boolean deposit(long accountNumber, float amount) {
        Account account = getAccountByNumber(accountNumber);
        if (account != null && amount > 0) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            System.out.println("Deposited " + amount + " to account " + account.getAccountNumber());
            return true;
        }
        System.out.println(account == null ? "Account not found." : "Invalid deposit amount.");
        return false;
    }

    @Override
    public boolean withdraw(long accountNumber, float amount) {
        Account account = getAccountByNumber(accountNumber);
        if (account != null && amount > 0 && account.getAccountBalance() >= amount) {
            account.setAccountBalance(account.getAccountBalance() - amount);
            System.out.println("Withdrawn " + amount + " from account " + account.getAccountNumber());
            return true;
        }
        System.out.println(account == null ? "Account not found." : "Insufficient funds.");
        return false;
    }

    @Override
    public boolean transfer(long fromAccountNumber, long toAccountNumber, float amount) {
        Account fromAccount = getAccountByNumber(fromAccountNumber);
        Account toAccount = getAccountByNumber(toAccountNumber);
        if (fromAccount != null && toAccount != null && amount > 0 && fromAccount.getAccountBalance() >= amount) {
            fromAccount.setAccountBalance(fromAccount.getAccountBalance() - amount);
            toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
            System.out.println("Transferred " + amount + " from account " + fromAccount.getAccountNumber() +
                    " to account " + toAccount.getAccountNumber());
            return true;
        }
        System.out.println(fromAccount == null || toAccount == null ? "Invalid account number(s)." : "Insufficient funds.");
        return false;
    }

    @Override
    public String getAccountDetails(long accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        return account != null ? account.toString() : "Account not found.";
    }

    private Account getAccountByNumber(long accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
