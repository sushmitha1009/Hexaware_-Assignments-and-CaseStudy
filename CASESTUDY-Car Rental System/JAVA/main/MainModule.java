package main;

import dao.ICarLeaseRepositoryImpl;
import dao.ICarLeaseRepository;
import entity.Vehicle;
import entity.customer;
import entity.lease;
import myexceptions.CarNotFoundException;
import myexceptions.CustomerNotFoundException;
import myexceptions.LeaseNotFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ICarLeaseRepository repo = new ICarLeaseRepositoryImpl();

        while (true) {
            System.out.println("\n===== Car Rental System =====");
            System.out.println("1. Add a Car");
            System.out.println("2. Remove a Car");
            System.out.println("3. List Available Cars");
            System.out.println("4. Find Car by ID");
            System.out.println("5. Add a Customer");
            System.out.println("6. Remove a Customer");
            System.out.println("7. Find Customer by ID");
            System.out.println("8. Create a Lease");
            System.out.println("9. Return a Car");
            System.out.println("10. View Active Leases");
            System.out.println("11. View Lease History");
            System.out.println("12. Make Payment");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter vehicle ID: ");
                        int vid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter make: ");
                        String make = sc.nextLine();
                        System.out.print("Enter model: ");
                        String model = sc.nextLine();
                        System.out.print("Enter year: ");
                        int year = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter status: ");
                        String status = sc.nextLine();
                        System.out.print("Enter daily rate: ");
                        double rate = sc.nextDouble();
                        System.out.print("Enter passenger capacity: ");
                        int cap = sc.nextInt();
                        System.out.print("Enter engine capacity: ");
                        double eng = sc.nextDouble();

                        Vehicle car = new Vehicle(vid, make, model, year, status, rate, cap, eng);
                        repo.addCar(car);
                        System.out.println("Car added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter vehicle ID to remove: ");
                        int removeId = sc.nextInt();
                        repo.removeCar(removeId);
                        System.out.println("Car removed successfully.");
                        break;

                    case 3:
                        List<Vehicle> availableCars = repo.listAvailableCars();
                        availableCars.forEach(System.out::println);
                        break;

                    case 4:
                        System.out.print("Enter car ID to find: ");
                        int findCarId = sc.nextInt();
                        Vehicle foundCar = repo.findCarById(findCarId);
                        System.out.println(foundCar);
                        break;

                    case 5:
                        System.out.print("Enter customer ID: ");
                        int cid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter first name: ");
                        String fname = sc.nextLine();
                        System.out.print("Enter last name: ");
                        String lname = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter phone number: ");
                        String phone = sc.nextLine();
                        System.out.print("Enter license number: ");
                        String license = sc.nextLine();

                        customer cust = new customer(cid, fname, lname, email, phone, license);
                        repo.addCustomer(cust);
                        System.out.println("Customer added successfully.");
                        break;

                    case 6:
                        System.out.print("Enter customer ID to remove: ");
                        int rcid = sc.nextInt();
                        repo.removeCustomer(rcid);
                        System.out.println("Customer removed successfully.");
                        break;

                    case 7:
                        System.out.print("Enter customer ID to find: ");
                        int fcid = sc.nextInt();
                        customer foundCust = repo.findCustomerById(fcid);
                        System.out.println(foundCust);
                        break;

                    case 8:
                        System.out.print("Enter customer ID: ");
                        int leaseCustId = sc.nextInt();
                        System.out.print("Enter car ID: ");
                        int leaseCarId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter start date (YYYY-MM-DD): ");
                        String sDate = sc.nextLine();
                        System.out.print("Enter end date (YYYY-MM-DD): ");
                        String eDate = sc.nextLine();
                        lease lease = repo.createLease(leaseCustId, leaseCarId, sDate, eDate);
                        System.out.println("Lease created: " + lease);
                        break;

                    case 9:
                        System.out.print("Enter lease ID to return car: ");
                        int lid = sc.nextInt();
                        lease returnedLease = repo.returnCar(lid);
                        System.out.println("Lease closed: " + returnedLease);
                        break;

                    case 10:
                        List<lease> activeLeases = repo.listActiveLeases();
                        activeLeases.forEach(System.out::println);
                        break;

                    case 11:
                        List<lease> leaseHistory = repo.listLeaseHistory();
                        leaseHistory.forEach(System.out::println);
                        break;

                    case 12:
                        System.out.print("Enter lease ID: ");
                        int payLeaseId = sc.nextInt();
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        lease payLease = new lease();
                        payLease.setLease_id(payLeaseId);
                        repo.recordPayment(payLease, amount);
                        System.out.println("Payment recorded.");
                        break;

                    case 13:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException | IOException | ClassNotFoundException | CarNotFoundException |
                     CustomerNotFoundException | LeaseNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}