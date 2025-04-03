package entity;

public class payment {
    private int payment_id;
    private int lease_id;
    private String payment_date;
    private double amount;

    // Default constructor
    public payment() {}

    // Parameterized constructor
    public payment(int payment_id, int lease_id, String payment_date, double amount) {
        this.payment_id = payment_id;
        this.lease_id = lease_id;
        this.payment_date = payment_date;
        this.amount = amount;
    }

    // Getters and Setters
    public int getPayment_id() {
        return payment_id;
    }
    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getLease_id() {
        return lease_id;
    }
    public void setLease_id(int lease_id) {
        this.lease_id = lease_id;
    }

    public String getPayment_date() {
        return payment_date;
    }
    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
