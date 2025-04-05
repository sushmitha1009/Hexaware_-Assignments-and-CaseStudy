package main;

import entity.Customer;
import service.Bank;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("----- Welcome to the Banking System -----");

        while (true) {
            System.out.println("\nAvailable commands:");
            System.out.println("1. create_account");
            System.out.println("2. deposit");
            System.out.println("3. withdraw");
            System.out.println("4. get_balance");
            System.out.println("5. transfer");
            System.out.println("6. getAccountDetails");
            System.out.println("7. exit");
            System.out.print("Enter your command: ");
            String command = scanner.nextLine().trim();

            switch (command.toLowerCase()) {
                case "create_account":
                    System.out.print("Enter Customer ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Customer Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Customer Address");
                    String address=scanner.nextLine();

                    Customer customer = new Customer(id, firstName, lastName, email, phone,address);
                    System.out.println("Choose account type:");
                    System.out.println("1. Savings");
                    System.out.println("2. Current");
                    System.out.print("Enter choice (1 or 2): ");
                    int typeChoice = Integer.parseInt(scanner.nextLine());
                    String accType = (typeChoice == 1) ? "Savings" : "Current";

                    System.out.print("Enter Initial Balance: ");
                    float balance = Float.parseFloat(scanner.nextLine());

                    bank.create_account(customer, accType, balance);
                    break;

                case "deposit":
                    System.out.print("Enter Account Number: ");
                    long depositAccNo = Long.parseLong(scanner.nextLine());
                    System.out.print("Enter Amount to Deposit: ");
                    float depositAmount = Float.parseFloat(scanner.nextLine());
                    float newBal = bank.deposit(depositAccNo, depositAmount);
                    if (newBal != -1)
                        System.out.println("Updated Balance: " + newBal);
                    break;

                case "withdraw":
                    System.out.print("Enter Account Number: ");
                    long withdrawAccNo = Long.parseLong(scanner.nextLine());
                    System.out.print("Enter Amount to Withdraw: ");
                    float withdrawAmount = Float.parseFloat(scanner.nextLine());
                    float remainingBal = bank.withdraw(withdrawAccNo, withdrawAmount);
                    if (remainingBal != -1)
                        System.out.println("Remaining Balance: " + remainingBal);
                    break;

                case "get_balance":
                    System.out.print("Enter Account Number: ");
                    long balanceAccNo = Long.parseLong(scanner.nextLine());
                    float bal = bank.get_account_balance(balanceAccNo);
                    if (bal != -1)
                        System.out.println("Account Balance: " + bal);
                    break;

                case "transfer":
                    System.out.print("Enter Sender Account Number: ");
                    long fromAcc = Long.parseLong(scanner.nextLine());
                    System.out.print("Enter Receiver Account Number: ");
                    long toAcc = Long.parseLong(scanner.nextLine());
                    System.out.print("Enter Amount to Transfer: ");
                    float transferAmt = Float.parseFloat(scanner.nextLine());
                    bank.transfer(fromAcc, toAcc, transferAmt);
                    break;

                case "getaccountdetails":
                    System.out.print("Enter Account Number: ");
                    long detailsAccNo = Long.parseLong(scanner.nextLine());
                    bank.getAccountDetails(detailsAccNo);
                    break;

                case "exit":
                    System.out.println("Exiting... Thank you for using the banking system!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}