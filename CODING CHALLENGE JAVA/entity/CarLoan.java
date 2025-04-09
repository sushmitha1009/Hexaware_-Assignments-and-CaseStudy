package entity;

import java.time.LocalDate;

public class CarLoan extends Loan {
    private String carModel;
    private int carValue;

    // Constructor
    public CarLoan(int loanId, int customerId, double principalAmount, double interestRate, int loanTerm, LocalDate loanStartDate,
                   String loanType, String loanStatus, String carModel, int carValue) {
        super(loanId, customerId, principalAmount, interestRate, loanTerm, loanStartDate, loanType, loanStatus);
        this.carModel = carModel;
        this.carValue = carValue;
    }

    // Getters and Setters
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarValue() {
        return carValue;
    }

    public void setCarValue(int carValue) {
        this.carValue = carValue;
    }

    // toString Method
    @Override
    public String toString() {
        return "CarLoan{" +
                "carModel='" + carModel + '\'' +
                ", carValue=" + carValue +
                ", " + super.toString() +
                '}';
    }
}
