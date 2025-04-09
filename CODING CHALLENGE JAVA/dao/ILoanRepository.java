package dao;

import entity.Loan;
import java.util.List;

public interface ILoanRepository {
    void addLoan(Loan loan) throws Exception;
    Loan findLoanById(int loanId) throws Exception;
    void updateLoan(Loan loan) throws Exception;
    void deleteLoan(int loanId) throws Exception;
    List<Loan> listAllLoans() throws Exception;
}
