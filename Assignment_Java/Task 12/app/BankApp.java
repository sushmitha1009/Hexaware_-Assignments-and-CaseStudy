package app;

import bean.Account;
import bean.Customer;
import exception.InsufficientFundException;
import exception.InvalidAccountException;
import exception.OverDraftLimitExceededException;
import service.BankServiceProviderImpl;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankServiceProviderImpl bankService = new BankServiceProviderImpl();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n====== Bank Application Menu ======");
            System.out.println("1. Create Account");
            System.out.println("2. List Accounts");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Transfer Money");
            System.out.println("7. Get Account Details");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1: // Create Account
                        System.out.print("Enter customer name: ");
                        String name = scanner.next();
                        System.out.print("Enter customer contact: ");
                        String contact = scanner.next();
                        Customer customer = new Customer(0, name, contact);

                        System.out.print("Enter account type (Savings/Current/ZeroBalance): ");
                        String accType = scanner.next();
                        System.out.print("Enter initial balance: ");
                        float balance = scanner.nextFloat();

                        bankService.create_account(customer, accType, balance);
                        break;

                    case 2: // List Accounts
                        Account[] accounts = bankService.listAccounts();
                        if (accounts.length == 0) {
                            System.out.println("No accounts found.");
                        } else {
                            for (Account account : accounts) {
                                System.out.println(account); // Ensure Account's toString() is overridden for better output
                            }
                        }
                        break;

                    case 3: // Calculate Interest
                        bankService.calculateInterest();
                        break;

                    case 4: // Deposit Money
                        System.out.print("Enter account number: ");
                        long depositAccNo = scanner.nextLong();
                        System.out.print("Enter amount to deposit: ");
                        float depositAmount = scanner.nextFloat();
                        bankService.deposit(depositAccNo, depositAmount);
                        break;

                    case 5: // Withdraw Money
                        System.out.print("Enter account number: ");
                        long withdrawAccNo = scanner.nextLong();
                        System.out.print("Enter amount to withdraw: ");
                        float withdrawAmount = scanner.nextFloat();
                        bankService.withdraw(withdrawAccNo, withdrawAmount);
                        break;

                    case 6: // Transfer Money
                        System.out.print("Enter source account number: ");
                        long fromAccNo = scanner.nextLong();
                        System.out.print("Enter destination account number: ");
                        long toAccNo = scanner.nextLong();
                        System.out.print("Enter amount to transfer: ");
                        float transferAmount = scanner.nextFloat();
                        bankService.transfer(fromAccNo, toAccNo, transferAmount);
                        break;

                    case 7: // Get Account Details
                        System.out.print("Enter account number: ");
                        long accNo = scanner.nextLong();
                        bankService.getAccountDetails(accNo);
                        break;

                    case 8: // Exit
                        exit = true;
                        System.out.println("Exiting the application. Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InvalidAccountException e) {
                System.out.println("Error: Invalid account number provided.");
            } catch (InsufficientFundException e) {
                System.out.println("Error: Insufficient funds for the transaction.");
            } catch (OverDraftLimitExceededException e) {
                System.out.println("Error: Overdraft limit exceeded.");
            } catch (NullPointerException e) {
                System.out.println("Error: A null value was encountered. Please check the input or account information.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
