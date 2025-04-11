package service;

import entity.Account;
import entity.Customer;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Long, Account> accounts = new HashMap<>();

    // Create a new account (no need to pass accNo)
    public void create_account(Customer customer, String accType, float balance) {
        Account account = new Account(accType, balance, customer);
        accounts.put(Long.valueOf(account.getAccountNumber()), account); // Explicit boxing
        System.out.println("Account created successfully! Account Number: " + account.getAccountNumber());
    }



    // Get account balance
    public float get_account_balance(long account_number) {
        Account account = accounts.get(Long.valueOf(account_number)); // Explicit boxing
        if (account != null) {
            return account.getAccountBalance();
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }

    // Deposit amount
    public float deposit(long account_number, float amount) {
        // Explicitly convert the long to Long
        Account account = accounts.get(Long.valueOf(account_number));
        if (account != null) {
            account.deposit(amount);
            return account.getAccountBalance();
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }


    // Withdraw amount
    public float withdraw(long account_number, float amount) {
        // Convert the long to Long explicitly
        Account account = accounts.get(Long.valueOf(account_number));
        if (account != null) {
            if (account.withdraw(amount)) {
                return account.getAccountBalance();
            } else {
                System.out.println("Withdrawal failed.");
                return -1;
            }
        } else {
            System.out.println("Account not found.");
            return -1;
        }
    }


    // Transfer money from one account to another
    public void transfer(long from_account_number, long to_account_number, float amount) {
        // Convert long to Long for compatibility with the map
        Account from = accounts.get(Long.valueOf(from_account_number));
        Account to = accounts.get(Long.valueOf(to_account_number));

        if (from != null && to != null) {
            if (from.withdraw(amount)) {
                to.deposit(amount);
                System.out.println("Transfer successful!");
            } else {
                System.out.println("Transfer failed due to insufficient balance.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }


    // Print account + customer details
    public void getAccountDetails(long account_number) {
        // Convert long to Long for compatibility with the map
        Account account = accounts.get(Long.valueOf(account_number));
        if (account != null) {
            account.printAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

