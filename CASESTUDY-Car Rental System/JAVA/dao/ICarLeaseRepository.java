package dao;

import entity.Vehicle;
import entity.customer;
import entity.lease;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ICarLeaseRepository {

    // Car Management
    void addCar(Vehicle car) throws SQLException, IOException, ClassNotFoundException;
    void removeCar(int carID) throws SQLException, IOException, ClassNotFoundException;
    List<Vehicle> listAvailableCars() throws SQLException, IOException, ClassNotFoundException;
    List<Vehicle> listRentedCars() throws SQLException, IOException, ClassNotFoundException;
    Vehicle findCarById(int carID) throws SQLException, IOException, ClassNotFoundException;

    // Customer Management
    void addCustomer(customer cust) throws SQLException, IOException, ClassNotFoundException;
    void removeCustomer(int customerID) throws SQLException, IOException, ClassNotFoundException;
    List<customer> listCustomers() throws SQLException, IOException, ClassNotFoundException;
    customer findCustomerById(int customerID) throws SQLException, IOException, ClassNotFoundException;

    // Lease Management
    lease createLease(int customerID, int carID, String startDate, String endDate) throws SQLException, IOException, ClassNotFoundException;
    lease returnCar(int leaseID) throws SQLException, IOException, ClassNotFoundException;
    List<lease> listActiveLeases() throws SQLException, IOException, ClassNotFoundException;
    List<lease> listLeaseHistory() throws SQLException, IOException, ClassNotFoundException;

    // Payment Handling
    void recordPayment(lease lease, double amount) throws SQLException, IOException, ClassNotFoundException;
}
