package app;

import java.util.Scanner;
import service.BankServiceProviderImpl;
import bean.Account;
import bean.Customer;
import bean.SavingsAccount;
import bean.CurrentAccount;
import bean.ZeroBalanceAccount;

public class BankApp {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create an instance of BankServiceProviderImpl
        BankServiceProviderImpl bankServiceProvider = new BankServiceProviderImpl();

        // User Interface
        while (true) {
            System.out.println("\n=== Welcome to the Bank App ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");

            System.out.print("Please choose an option (1-6): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Create Account
                    createAccount(scanner, bankServiceProvider);
                    break;

                case 2: // Deposit
                    System.out.print("Enter Account Number: ");
                    long depositAccountNumber = scanner.nextLong();
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        bankServiceProvider.deposit(depositAccountNumber, depositAmount);
                        System.out.println("Amount Deposited Successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3: // Withdraw
                    System.out.print("Enter Account Number: ");
                    long withdrawAccountNumber = scanner.nextLong();
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        bankServiceProvider.withdraw(withdrawAccountNumber, withdrawAmount);
                        System.out.println("Amount Withdrawn Successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4: // Transfer
                    System.out.print("Enter From Account Number: ");
                    long fromAccount = scanner.nextLong();
                    System.out.print("Enter To Account Number: ");
                    long toAccount = scanner.nextLong();
                    System.out.print("Enter Transfer Amount: ");
                    double transferAmount = scanner.nextDouble();
                    try {
                        bankServiceProvider.transfer(fromAccount, toAccount, transferAmount);
                        System.out.println("Transfer Successful!");
                    } catch (Exception e) {
                        System.out.println("Transfer Failed: " + e.getMessage());
                    }
                    break;

                case 5: // Check Balance
                    System.out.print("Enter Account Number: ");
                    long balanceAccountNumber = scanner.nextLong();
                    try {
                        double balance = bankServiceProvider.getAccountBalance(balanceAccountNumber);
                        System.out.println("Account Balance: " + balance);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6: // Exit
                    System.out.println("Thank you for using the Bank App!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Option! Please choose a valid option (1-6).");
                    break;
            }
        }
    }

    private static void createAccount(Scanner scanner, BankServiceProviderImpl bankServiceProvider) {
        // Collect customer details first
        System.out.print("Enter Customer ID: ");
        long customerId = scanner.nextLong();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.next();
        System.out.print("Enter Customer Contact Number: ");
        String contactNumber = scanner.next();

        // Create a customer instance
        Customer customer = new Customer(customerId, customerName, contactNumber);

        // Ask for account type and handle based on type
        System.out.print("Enter Account Type (Savings/Current/ZeroBalance): ");
        String accountType = scanner.next();

        // Generate account number
        long accountNumber = generateAccountNumber(); // Generate account number after gathering details
        System.out.println("Generated Account Number: " + accountNumber);

        // Ask for the balance to initialize the account
        System.out.print("Enter Account Balance: ");
        double balance = scanner.nextDouble();

        // Based on account type, create the corresponding account
        switch (accountType.toLowerCase()) {
            case "savings":
                System.out.print("Enter Interest Rate for Savings Account: ");
                double interestRate = scanner.nextDouble();
                SavingsAccount savingsAccount = new SavingsAccount(accountNumber, balance, customer, interestRate);
                bankServiceProvider.createAccount(savingsAccount);
                System.out.println("Savings Account Created Successfully!");
                break;

            case "current":
                System.out.print("Enter Overdraft Limit for Current Account: ");
                double overdraftLimit = scanner.nextDouble();
                CurrentAccount currentAccount = new CurrentAccount(accountNumber, balance, customer, overdraftLimit);
                bankServiceProvider.createAccount(currentAccount);
                System.out.println("Current Account Created Successfully!");
                break;

            case "zerobalance":
                ZeroBalanceAccount zeroBalanceAccount = new ZeroBalanceAccount(accountNumber, balance, customer);
                bankServiceProvider.createAccount(zeroBalanceAccount);
                System.out.println("Zero Balance Account Created Successfully!");
                break;

            default:
                System.out.println("Invalid Account Type! Please choose a valid type.");
                break;
        }
    }

    // Method to generate a unique account number (this is just an example; adjust accordingly)
    private static long generateAccountNumber() {
        // Implement your logic for generating a unique account number (e.g., random or sequential)
        return (long) (Math.random() * 1000000); // Example, generates a random number
    }
}
