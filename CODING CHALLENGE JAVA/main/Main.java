package main;

import dao.ILoanRepository;
import dao.ILoanRepositoryImpl;
import entity.CarLoan;
import entity.HomeLoan;
import entity.Loan;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ILoanRepository loanRepository = new ILoanRepositoryImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;

        try {
            do {
                System.out.println("\n=== Loan Management System ===");
                System.out.println("1. Add Loan");
                System.out.println("2. Add Home Loan");
                System.out.println("3. Add Car Loan");
                System.out.println("4. Find Loan by ID");
                System.out.println("5. Update Loan");
                System.out.println("6. Delete Loan");
                System.out.println("7. List All Loans");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Add General Loan
                        System.out.print("Enter Loan ID: ");
                        int loanId = scanner.nextInt();
                        System.out.print("Enter Customer ID: ");
                        int customerId = scanner.nextInt();
                        System.out.print("Enter Principal Amount: ");
                        double principalAmount = scanner.nextDouble();
                        System.out.print("Enter Interest Rate: ");
                        double interestRate = scanner.nextDouble();
                        System.out.print("Enter Loan Term (in months): ");
                        int loanTerm = scanner.nextInt();
                        System.out.print("Enter Loan Start Date (YYYY-MM-DD): ");
                        LocalDate loanStartDate = LocalDate.parse(scanner.next());
                        System.out.print("Enter Loan Type: ");
                        String loanType = scanner.next();
                        System.out.print("Enter Loan Status: ");
                        String loanStatus = scanner.next();

                        Loan loan = new Loan(loanId, customerId, principalAmount, interestRate, loanTerm, loanStartDate, loanType, loanStatus);
                        loanRepository.addLoan(loan);
                        System.out.println("Loan added successfully.");
                        break;

                    case 2:
                        // Add Home Loan
                        System.out.print("Enter Loan ID: ");
                        loanId = scanner.nextInt();
                        System.out.print("Enter Customer ID: ");
                        customerId = scanner.nextInt();
                        System.out.print("Enter Principal Amount: ");
                        principalAmount = scanner.nextDouble();
                        System.out.print("Enter Interest Rate: ");
                        interestRate = scanner.nextDouble();
                        System.out.print("Enter Loan Term (in months): ");
                        loanTerm = scanner.nextInt();
                        System.out.print("Enter Loan Start Date (YYYY-MM-DD): ");
                        loanStartDate = LocalDate.parse(scanner.next());
                        System.out.print("Enter Loan Status: ");
                        loanStatus = scanner.next();
                        System.out.print("Enter Property Address: ");
                        String propertyAddress = scanner.next();
                        System.out.print("Enter Property Value: ");
                        int propertyValue = scanner.nextInt();

                        HomeLoan homeLoan = new HomeLoan(loanId, customerId, principalAmount, interestRate, loanTerm, loanStartDate, "Home", loanStatus, propertyAddress, propertyValue);
                        loanRepository.addLoan(homeLoan);
                        System.out.println("Home Loan added successfully.");
                        break;

                    case 3:
                        // Add Car Loan
                        System.out.print("Enter Loan ID: ");
                        loanId = scanner.nextInt();
                        System.out.print("Enter Customer ID: ");
                        customerId = scanner.nextInt();
                        System.out.print("Enter Principal Amount: ");
                        principalAmount = scanner.nextDouble();
                        System.out.print("Enter Interest Rate: ");
                        interestRate = scanner.nextDouble();
                        System.out.print("Enter Loan Term (in months): ");
                        loanTerm = scanner.nextInt();
                        System.out.print("Enter Loan Start Date (YYYY-MM-DD): ");
                        loanStartDate = LocalDate.parse(scanner.next());
                        System.out.print("Enter Loan Status: ");
                        loanStatus = scanner.next();
                        System.out.print("Enter Car Model: ");
                        String carModel = scanner.next();
                        System.out.print("Enter Car Value: ");
                        int carValue = scanner.nextInt();

                        CarLoan carLoan = new CarLoan(loanId, customerId, principalAmount, interestRate, loanTerm, loanStartDate, "Car", loanStatus, carModel, carValue);
                        loanRepository.addLoan(carLoan);
                        System.out.println("Car Loan added successfully.");
                        break;

                    case 4:
                        // Find Loan by ID
                        System.out.print("Enter Loan ID to find: ");
                        loanId = scanner.nextInt();
                        Loan foundLoan = loanRepository.findLoanById(loanId);
                        if (foundLoan != null) {
                            System.out.println("Loan Found: " + foundLoan);
                        } else {
                            System.out.println("Loan not found.");
                        }
                        break;

                    case 5:
                        // Update Loan
                        System.out.print("Enter Loan ID to update: ");
                        loanId = scanner.nextInt();
                        Loan loanToUpdate = loanRepository.findLoanById(loanId);
                        if (loanToUpdate != null) {
                            System.out.print("Enter New Principal Amount: ");
                            loanToUpdate.setPrincipalAmount(scanner.nextDouble());
                            System.out.print("Enter New Interest Rate: ");
                            loanToUpdate.setInterestRate(scanner.nextDouble());
                            System.out.print("Enter New Loan Term (in months): ");
                            loanToUpdate.setLoanTerm(scanner.nextInt());
                            System.out.print("Enter New Loan Start Date (YYYY-MM-DD): ");
                            loanToUpdate.setLoanStartDate(LocalDate.parse(scanner.next()));
                            System.out.print("Enter New Loan Status: ");
                            loanToUpdate.setLoanStatus(scanner.next());

                            loanRepository.updateLoan(loanToUpdate);
                            System.out.println("Loan updated successfully.");
                        } else {
                            System.out.println("Loan not found.");
                        }
                        break;

                    case 6:
                        // Delete Loan
                        System.out.print("Enter Loan ID to delete: ");
                        loanId = scanner.nextInt();
                        loanRepository.deleteLoan(loanId);
                        System.out.println("Loan deleted successfully.");
                        break;

                    case 7:
                        // List All Loans
                        List<Loan> loans = loanRepository.listAllLoans();
                        if (!loans.isEmpty()) {
                            System.out.println("All Loans:");
                            for (Loan l : loans) {
                                System.out.println(l);
                            }
                        } else {
                            System.out.println("No loans found.");
                        }
                        break;

                    case 8:
                        // Exit
                        System.out.println("Exiting Loan Management System. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 8);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
