package bean;

import java.time.LocalDateTime;

public class Transaction {
    private long transactionId;
    private long accountNumber;
    private String type; // e.g., "Deposit", "Withdrawal", "Transfer"
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(long transactionId, long accountNumber, String type, double amount, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                ", Account Number: " + accountNumber +
                ", Type: " + type +
                ", Amount: " + amount +
                ", Timestamp: " + timestamp;
    }
}
