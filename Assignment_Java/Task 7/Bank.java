package main;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Account Type (Savings/Current): ");
        String accType = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        float balance = scanner.nextFloat();
        Account account = new Account(accNo, accType, balance);
        while (true) {
            System.out.println("\nChoose Operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    float depositAmount = scanner.nextFloat();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    float withdrawAmount = scanner.nextFloat();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.calculateInterest();
                    break;
                case 4:
                    account.displayAccountInfo();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
