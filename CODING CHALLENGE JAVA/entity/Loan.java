package entity;

import java.time.LocalDate;

public class Loan {
    private int loanId;
    private int customerId;
    private double principalAmount;
    private double interestRate;
    private int loanTerm;
    private LocalDate loanStartDate;
    private String loanType;
    private String loanStatus;

    // Constructor
    public Loan(int loanId, int customerId, double principalAmount, double interestRate, int loanTerm, LocalDate loanStartDate, String loanType, String loanStatus) {
        this.loanId = loanId;
        this.customerId = customerId;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
        this.loanStartDate = loanStartDate;
        this.loanType = loanType;
        this.loanStatus = loanStatus;
    }

    // Getters and Setters
    public int getLoanId() { return loanId; }
    public void setLoanId(int loanId) { this.loanId = loanId; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public double getPrincipalAmount() { return principalAmount; }
    public void setPrincipalAmount(double principalAmount) { this.principalAmount = principalAmount; }
    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public int getLoanTerm() { return loanTerm; }
    public void setLoanTerm(int loanTerm) { this.loanTerm = loanTerm; }
    public LocalDate getLoanStartDate() { return loanStartDate; }
    public void setLoanStartDate(LocalDate loanStartDate) { this.loanStartDate = loanStartDate; }
    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }
    public String getLoanStatus() { return loanStatus; }
    public void setLoanStatus(String loanStatus) { this.loanStatus = loanStatus; }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", customerId=" + customerId +
                ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate +
                ", loanTerm=" + loanTerm +
                ", loanStartDate=" + loanStartDate +
                ", loanType='" + loanType + '\'' +
                ", loanStatus='" + loanStatus + '\'' +
                '}';
    }
}
