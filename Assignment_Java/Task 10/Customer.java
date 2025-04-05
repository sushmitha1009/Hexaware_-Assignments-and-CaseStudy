package entity;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

    // Default Constructor
    public Customer() {
    }

    // Parameterized Constructor
    public Customer(int customerId, String firstName, String lastName, String email, String phoneNumber, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.address = address;
    }

    // Getters and Setters
    public int getCustomerId() {

        return customerId;
    }

    public void setCustomerId(int customerId) {

        this.customerId = customerId;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
            if(phoneNumber!=null && phoneNumber.matches("\\d{10}")){
                this.phoneNumber = phoneNumber;
            }
            else{
                throw new IllegalArgumentException("Invalid phone number (must contains 10 digits)");
            }
    }
    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    // Method to Print Customer Information
    public void printCustomerDetails() {
        System.out.println("\n--- Customer Details ---");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Address: " + address);
    }
}
