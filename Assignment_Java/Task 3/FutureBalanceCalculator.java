import java.util.Scanner;

public class FutureBalanceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of customers: ");
        int numberOfCustomers = scanner.nextInt();
        for (int i = 1; i <= numberOfCustomers; i++) {
            System.out.println("\nCustomer " + i + ":");
            System.out.print("Enter the initial balance: ");
            double initialBalance = scanner.nextDouble();
            System.out.print("Enter the annual interest rate (in %): ");
            double annualInterestRate = scanner.nextDouble();
            System.out.print("Enter the number of years: ");
            int years = scanner.nextInt();
            //future balance
            double futureBalance = initialBalance * Math.pow((1 + annualInterestRate / 100), years);
            System.out.printf("Future balance for Customer %d: %.2f%n", i, futureBalance);
        }
        scanner.close();
    }
}
