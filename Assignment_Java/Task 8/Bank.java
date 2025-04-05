package main;

import entity.CurrentAccount;
import entity.SavingsAccount;

import java.util.*;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        System.out.println("Welcome to Bank System");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Current Account");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter Account Number: ");
        int accno = sc.nextInt();

        sc.nextLine(); // Consume leftover newline
        System.out.print("Enter Customer Name: ");
        String custName = sc.nextLine();

        System.out.print("Enter your initial balance: ");
        float initbalance = sc.nextFloat();

        switch (choice) {
            case 1:
                account = new SavingsAccount(accno, custName, initbalance);
                System.out.println("Savings Account created successfully!");
                break;
            case 2:
                account = new CurrentAccount(accno, custName, initbalance);
                System.out.println("Current Account created successfully!");
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        System.out.println("\nAccount Details:");
        account.AccountInfo();

        // Perform banking operations
        while (true) {
            System.out.println("\nBanking Operations");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int userchoice = sc.nextInt();

            switch (userchoice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    float depo = sc.nextFloat();
                    account.deposit(depo);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    float widr = sc.nextFloat();
                    account.withdraw(widr);
                    break;

                case 3:
                    if (account instanceof SavingsAccount) {
                        account.calculateInterest();
                    } else {
                        System.out.println("Interest calculation is not applicable for Current Account.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Bank System!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
