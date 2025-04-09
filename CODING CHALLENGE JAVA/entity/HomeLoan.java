package entity;

import java.time.LocalDate;

public class HomeLoan extends Loan {
    private String propertyAddress;
    private int propertyValue;

    // Constructor
    public HomeLoan(int loanId, int customerId, double principalAmount, double interestRate, int loanTerm, LocalDate loanStartDate,
                    String loanType, String loanStatus, String propertyAddress, int propertyValue) {
        super(loanId, customerId, principalAmount, interestRate, loanTerm, loanStartDate, loanType, loanStatus);
        this.propertyAddress = propertyAddress;
        this.propertyValue = propertyValue;
    }

    // Getters and Setters
    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public int getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(int propertyValue) {
        this.propertyValue = propertyValue;
    }

    // toString Method
    @Override
    public String toString() {
        return "HomeLoan{" +
                "propertyAddress='" + propertyAddress + '\'' +
                ", propertyValue=" + propertyValue +
                ", " + super.toString() +
                '}';
    }
}
