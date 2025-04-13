package dao;

import entity.model.Loan;
import entity.model.CarLoan;
import entity.model.HomeLoan;
import entity.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class LoanRepositoryImpl implements ILoanRepository {
    private List<Loan> loanList = new ArrayList<>();

    @Override
    public void applyLoan(Loan loan) {
        loanList.add(loan);
    }

    @Override
    public double calculateInterest(int loanId) {
        Loan loan = getLoanById(loanId);
        return calculateInterest(loan.getPrincipalAmount(), loan.getInterestRate(), loan.getLoanTerm());
    }

    @Override
    public double calculateInterest(double principalAmount, double interestRate, int loanTerm) {
        return (principalAmount * interestRate * loanTerm) / 12;
    }

    @Override
    public void loanStatus(int loanId) {
        Loan loan = getLoanById(loanId);
        if (loan.getCustomer().getCreditScore() > 650) {
            loan.setLoanStatus("Approved");
        } else {
            loan.setLoanStatus("Rejected");
        }
    }

    @Override
    public double calculateEMI(int loanId) {
        Loan loan = getLoanById(loanId);
        return calculateEMI(loan.getPrincipalAmount(), loan.getInterestRate(), loan.getLoanTerm());
    }

    @Override
    public double calculateEMI(double principalAmount, double interestRate, int loanTerm) {
        double emi = (principalAmount * interestRate * Math.pow(1 + interestRate, loanTerm)) / (Math.pow(1 + interestRate, loanTerm) - 1);
        return emi;
    }

    @Override
    public void loanRepayment(int loanId, double amount) {
        Loan loan = getLoanById(loanId);
        loan.setPrincipalAmount(loan.getPrincipalAmount() - amount);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanList;
    }

    @Override
    public Loan getLoanById(int loanId) {
        return loanList.stream().filter(loan -> loan.getLoanId() == loanId).findFirst().orElse(null);
    }
}
