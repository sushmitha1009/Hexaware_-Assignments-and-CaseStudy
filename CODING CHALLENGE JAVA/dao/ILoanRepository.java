package dao;

import entity.model.Loan;

import java.util.List;

public interface ILoanRepository {
    void applyLoan(Loan loan);
    double calculateInterest(int loanId);
    double calculateInterest(double principalAmount, double interestRate, int loanTerm);
    void loanStatus(int loanId);
    double calculateEMI(int loanId);
    double calculateEMI(double principalAmount, double interestRate, int loanTerm);
    void loanRepayment(int loanId, double amount);
    List<Loan> getAllLoans();
    Loan getLoanById(int loanId);
}
