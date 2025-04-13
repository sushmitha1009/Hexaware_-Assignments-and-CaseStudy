package bean;

public class Customer {
    private long customerId;
    private String name;
    private String contactNumber;

    // Constructor expecting a long for customer ID
    public Customer(long customerId, String name, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
