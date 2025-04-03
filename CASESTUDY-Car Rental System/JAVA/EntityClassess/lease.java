package entity;

public class lease {
    private int lease_id;
    private int vehicle_id;
    private int customer_id;
    private int startDate;
    private int endDate;
    private String type;

    // Default constructor
    public lease() {}

    // Parameterized constructor
    public lease(int lease_id, int vehicle_id, int customer_id, int startDate, int endDate, String type) {
        this.lease_id = lease_id;
        this.vehicle_id = vehicle_id;
        this.customer_id = customer_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    // Getters and Setters
    public int getLease_id() { return lease_id; }
    public void setLease_id(int lease_id) { this.lease_id = lease_id; }

    public int getVehicle_id() {
        return vehicle_id;
    }
    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getStartDate() {
        return startDate;
    }
    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }
    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
