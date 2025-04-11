package test;

import static org.junit.jupiter.api.Assertions.*;

import myexceptions.CarNotFoundException;
import myexceptions.CustomerNotFoundException;
import myexceptions.LeaseNotFoundException;
import org.junit.jupiter.api.Test;
import dao.ICarLeaseRepository;
import dao.ICarLeaseRepositoryImpl;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionHandlingTest {

    @Test
    public void testCarNotFoundException() throws SQLException, IOException, ClassNotFoundException {
        // Arrange
        ICarLeaseRepository repository = new ICarLeaseRepositoryImpl();
        int invalidCarId = 999; // An ID that doesn't exist

        // Act & Assert
        assertThrows(CarNotFoundException.class, () -> {
            repository.findCarById(invalidCarId);
        }, "CarNotFoundException should be thrown for an invalid car ID");
    }

    @Test
    public void testCustomerNotFoundException() throws SQLException, IOException, ClassNotFoundException {
        // Arrange
        ICarLeaseRepository repository = new ICarLeaseRepositoryImpl();
        int invalidCustomerId = 999; // An ID that doesn't exist

        // Act & Assert
        assertThrows(CustomerNotFoundException.class, () -> {
            repository.findCustomerById(invalidCustomerId);
        }, "CustomerNotFoundException should be thrown for an invalid customer ID");
    }

    @Test
    public void testLeaseNotFoundException() throws SQLException, IOException, ClassNotFoundException {
        // Arrange
        ICarLeaseRepository repository = new ICarLeaseRepositoryImpl();
        int invalidLeaseId = 999; // An ID that doesn't exist

        // Act & Assert
        assertThrows(LeaseNotFoundException.class, () -> {
            repository.findLeaseById(invalidLeaseId);
        }, "LeaseNotFoundException should be thrown for an invalid lease ID");
    }
}
