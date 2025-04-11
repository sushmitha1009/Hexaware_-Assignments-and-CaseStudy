package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dao.ICarLeaseRepository;
import dao.ICarLeaseRepositoryImpl;
import entity.Vehicle;

import java.io.IOException;
import java.sql.SQLException;

public class CarServiceTest {

    @Test
    public void testCarCreatedSuccessfully() throws SQLException, IOException, ClassNotFoundException {
        // Arrange
        ICarLeaseRepository repository = new ICarLeaseRepositoryImpl();
        Vehicle newCar = new Vehicle(11, "Tesla", "Model S", 2023, "Available", 150.00, 5, 75.0);

        // Act
        boolean isAdded = repository.addCar(newCar);

        // Assert
        assertTrue(isAdded, "Car should be added successfully");
    }
}