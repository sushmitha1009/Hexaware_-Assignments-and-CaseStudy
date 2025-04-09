package dao;

import entity.Loan;
import util.DBConnUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ILoanRepositoryImpl implements ILoanRepository {

    @Override
    public void addLoan(Loan loan) throws Exception {
        String query = "INSERT INTO Loan (loanId, customerId, principalAmount, interestRate, loanTerm, loanType, loanStatus, loanStartDate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, loan.getLoanId());
            stmt.setInt(2, loan.getCustomerId());
            stmt.setDouble(3, loan.getPrincipalAmount());
            stmt.setDouble(4, loan.getInterestRate());
            stmt.setInt(5, loan.getLoanTerm());
            stmt.setString(6, loan.getLoanType());
            stmt.setString(7, loan.getLoanStatus());
            stmt.setDate(8, Date.valueOf(loan.getLoanStartDate())); // Convert LocalDate to SQL Date
            stmt.executeUpdate();
        }
    }

    @Override
    public Loan findLoanById(int loanId) throws Exception {
        String query = "SELECT * FROM Loan WHERE loanId = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, loanId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Loan(
                            rs.getInt("loanId"),
                            rs.getInt("customerId"),
                            rs.getDouble("principalAmount"),
                            rs.getDouble("interestRate"),
                            rs.getInt("loanTerm"),
                            rs.getDate("loanStartDate").toLocalDate(), // Convert SQL Date to LocalDate
                            rs.getString("loanType"),
                            rs.getString("loanStatus")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public void updateLoan(Loan loan) throws Exception {
        String query = "UPDATE Loan SET principalAmount = ?, interestRate = ?, loanTerm = ?, loanType = ?, loanStatus = ?, loanStartDate = ? " +
                "WHERE loanId = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, loan.getPrincipalAmount());
            stmt.setDouble(2, loan.getInterestRate());
            stmt.setInt(3, loan.getLoanTerm());
            stmt.setString(4, loan.getLoanType());
            stmt.setString(5, loan.getLoanStatus());
            stmt.setDate(6, Date.valueOf(loan.getLoanStartDate())); // Convert LocalDate to SQL Date
            stmt.setInt(7, loan.getLoanId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteLoan(int loanId) throws Exception {
        String query = "DELETE FROM Loan WHERE loanId = ?";
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, loanId);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Loan> listAllLoans() throws Exception {
        String query = "SELECT * FROM Loan";
        List<Loan> loans = new ArrayList<>();
        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                loans.add(new Loan(
                        rs.getInt("loanId"),
                        rs.getInt("customerId"),
                        rs.getDouble("principalAmount"),
                        rs.getDouble("interestRate"),
                        rs.getInt("loanTerm"),
                        rs.getDate("loanStartDate").toLocalDate(), // Convert SQL Date to LocalDate
                        rs.getString("loanType"),
                        rs.getString("loanStatus")
                ));
            }
        }
        return loans;
    }
}
