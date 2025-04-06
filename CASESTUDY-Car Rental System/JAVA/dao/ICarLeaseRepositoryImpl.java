package dao;

import entity.customer;
import entity.lease;
import entity.payment;
import entity.Vehicle;
import util.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ICarLeaseRepositoryImpl implements ICarLeaseRepository {
    //car management
    @Override
    public void addCar(Vehicle car) throws SQLException, IOException, ClassNotFoundException {
        String query = "INSERT INTO vehicle (vehicle_id, make, model, year,  dailyRate, status,passengerCapacity, engineCapacity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, car.getVehicle_id());
        ps.setString(2, car.getMake());
        ps.setString(3, car.getModel());
        ps.setInt(4, car.getYear());
        ps.setString(5, car.getStatus());
        ps.setDouble(6, car.getDailyRate());
        ps.setInt(7, car.getPassengerCapacity());
        ps.setDouble(8, car.getEngineCapacity());
        ps.executeUpdate();
        System.out.println("Car added successfully");
    }

    @Override
    public void removeCar(int carID) throws SQLException, IOException, ClassNotFoundException {
        String query = "DELETE from vehicle where vehicle_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, carID);
        ps.executeUpdate();
        System.out.println("Car removed successfully");

    }

    @Override
    public List<Vehicle> listAvailableCars() throws SQLException, IOException, ClassNotFoundException {
        List<Vehicle> availcars = new ArrayList<>();
        String query = "SELECT * from vehicle where status='Available'";
        Connection conn = DBConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Vehicle car = new Vehicle(
                    rs.getInt("vehicle_id"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getInt("year"),
                    rs.getString("status"),
                    rs.getDouble("dailyRate"),
                    rs.getInt("passengerCapacity"),
                    rs.getDouble("engineCapacity")
            );
            availcars.add(car);
        }
        return availcars;
    }

    @Override
    public List<Vehicle> listRentedCars() throws SQLException, IOException, ClassNotFoundException {
        List<Vehicle> rentedcars = new ArrayList<>();
        String sql = "Select * from Vehicle where status='notAvailable'";
        Connection conn = DBConnection.getConnection();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Vehicle car = new Vehicle(
                    rs.getInt("vehicle_id"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getInt("year"),
                    rs.getString("status"),
                    rs.getDouble("dailyRate"),
                    rs.getInt("passengerCapacity"),
                    rs.getDouble("engineCapacity")
            );
            rentedcars.add(car);
        }
        return rentedcars;
    }

    @Override
    public Vehicle findCarById(int carID) throws SQLException, IOException, ClassNotFoundException {
        String sql = "select * from Vehicle where vehicle_id=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, carID);
        ResultSet rs = ps.executeQuery();
        Vehicle car=null;
        if (rs.next()) {
            car = new Vehicle(
                    rs.getInt("vehicle_id"),
                    rs.getString("make"),
                    rs.getString("model"),
                    rs.getInt("year"),
                    rs.getString("status"),
                    rs.getDouble("dailyRate"),
                    rs.getInt("passengerCapacity"),
                    rs.getDouble("engineCapacity")
            );
        }
        return car;
    }

        //customer management

        @Override
        public void addCustomer (customer cust) throws SQLException, IOException, ClassNotFoundException {
            String query = "INSERT INTO customer (firstname, lastname, email, phone, licenseNumber) VALUES (?, ?, ?, ?, ?)";
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cust.getFirstName());
            ps.setString(2, cust.getLastName());
            ps.setString(3, cust.getEmail());
            ps.setString(4, cust.getPhoneNumber());
            ps.setString(5, cust.getLicenseNumber());
            ps.executeUpdate();
            System.out.println("Customer added successfully.");
        }

        @Override
        public void removeCustomer ( int customerID) throws SQLException, IOException, ClassNotFoundException {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM customer WHERE customer_id = ?");
            pstmt.setInt(1, customerID);
            pstmt.executeUpdate();
        }

        @Override
        public List<customer> listCustomers () throws SQLException, IOException, ClassNotFoundException {
            List<customer> customers = new ArrayList<>();
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customer");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                customer cust = new customer(
                        rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        "" // licenseNumber placeholder
                );
                customers.add(cust);
            }
            return customers;
        }

        @Override
        public customer findCustomerById ( int customerID) throws SQLException, IOException, ClassNotFoundException {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customer WHERE customer_id = ?");
            pstmt.setInt(1, customerID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new customer(
                        rs.getInt("customer_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        "" // licenseNumber placeholder
                );
            }
            return null;
        }

        //lease management
        @Override
        public lease createLease ( int customerID, int carID, String startDate, String endDate) throws
        SQLException, IOException, ClassNotFoundException {
            lease lease = null;
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO lease(vehicle_id, customer_id, startDate, endDate, type) VALUES (?, ?, ?, ?, 'Dailylease')",
                    Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, carID);
            pstmt.setInt(2, customerID);
            pstmt.setInt(3, Integer.parseInt(startDate.replace("-", "")));
            pstmt.setInt(4, Integer.parseInt(endDate.replace("-", "")));

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int leaseId = rs.getInt(1);
                    lease = new lease(leaseId, carID, customerID, Integer.parseInt(startDate.replace("-", "")), Integer.parseInt(endDate.replace("-", "")), "Dailylease");

                    PreparedStatement updateStatus = conn.prepareStatement("UPDATE vehicle SET status = 'notAvailable' WHERE vehicle_id = ?");
                    updateStatus.setInt(1, carID);
                    updateStatus.executeUpdate();
                }
            }
            return lease;
        }

        @Override
        public lease returnCar ( int leaseID) throws SQLException, IOException, ClassNotFoundException {
            lease lease = null;
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM lease WHERE lease_id = ?");
            pstmt.setInt(1, leaseID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int vehicleId = rs.getInt("vehicle_id");

                PreparedStatement updateVehicle = conn.prepareStatement("UPDATE vehicle SET status = 'Available' WHERE vehicle_id = ?");
                updateVehicle.setInt(1, vehicleId);
                updateVehicle.executeUpdate();

                lease = new lease(
                        rs.getInt("lease_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getString("type")
                );
            }
            return lease;
        }

        @Override
        public List<lease> listActiveLeases () throws SQLException, IOException, ClassNotFoundException {
            List<lease> leases = new ArrayList<>();
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM lease WHERE endDate >= ?");
            int today = Integer.parseInt(java.time.LocalDate.now().toString().replace("-", ""));
            pstmt.setInt(1, today);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                lease l = new lease(
                        rs.getInt("lease_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getString("type")
                );
                leases.add(l);
            }
            return leases;
        }

        @Override
        public List<lease> listLeaseHistory () throws SQLException, IOException, ClassNotFoundException {
            List<lease> leases = new ArrayList<>();
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM lease");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                lease l = new lease(
                        rs.getInt("lease_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("startDate"),
                        rs.getInt("endDate"),
                        rs.getString("type")
                );
                leases.add(l);
            }
            return leases;
        }

        //payment handling
        @Override
        public void recordPayment (lease lease,double amount) throws SQLException, IOException, ClassNotFoundException {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO payment(lease_id, payment_date, amount) VALUES (?, ?, ?)");

            pstmt.setInt(1, lease.getLease_id());
            pstmt.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            pstmt.setDouble(3, amount);
            pstmt.executeUpdate();
        }
}