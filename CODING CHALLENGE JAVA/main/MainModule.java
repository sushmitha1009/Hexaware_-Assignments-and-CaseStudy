package main;

import entity.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Loan> loans = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Loan Management System ---");
            System.out.println("1. Add Car Loan");
            System.out.println("2. Add Home Loan");
            System.out.println("3. Display Loans");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("--- Add Car Loan ---");

                    System.out.print("Enter Loan ID: ");
                    int carLoanId = scanner.nextInt();
                    scanner.nextLine();

                    Customer carCustomer = getCustomerDetails(scanner);

                    System.out.print("Enter Principal Amount: ");
                    double carPrincipalAmount = scanner.nextDouble();

                    System.out.print("Enter Interest Rate: ");
                    double carInterestRate = scanner.nextDouble();

                    System.out.print("Enter Loan Term (months): ");
                    int carLoanTerm = scanner.nextInt();

                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Car Model: ");
                    String carModel = scanner.nextLine();

                    System.out.print("Enter Car Value: ");
                    int carValue = scanner.nextInt();

                    loans.add(new CarLoan(carLoanId, carCustomer, carPrincipalAmount, carInterestRate, carLoanTerm, "Pending", carModel, carValue));
                    System.out.println("Car Loan added successfully!");
                    break;

                case 2:
                    System.out.println("--- Add Home Loan ---");

                    System.out.print("Enter Loan ID: ");
                    int homeLoanId = scanner.nextInt();
                    scanner.nextLine();

                    Customer homeCustomer = getCustomerDetails(scanner);

                    System.out.print("Enter Principal Amount: ");
                    double homePrincipalAmount = scanner.nextDouble();

                    System.out.print("Enter Interest Rate: ");
                    double homeInterestRate = scanner.nextDouble();

                    System.out.print("Enter Loan Term (months): ");
                    int homeLoanTerm = scanner.nextInt();

                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Property Address: ");
                    String propertyAddress = scanner.nextLine();

                    System.out.print("Enter Property Value: ");
                    int propertyValue = scanner.nextInt();

                    loans.add(new HomeLoan(homeLoanId, homeCustomer, homePrincipalAmount, homeInterestRate, homeLoanTerm, "Pending", propertyAddress, propertyValue));
                    System.out.println("Home Loan added successfully!");
                    break;

                case 3:
                    System.out.println("--- Display Loans ---");
                    if (loans.isEmpty()) {
                        System.out.println("No loans available.");
                    } else {
                        for (Loan loan : loans) {
                            System.out.println(loan);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Customer getCustomerDetails(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Credit Score: ");
        int creditScore = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return new Customer(customerId, name, email, phoneNumber, address, creditScore);
    }
}
